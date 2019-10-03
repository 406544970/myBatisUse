package com.lh.mybatisuse.service.Impl;

import com.lh.mybatisuse.dao.PageMapper;
import com.lh.mybatisuse.model.InPutParam.PageInsertInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionInsertInParam;
import com.lh.mybatisuse.model.PageModel;
import com.lh.mybatisuse.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-02 20:46
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageMapper pageMapper;
    /**
     * 得到需要更新的版本信息
     *
     * @param pageKey 主键
     * @return 页面ID
     */
    @Override
    public List<PageModel> selectVersionList(List<String> pageKey) {
        return pageMapper.selectVersionList(pageKey);
    }

    @Override
    public List<PageModel> selectVersionInsertList(PageVersionInsertInParam pageVersionInsertInParam) {
        return pageMapper.selectVersionInsertList(pageVersionInsertInParam);
    }

    /**
     * 增加页面到远程
     *
     * @param pageInsertInParam com.lh.mybatisuse.model.InPutParam.PageInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertPage (PageInsertInParam pageInsertInParam) {
        return pageMapper.insertPage(pageInsertInParam);
    }

    /**
     * 增加页面到远程
     *
     * @param pageInsertInParam com.lh.mybatisuse.model.InPutParam.PageInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertPageBeforeCheck(PageInsertInParam pageInsertInParam) {
        return pageMapper.insertPageBeforeCheck(pageInsertInParam);
    }

    /**
     * 更新页面到远程
     *
     * @param pageInsertInParam com.lh.mybatisuse.model.InPutParam.PageInsertInParam
     * @return 影响条数
     */
    @Override
    public int updatePageAndXml (PageInsertInParam pageInsertInParam) {
        return pageMapper.updatePageAndXml(pageInsertInParam);
    }

    /**
     * 删除远程页面
     *
     * @param pageInsertInParam com.lh.mybatisuse.model.InPutParam.PageInsertInParam
     * @return 影响条数
     */
    @Override
    public int deletePageAndXml (PageInsertInParam pageInsertInParam) {
        return pageMapper.deletePageAndXml(pageInsertInParam);
    }

}
