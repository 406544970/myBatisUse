package com.lh.mybatisuse.model.InPutParam;

import java.util.Date;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-09 09:18
 * @function
 * @editLog
 */
public class MyBatisUseUpdateInParam {
    /**
     * 主键
     */
    private String id;
    /**
     * 主键, Where字段
     */
    private String idWhere;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 昵称, Where字段
     */
    private String nickNameWhere;
    /**
     * 账号
     */
    private String useName;
    /**
     * 账号, Where字段
     */
    private String useNameWhere;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 密码, Where字段
     */
    private String passWordWhere;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 手机号, Where字段
     */
    private String mobileWhere;
    /**
     * 邮件
     */
    private String email;
    /**
     * 邮件, Where字段
     */
    private String emailWhere;
    /**
     * 使用结束日期
     */
    private Date endDate;
    /**
     * 使用结束日期, Where字段
     */
    private Date endDateWhere;
    /**
     * 所在公司名称
     */
    private String companyName;
    /**
     * 所在公司名称, Where字段
     */
    private String companyNameWhere;
    /**
     * 用户类型
     */
    private String roleId;
    /**
     * 用户类型, Where字段
     */
    private String roleIdWhere;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 是否停用, Where字段
     */
    private Boolean stopSignWhere;
    /**
     * 创建时间
     */
    private Date workTime;
    /**
     * 创建时间, Where字段
     */
    private Date workTimeWhere;

    public String getId(){
        return id;
    }
    public String getIdWhere(){
        return idWhere;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setIdWhere(String idWhere){
        this.idWhere = idWhere;
    }

    public String getNickName(){
        return nickName;
    }
    public String getNickNameWhere(){
        return nickNameWhere;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public void setNickNameWhere(String nickNameWhere){
        this.nickNameWhere = nickNameWhere;
    }

    public String getUseName(){
        return useName;
    }
    public String getUseNameWhere(){
        return useNameWhere;
    }
    public void setUseName(String useName){
        this.useName = useName;
    }
    public void setUseNameWhere(String useNameWhere){
        this.useNameWhere = useNameWhere;
    }

    public String getPassWord(){
        return passWord;
    }
    public String getPassWordWhere(){
        return passWordWhere;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public void setPassWordWhere(String passWordWhere){
        this.passWordWhere = passWordWhere;
    }

    public String getMobile(){
        return mobile;
    }
    public String getMobileWhere(){
        return mobileWhere;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public void setMobileWhere(String mobileWhere){
        this.mobileWhere = mobileWhere;
    }

    public String getEmail(){
        return email;
    }
    public String getEmailWhere(){
        return emailWhere;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setEmailWhere(String emailWhere){
        this.emailWhere = emailWhere;
    }

    public Date getEndDate(){
        return endDate;
    }
    public Date getEndDateWhere(){
        return endDateWhere;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    public void setEndDateWhere(Date endDateWhere){
        this.endDateWhere = endDateWhere;
    }

    public String getCompanyName(){
        return companyName;
    }
    public String getCompanyNameWhere(){
        return companyNameWhere;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public void setCompanyNameWhere(String companyNameWhere){
        this.companyNameWhere = companyNameWhere;
    }

    public String getRoleId(){
        return roleId;
    }
    public String getRoleIdWhere(){
        return roleIdWhere;
    }
    public void setRoleId(String roleId){
        this.roleId = roleId;
    }
    public void setRoleIdWhere(String roleIdWhere){
        this.roleIdWhere = roleIdWhere;
    }

    public Boolean getStopSign(){
        return stopSign;
    }
    public Boolean getStopSignWhere(){
        return stopSignWhere;
    }
    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }
    public void setStopSignWhere(Boolean stopSignWhere){
        this.stopSignWhere = stopSignWhere;
    }

    public Date getWorkTime(){
        return workTime;
    }
    public Date getWorkTimeWhere(){
        return workTimeWhere;
    }
    public void setWorkTime(Date workTime){
        this.workTime = workTime;
    }
    public void setWorkTimeWhere(Date workTimeWhere){
        this.workTimeWhere = workTimeWhere;
    }
}
