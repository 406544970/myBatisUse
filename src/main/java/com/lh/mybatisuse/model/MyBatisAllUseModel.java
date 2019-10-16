package com.lh.mybatisuse.model;


/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-16 11:02
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
     * 是否停用
     */
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


    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }
}
