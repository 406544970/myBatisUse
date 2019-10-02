package com.lh.mybatisuse.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-22 09:47
 * @function
 * @editLog
 */
public class DictionaryDeleteInParam {
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
