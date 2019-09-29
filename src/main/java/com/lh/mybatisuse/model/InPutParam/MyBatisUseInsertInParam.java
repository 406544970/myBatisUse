package com.lh.mybatisuse.model.InPutParam;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-29 16:02
 * @function
 * @editLog
 */
public class MyBatisUseInsertInParam {
    /**
     * 用户ID
     */
    private String useId;
    /**
     * 用户类型
     */
    private String useType;
    /**
     * 客户端类型
     */
    private String clientType;
    /**
     * token
     */
    private String accessToken;
    /**
     * token有效期
     */
    private Date tokenEffective;

    public String getUseId(){
        return useId;
    }

    public void setUseId(String useId){
        this.useId = useId;
    }

    public String getUseType(){
        return useType;
    }

    public void setUseType(String useType){
        this.useType = useType;
    }

    public String getClientType(){
        return clientType;
    }

    public void setClientType(String clientType){
        this.clientType = clientType;
    }

    public String getAccessToken(){
        return accessToken;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public Date getTokenEffective(){
        return tokenEffective;
    }

    public void setTokenEffective(Date tokenEffective){
        this.tokenEffective = tokenEffective;
    }
}
