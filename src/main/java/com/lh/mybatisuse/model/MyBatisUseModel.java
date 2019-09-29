package com.lh.mybatisuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 12:23
 * @function
 * @editLog
 */
public class MyBatisUseModel {
    private String token;
    /**
     * 主键
     */
    private String id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    @JsonIgnore
    private String passWord;
    /**
     * 手机号
     */
    @JsonIgnore
    private String mobile;
    /**
     * 邮件
     */
    @JsonIgnore
    private String email;
    /**
     * 使用结束日期
     */
    @JsonIgnore
    private Date endDate;
    /**
     * 所在公司名称
     */
    private String companyName;
    /**
     * 用户类型
     */
    @JsonIgnore
    private String roleId;
    /**
     * 是否停用
     */
    @JsonIgnore
    private Boolean stopSign;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getRoleId(){
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
