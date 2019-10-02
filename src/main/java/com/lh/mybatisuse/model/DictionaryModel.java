package com.lh.mybatisuse.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:21
 * @function
 * @editLog
 */
public class DictionaryModel {
    /**
     * 主键
     */
    private String value;
    /**
     * 内容
     */
    private String label;
    /**
     * 是否选择
     */
    private Boolean defaultSelect;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public Boolean getDefaultSelect(){
        return defaultSelect;
    }

    public void setDefaultSelect(Boolean defaultSelect){
        this.defaultSelect = defaultSelect;
    }
}
