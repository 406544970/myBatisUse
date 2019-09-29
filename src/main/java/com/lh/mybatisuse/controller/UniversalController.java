package com.lh.mybatisuse.controller;

import com.lh.mybatisuse.unit.GetPropertiesClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static com.netflix.discovery.DiscoveryManager.getInstance;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 通用功能控制层
 * @editLog
 */
@RestController
@EnableEurekaClient
@RequestMapping("/universal")     // 通过这里配置使下面的映射都在/users下，可去除
@Api(value = "通用控制层", description = "专用于梁昊所要求的通用方法")
public class UniversalController {
    @Autowired
    GetPropertiesClass getPropertiesClass;

    @ApiOperation(value = "测试Feign熔断时间", notes = "hi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "timeOut", value = " 超时时间", required = true, dataType = "long")
    })
    @PostMapping("/testTimeOut")
    public String testTimeOut(@RequestParam(value = "timeOut") long timeOut) throws InterruptedException {
        Logger logger = Logger.getLogger("Feign:");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("Begin Feign :(" + timeOut + ")" + df.format(new Date()));
        Thread.sleep(timeOut);
        logger.info("End Feign :(" + timeOut + ")" + df.format(new Date()));
        return String.format("TimeOut : %d", timeOut);
    }

    /**
     * @return 返回当前版本号
     */
    @ApiOperation(value = "得到当前版本号", notes = "返回：当前版本号")
    @PostMapping("/myVersion")
    public String getVersion() {
        return String.format("My port is : %s; My version is : %s", getPropertiesClass.getPort(), getPropertiesClass.getVersion());
    }

    /**
     * @return 返回当前端口号
     */
    @ApiOperation(value = "得到当前端口号", notes = "返回：当前端口号")
    @PostMapping("/myPort")
    public String myPort() {
        return String.format("I am is port:%s", getPropertiesClass.getPort());
    }

    /**
     * @return 手动下线
     */
    @ApiOperation(value = "手动下线方法", notes = "返回：当前微服务名和端口号")
    @GetMapping("/downLine")
    public String downLine() {
        getInstance().shutdownComponent();
        return String.format("ApplicationName\"%s\"(Port:%s) is downLine.", getPropertiesClass.getApplicationName(), getPropertiesClass.getPort());
    }

    /**
     * @return 返回当前端口号
     */
    @ApiOperation(value = "得到参数标识", notes = "返回：参数标识")
    @PostMapping("/GetParamSign")
    public String GetParamSign() {
        return String.format("liangHaoSign:\"%s\"", getPropertiesClass.getLiangHaoSign());
    }
}
