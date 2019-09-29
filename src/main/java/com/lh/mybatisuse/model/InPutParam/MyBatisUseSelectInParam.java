package com.lh.mybatisuse.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 11:40
 * @function
 * @editLog
 */
public class MyBatisUseSelectInParam {
    /**
     * 表sys_useInfo,字段名useName:账号
     */
    private String useName;
    /**
     * 表sys_useInfo,字段名mobile:手机号
     */
    private String mobile;
    /**
     * 表sys_useInfo,字段名email:邮件
     */
    private String email;

    public String getUseName(){
        return useName;
    }

    public void setUseName(String useName){
        this.useName = useName;
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
}
