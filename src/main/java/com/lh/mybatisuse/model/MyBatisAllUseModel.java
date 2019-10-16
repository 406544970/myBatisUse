package com.lh.mybatisuse.model;


import java.util.Date;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-16 17:32
 * @function
 * @editLog
 */
public class MyBatisAllUseModel {
    /**
     * 主键
     */
    private String id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 账号
     */
    private String useName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮件
     */
    private String email;
    /**
     * 使用结束日期
     */
    private Date endDate;
    /**
     * 所在公司名称
     */
    private String companyName;
    /**
     * 用户类型
     */
    private String roleId;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 创建时间
     */
    private Date workTime;

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

    public String getUseName(){
        return useName;
    }

    public void setUseName(String useName){
        this.useName = useName;
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

    public Date getWorkTime(){
        return workTime;
    }

    public void setWorkTime(Date workTime){
        this.workTime = workTime;
    }
}
