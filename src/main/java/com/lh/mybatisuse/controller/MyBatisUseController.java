package com.lh.mybatisuse.controller;

import com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseSelectInParam;
import com.lh.mybatisuse.model.MyBatisUseModel;
import com.lh.mybatisuse.service.Impl.MyBatisUseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 11:43
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/myBatisUseController")
@Api(value = "用户层", description = "用户相关方法")
public class MyBatisUseController {
    @Autowired
    MyBatisUseServiceImpl myBatisUseServiceImpl;

    /**
     * 用户登录CS，方法ID：SE20190929112838909B3-04-31-E6-9C-3B
     *
     * @param num      表sys_useInfo,字段名useName:账号
     * @param passWord 表sys_useInfo,字段名passWord:密码
     * @return 用户信息
     */
    @ApiOperation(value = "用户登录", notes = "用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "账号", dataType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", dataType = "String", required = true)
    })
    @PostMapping("/useLogCS")
    public ResultVO useLogCS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return privateUseLog(num, passWord, false);
    }

    private ResultVO privateUseLog(String num
            , String passWord
            , boolean bsSign) {
        num = num == null ? num : num.trim();
        passWord = passWord == null ? passWord : passWord.trim();

        MyBatisUseSelectInParam myBatisUseSelectInParam = new MyBatisUseSelectInParam();
        myBatisUseSelectInParam.setUseName(num);
        myBatisUseSelectInParam.setMobile(num);
        myBatisUseSelectInParam.setEmail(num);

        MyBatisUseModel myBatisUseModel = myBatisUseServiceImpl.useLog(myBatisUseSelectInParam);
        if (myBatisUseModel == null) {
            return ResultStruct.error("无此用户！", ResultVO.class);
        }
        if (myBatisUseModel.getStopSign()) {
            return ResultStruct.error("此用户已停用！", ResultVO.class);
        }
        if (!passWord.equals(myBatisUseModel.getPassWord())) {
            return ResultStruct.error("密码错误！", ResultVO.class);
        }
        if (myBatisUseModel.getEndDate().before(new Date())) {
            return ResultStruct.error("用户账号已超期！", ResultVO.class);
        }

        MyBatisUseInsertInParam myBatisUseInsertInParam = new MyBatisUseInsertInParam();
        myBatisUseInsertInParam.setUseId(myBatisUseModel.getId());
        myBatisUseInsertInParam.setUseType(myBatisUseModel.getUseType());
        myBatisUseInsertInParam.setClientType(bsSign ? "BS" : "CS");
        String accessToken = UUID.randomUUID().toString();
        myBatisUseInsertInParam.setAccessToken(accessToken);
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");//获取北京时间
        Calendar c = Calendar.getInstance(timeZone);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(timeZone);
        c.add(Calendar.HOUR, 48);
        Date saveDate = c.getTime();
        String date = dateFormat.format(c.getTime());

        myBatisUseInsertInParam.setTokenEffective(saveDate);
        int repetitionCount = myBatisUseServiceImpl.updateAccessToken(myBatisUseInsertInParam);
        boolean saveSign = repetitionCount > 0 ? true : false;
        if (!saveSign) {
            repetitionCount = myBatisUseServiceImpl.insertIntoAccessToken(myBatisUseInsertInParam);
            saveSign = repetitionCount > 0 ? true : false;
        }
        if (saveSign) {
            myBatisUseModel.setToken(accessToken);
            myBatisUseModel.setTokenEffective(date);
            if (bsSign) {
                final String TokenName = "accessToken";
                final String UseId = "useId";
                final String UseType = "useType";
                final String ClientType = "clientType";
                final int seconds = 3600 * 2;
                HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
                HttpServletResponse response = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
                String myOrigin = request.getHeader("origin");
                myOrigin = getDoMain(myOrigin);
                Cookie tokenName = new Cookie(TokenName, accessToken);
                tokenName.setPath("/");
                tokenName.setDomain(myOrigin);
                tokenName.setMaxAge(seconds);
                response.addCookie(tokenName);

                Cookie useId = new Cookie(UseId, myBatisUseModel.getId());
                useId.setPath("/");
                useId.setDomain(myOrigin);
                useId.setMaxAge(seconds);
                response.addCookie(useId);

                Cookie useType = new Cookie(UseType, myBatisUseModel.getUseType());
                useType.setPath("/");
                useType.setDomain(myOrigin);
                useType.setMaxAge(seconds);
                response.addCookie(useType);

                Cookie clientType = new Cookie(ClientType, "BS");
                clientType.setPath("/");
                clientType.setDomain(myOrigin);
                clientType.setMaxAge(seconds);
                response.addCookie(clientType);
            }
            return ResultStruct.success(myBatisUseModel);
        }
        else
            return ResultStruct.error("登录失败!",ResultVO.class);
    }

    private String getDoMain(String myOrigin) {
        String newOrigin = myOrigin.replace("https://", "")
                .replace("http://", "");
        int i = newOrigin.indexOf(":");
        if (i > -1) {
            newOrigin = newOrigin.substring(0, i);
        }
        int index = newOrigin.indexOf(".");
        if (index > -1) {
            newOrigin = newOrigin.substring(index + 1);
        }
        return newOrigin;
    }
}
