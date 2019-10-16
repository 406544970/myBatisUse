package com.lh.mybatisuse.model;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-16 19:08
 * @function
 * @editLog
 */
public class DictionaryIniModel {
    /**
     * 主键
     */
    private String id;
    /**
     * 标识
     */
    private String signName;
    /**
     * 内容
     */
    private String contentName;
    /**
     * 是否选择
     */
    private Boolean defaultSelect;
    /**
     * 出现顺序
     */
    private Integer sortNo;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 备注
     */
    private String remark;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getSignName(){
        return signName;
    }

    public void setSignName(String signName){
        this.signName = signName;
    }

    public String getContentName(){
        return contentName;
    }

    public void setContentName(String contentName){
        this.contentName = contentName;
    }

    public Boolean getDefaultSelect(){
        return defaultSelect;
    }

    public void setDefaultSelect(Boolean defaultSelect){
        this.defaultSelect = defaultSelect;
    }

    public Integer getSortNo(){
        return sortNo;
    }

    public void setSortNo(Integer sortNo){
        this.sortNo = sortNo;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}
