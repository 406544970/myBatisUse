package com.lh.mybatisuse.model.InPutParam;

/**
 * @author 梁昊
 * @date 2019/10/2
 * @function
 * @editLog
 */
public class PageVersionInParam {
    /**
     * 主键
     */
    private String pageKey;
    /**
     * 页面版本
     */
    private Integer pageVersion;

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public Integer getPageVersion() {
        return pageVersion;
    }

    public void setPageVersion(Integer pageVersion) {
        this.pageVersion = pageVersion;
    }
}
