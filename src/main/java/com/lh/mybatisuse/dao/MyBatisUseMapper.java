package com.lh.mybatisuse.dao;

import com.lh.mybatisuse.model.InPutParam.MyBatisUseInsertInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseSelectInParam;
import com.lh.mybatisuse.model.InPutParam.MyBatisUseUpdateInParam;
import com.lh.mybatisuse.model.MyBatisUseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 11:42
 * @function
 * @editLog
 */
@Mapper
public interface MyBatisUseMapper {
    /**
     * 得到用户ID
     *
     * @param roleId 输入参数
     * @return 用户信息对象
     */
    List<String> selectUseNickNameList(@Param("roleId") String roleId);

    /**
     * 得到用户ID
     *
     * @param nickName 昵称
     * @return 用户信息对象
     */
    String selectUseId(@Param("nickName") String nickName);

    /**
     * 用户登录
     *
     * @param myBatisUseSelectInParam 输入参数
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

}
