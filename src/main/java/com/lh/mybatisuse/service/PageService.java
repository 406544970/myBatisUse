package com.lh.mybatisuse.service;

import com.lh.mybatisuse.model.InPutParam.PageVersionInsertInParam;
import com.lh.mybatisuse.model.PageModel;

import java.util.List;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-02 20:46
 * @function
 * @editLog
 */
public interface PageService {
    /**
     * 得到需要更新的版本信息
     *
     * @param pageKey 主键
     * @return 页面ID
     */
    List<PageModel> selectVersionList(List<String> pageKey);

    List<PageModel> selectVersionInsertList(PageVersionInsertInParam pageVersionInsertInParam);
}
