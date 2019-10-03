package com.lh.mybatisuse.model.InPutParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/10/3
 * @function
 * @editLog
 */
@ApiModel(value = "PageVersionListInParam", description = "版本对比参数类")
public class PageVersionListInParam {
    @ApiModelProperty(value = "页面ID与版本号")
    private List<PageVersionInParam> pageKey;

    public List<PageVersionInParam> getPageKey() {
        return pageKey;
    }

    public void setPageKey(List<PageVersionInParam> pageKey) {
        this.pageKey = pageKey;
    }
}
