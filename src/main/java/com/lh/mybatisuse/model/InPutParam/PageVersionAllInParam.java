package com.lh.mybatisuse.model.InPutParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/10/2
 * @function
 * @editLog
 */
@ApiModel(value = "pageVersionAllInParam", description = "版本对比参数类")
public class PageVersionAllInParam {
    @ApiModelProperty(value = "页面ID与版本号")
    private List<PageVersionInParam> pageKey;
    @ApiModelProperty(value = "当前用户ID", required = true)
    private String useId;

    public List<PageVersionInParam> getPageKey() {
        return pageKey;
    }

    public void setPageKey(List<PageVersionInParam> pageKey) {
        this.pageKey = pageKey;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }
}
