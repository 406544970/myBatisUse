package com.lh.mybatisuse.model.InPutParam;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/10/2
 * @function
 * @editLog
 */
public class PageVersionInsertInParam {
    /**
     * 主键
     */
    private List<String> pageKey;
    private String useId;

    public List<String> getPageKey() {
        return pageKey;
    }

    public void setPageKey(List<String> pageKey) {
        this.pageKey = pageKey;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }
}
