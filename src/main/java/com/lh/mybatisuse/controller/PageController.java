package com.lh.mybatisuse.controller;

import com.lh.mybatisuse.model.InPutParam.PageVersionAllInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionInsertInParam;
import com.lh.mybatisuse.model.PageModel;
import com.lh.mybatisuse.service.PageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-02 20:46
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/pageController")
@Api(value = "页面控制层", description = "页面控制方法")
public class PageController {
    @Autowired
    PageService pageService;

    /**
     * 得到需要更新的版本信息，方法ID：SE2019100218372321158B1B17A5A33
     *
     * @param pageVersionAllInParam 表vou_pageInfomation,对象集合
     * @return 页面ID
     */
    @ApiOperation(value = "得到需要更新的版本信息", notes = "页面ID")
    @PostMapping("/selectVersionList")
    public ResultVO selectVersionList(@RequestBody @ApiParam(name = "pageVersionAllInParam", value = "传入PageVersionAllInParam格式", required = true)
                                              PageVersionAllInParam pageVersionAllInParam) {
        if (pageVersionAllInParam == null) {
            return ResultStruct.error("参数传递有误！", ResultVO.class);
        }

        List<PageModel> resultList = new ArrayList<>();
        if (pageVersionAllInParam.getUseId() != null) {
            pageVersionAllInParam.setUseId(pageVersionAllInParam.getUseId());
        }

        List<String> pageKeys = null;
        List<PageVersionInParam> pageVersionInParams = null;
        if (pageVersionAllInParam.getPageKey() != null) {
            pageVersionInParams = pageVersionAllInParam.getPageKey();
            pageKeys = new ArrayList<>();
            for (PageVersionInParam pageVersionInParam :
                    pageVersionInParams) {
                pageKeys.add(pageVersionInParam.getPageKey());
            }
        }

        List<PageModel> pageModelsUpdate = pageService.selectVersionList(pageKeys);
        if (pageVersionInParams != null) {
            for (PageVersionInParam pageVersionInParam :
                    pageVersionInParams) {
                int index = 0;
                boolean findSign = false;
                while (index < pageModelsUpdate.size()) {
                    if (pageVersionInParam.getPageKey().equals(pageModelsUpdate.get(index).getPageKey())) {
                        findSign = true;
                        break;
                    }
                    index++;
                }
                if (findSign) {
                    if (!pageVersionInParam.getPageVersion().equals(pageModelsUpdate.get(index).getPageVersion())) {
                        resultList.add(pageModelsUpdate.get(index));
                    }
                } else {
                    PageModel pageModel = new PageModel();
                    pageModel.setOperateType((short) -1);
                    pageModel.setPageKey(pageVersionInParam.getPageKey());
                    resultList.add(pageModel);
                }
            }
        }

        PageVersionInsertInParam pageVersionInsertInParam = new PageVersionInsertInParam();
        pageVersionInsertInParam.setPageKey(pageKeys);
        pageVersionInsertInParam.setUseId(pageVersionAllInParam.getUseId());

        List<PageModel> pageModelsInsert = pageService.selectVersionInsertList(pageVersionInsertInParam);
        if (pageModelsInsert != null) {
            resultList.addAll(pageModelsInsert);
        }

        if (pageKeys != null)
            pageKeys.clear();
        if (pageModelsInsert != null)
            pageModelsInsert.clear();
        if (pageModelsUpdate != null)
            pageModelsUpdate.clear();
        return ResultStruct.success(resultList);
    }
}
