package com.lh.mybatisuse.service;

import com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseSelectInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseUpdateInParam;
import com.lh.mybatisuse.model.MyBatisAllUseModel;
import com.lh.mybatisuse.model.MyBatisUseModel;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 11:43
 * @function
 * @editLog
 */
public interface MyBatisUseService {
    /**
     * 得到用户ID
     *
     * @param roleId 角色
     * @return 用户信息对象
     */
    List<String> selectUseNickNameList(String roleId);

    /**
     * 得到用户ID
     *
     * @param nickName 昵称
     * @return 用户信息对象
     */
    String selectUseId(String nickName);

    /**
     * 用户登录
     *
     * @param myBatisUseSelectInParam 用户登录
     * @return 用户信息
     */
    MyBatisUseModel useLog(MyBatisUseSelectInParam myBatisUseSelectInParam);
    /**
     * 增加或修改Token
     *
     * @param myBatisUseInsertInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam
     * @return 对象
     */
    int insertIntoAccessToken(MyBatisUseInsertInParam myBatisUseInsertInParam);

    /**
     * 修改Token
     *
     * @param myBatisUseInsertInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam
     * @return 影响条数
     */
    int updateAccessToken(MyBatisUseInsertInParam myBatisUseInsertInParam);
    /**
     * 修改密码
     *
     * @param myBatisUseUpdateInParam com.lh.mybatisuse.model.InPutParam.MyBatisUseUpdateInParam
     * @return 是否成功
     */
    int updatePassWord(MyBatisUseUpdateInParam myBatisUseUpdateInParam);
    /**
     * 下载该公司所有用户
     *
     * @param companyName 所在公司名称
     * @return 该公司所有用户列表
     */
    List<MyBatisAllUseModel> downAllUseByCompany(String companyName);

}
