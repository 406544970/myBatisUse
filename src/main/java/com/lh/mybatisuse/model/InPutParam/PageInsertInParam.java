package com.lh.mybatisuse.model.InPutParam;

import java.util.Date;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-03 13:37
 * @function
 * @editLog
 */
public class PageInsertInParam {
    /**
     * 主键
     */
    private String pageKey;
    /**
     * 项目名称
     */
    private String projectId;
    /**
     * 页面类型
     */
    private String pageType;
    /**
     * 页面版本
     */
    private Integer pageVersion;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    /**
     * 创建者
     */
    private String createOperator;
    /**
     * 创建者ID
     */
    private String createOperatorId;
    /**
     * 后台开发员
     */
    private String doOperator;
    /**
     * 后台开发ID
     */
    private String doOperatorId;
    /**
     * 前端开发员
     */
    private String frontOperator;
    /**
     * 前端开发ID
     */
    private String frontOperatorId;
    /**
     * 完成比较
     */
    private Integer finishCount;
    /**
     * 是否只读
     */
    private Boolean readOnly;
    /**
     * 方法说明
     */
    private String methodRemark;

    public String getPageKey(){
        return pageKey;
    }

    public void setPageKey(String pageKey){
        this.pageKey = pageKey;
    }

    public String getProjectId(){
        return projectId;
    }

    public void setProjectId(String projectId){
        this.projectId = projectId;
    }

    public String getPageType(){
        return pageType;
    }

    public void setPageType(String pageType){
        this.pageType = pageType;
    }

    public Integer getPageVersion(){
        return pageVersion;
    }

    public void setPageVersion(Integer pageVersion){
        this.pageVersion = pageVersion;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getLastUpdateTime(){
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreateOperator(){
        return createOperator;
    }

    public void setCreateOperator(String createOperator){
        this.createOperator = createOperator;
    }

    public String getCreateOperatorId(){
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId){
        this.createOperatorId = createOperatorId;
    }

    public String getDoOperator(){
        return doOperator;
    }

    public void setDoOperator(String doOperator){
        this.doOperator = doOperator;
    }

    public String getDoOperatorId(){
        return doOperatorId;
    }

    public void setDoOperatorId(String doOperatorId){
        this.doOperatorId = doOperatorId;
    }

    public String getFrontOperator(){
        return frontOperator;
    }

    public void setFrontOperator(String frontOperator){
        this.frontOperator = frontOperator;
    }

    public String getFrontOperatorId(){
        return frontOperatorId;
    }

    public void setFrontOperatorId(String frontOperatorId){
        this.frontOperatorId = frontOperatorId;
    }

    public Integer getFinishCount(){
        return finishCount;
    }

    public void setFinishCount(Integer finishCount){
        this.finishCount = finishCount;
    }

    public Boolean getReadOnly(){
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly){
        this.readOnly = readOnly;
    }

    public String getMethodRemark(){
        return methodRemark;
    }

    public void setMethodRemark(String methodRemark){
        this.methodRemark = methodRemark;
    }
}
