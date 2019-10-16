package com.lh.mybatisuse.service.Impl;

import com.lh.mybatisuse.dao.MyBatisUseMapper;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseSelectInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseUpdateInParam;
import com.lh.mybatisuse.model.MyBatisAllUseModel;
import com.lh.mybatisuse.model.MyBatisUseModel;
import com.lh.mybatisuse.service.MyBatisUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 11:43
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class MyBatisUseServiceImpl implements MyBatisUseService {
    @Autowired
    MyBatisUseMapper myBatisUseMapper;
    /**
     * 得到用户ID
     *
     * @param roleId 得到用户ID
     * @return 用户信息对象
     */
    @Override
    public List<String> selectUseNickNameList(String roleId) {
        return myBatisUseMapper.selectUseNickNameList(roleId);
    }

    /**
     * 得到用户ID
     *
     * @param nickName 昵称
     * @return 用户信息对象
     */
    @Override
    public String selectUseId(String nickName) {
        return myBatisUseMapper.selectUseId(nickName);
    }

    /**
     * 用户登录
     *
     * @param myBatisUseSelectInParam 用户登录
     * @return 用户信息
     */
    @Override
    public MyBatisUseModel useLog(MyBatisUseSelectInParam myBatisUseSelectInParam) {
        return myBatisUseMapper.useLog(myBatisUseSelectInParam);
    }

    /**
     * 增加或修改Token
     *
     * @param myBatisUseInsertInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam
     * @return 对象
     */
    @Override
    public int insertIntoAccessToken (MyBatisUseInsertInParam myBatisUseInsertInParam) {
        return myBatisUseMapper.insertIntoAccessToken(myBatisUseInsertInParam);
    }

    /**
     * 修改Token
     *
     * @param myBatisUseInsertInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam
     * @return 影响条数
     */
    @Override
    public int updateAccessToken (MyBatisUseInsertInParam myBatisUseInsertInParam) {
        return myBatisUseMapper.updateAccessToken(myBatisUseInsertInParam);
    }

    /**
     * 修改密码
     *
     * @param myBatisUseUpdateInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseUpdateInParam
     * @return 是否成功
     */
    @Override
    public int updatePassWord (MyBatisUseUpdateInParam myBatisUseUpdateInParam) {
        return myBatisUseMapper.updatePassWord(myBatisUseUpdateInParam);
    }
    /**
     * 下载该公司所有用户
     *
     * @param companyName 所在公司名称
     * @return 该公司所有用户列表
     */
    @Override
    public List<MyBatisAllUseModel> downAllUseByCompany(String companyName) {
        return myBatisUseMapper.downAllUseByCompany(companyName);
    }

}
