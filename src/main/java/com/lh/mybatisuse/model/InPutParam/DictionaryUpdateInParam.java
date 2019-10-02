package com.lh.mybatisuse.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-22 08:31
 * @function
 * @editLog
 */
public class DictionaryUpdateInParam {
    /**
     * 主键
     */
    private String id;
    /**
     * 主键, Where字段
     */
    private String idWhere;
    /**
     * 标识
     */
    private String signName;
    /**
     * 标识, Where字段
     */
    private String signNameWhere;
    /**
     * 内容
     */
    private String contentName;
    /**
     * 内容, Where字段
     */
    private String contentNameWhere;
    /**
     * 是否选择
     */
    private Boolean defaultSelect;
    /**
     * 是否选择, Where字段
     */
    private Boolean defaultSelectWhere;
    /**
     * 出现顺序
     */
    private Integer sortNo;
    /**
     * 出现顺序, Where字段
     */
    private Integer sortNoWhere;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 是否停用, Where字段
     */
    private Boolean stopSignWhere;
    /**
     * 备注
     */
    private String remark;
    /**
     * 备注, Where字段
     */
    private String remarkWhere;

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

    public String getSignName(){
        return signName;
    }
    public String getSignNameWhere(){
        return signNameWhere;
    }
    public void setSignName(String signName){
        this.signName = signName;
    }
    public void setSignNameWhere(String signNameWhere){
        this.signNameWhere = signNameWhere;
    }

    public String getContentName(){
        return contentName;
    }
    public String getContentNameWhere(){
        return contentNameWhere;
    }
    public void setContentName(String contentName){
        this.contentName = contentName;
    }
    public void setContentNameWhere(String contentNameWhere){
        this.contentNameWhere = contentNameWhere;
    }

    public Boolean getDefaultSelect(){
        return defaultSelect;
    }
    public Boolean getDefaultSelectWhere(){
        return defaultSelectWhere;
    }
    public void setDefaultSelect(Boolean defaultSelect){
        this.defaultSelect = defaultSelect;
    }
    public void setDefaultSelectWhere(Boolean defaultSelectWhere){
        this.defaultSelectWhere = defaultSelectWhere;
    }

    public Integer getSortNo(){
        return sortNo;
    }
    public Integer getSortNoWhere(){
        return sortNoWhere;
    }
    public void setSortNo(Integer sortNo){
        this.sortNo = sortNo;
    }
    public void setSortNoWhere(Integer sortNoWhere){
        this.sortNoWhere = sortNoWhere;
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

    public String getRemark(){
        return remark;
    }
    public String getRemarkWhere(){
        return remarkWhere;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public void setRemarkWhere(String remarkWhere){
        this.remarkWhere = remarkWhere;
    }
}
