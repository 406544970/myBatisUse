package com.lh.mybatisuse.controller;

import com.lh.mybatisuse.model.InPutParam.PageInsertInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionInsertInParam;
import com.lh.mybatisuse.model.InPutParam.PageVersionListInParam;
import com.lh.mybatisuse.model.PageModel;
import com.lh.mybatisuse.service.PageService;
import io.swagger.annotations.*;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
     * @return 页面ID
     */
    @ApiOperation(value = "得到需要更新的版本信息", notes = "页面ID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "useId", value = "useId", dataType = "String", required = true)
    })
    @PostMapping("/selectVersionList")
    public ResultVO selectVersionList(
            @RequestBody @ApiParam(name = "pageVersionInParamList", value = "传入PageVersionAllInParam格式")
                    PageVersionListInParam pageVersionInParamList
            , @RequestParam(value = "useId") String useId) throws ParseException {

        List<PageModel> resultList = new ArrayList<>();

        List<String> pageKeys = null;
        List<PageVersionInParam> pageVersionInParams = null;
        if (pageVersionInParamList != null) {
            pageVersionInParams = pageVersionInParamList.getPageKey();
            if (!pageVersionInParams.isEmpty()) {
                pageKeys = new ArrayList<>();
                for (PageVersionInParam pageVersionInParam :
                        pageVersionInParams) {
                    pageKeys.add(pageVersionInParam.getPageKey());
                }
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
                    pageModel.setPageType(pageVersionInParam.getPageType());
                    resultList.add(pageModel);
                }
            }
        }

        PageVersionInsertInParam pageVersionInsertInParam = new PageVersionInsertInParam();
        pageVersionInsertInParam.setPageKey(pageKeys);
        pageVersionInsertInParam.setUseId(useId);

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

    /**
     * 更新页面到远程，方法ID：UP20191003134902131B1A669671742
     *
     * @param pageKey          主键, Where字段
     * @param projectId        项目名称
     * @param pageType         页面类型
     * @param pageVersion      页面版本
     * @param createTime       创建时间
     * @param lastUpdateTime   最后修改时间
     * @param createOperator   创建者
     * @param createOperatorId 创建者ID
     * @param doOperator       后台开发员
     * @param doOperatorId     后台开发ID
     * @param frontOperator    前端开发员
     * @param frontOperatorId  前端开发ID
     * @param finishCount      完成比较
     * @param readOnly         是否只读
     * @param methodRemark     方法说明
     * @return 影响条数
     */
    @ApiOperation(value = "更新页面到远程", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String")
            , @ApiImplicitParam(name = "projectId", value = "项目名称", dataType = "String")
            , @ApiImplicitParam(name = "pageType", value = "页面类型", dataType = "String")
            , @ApiImplicitParam(name = "pageVersion", value = "页面版本", dataType = "int")
            , @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date")
            , @ApiImplicitParam(name = "lastUpdateTime", value = "最后修改时间", dataType = "Date")
            , @ApiImplicitParam(name = "createOperator", value = "创建者", dataType = "String")
            , @ApiImplicitParam(name = "createOperatorId", value = "创建者ID", dataType = "String")
            , @ApiImplicitParam(name = "doOperator", value = "后台开发员", dataType = "String")
            , @ApiImplicitParam(name = "doOperatorId", value = "后台开发ID", dataType = "String")
            , @ApiImplicitParam(name = "frontOperator", value = "前端开发员", dataType = "String")
            , @ApiImplicitParam(name = "frontOperatorId", value = "前端开发ID", dataType = "String")
            , @ApiImplicitParam(name = "finishCount", value = "完成比较", dataType = "int")
            , @ApiImplicitParam(name = "readOnly", value = "是否只读", dataType = "boolean")
            , @ApiImplicitParam(name = "methodRemark", value = "方法说明", dataType = "String")
    })
    @PostMapping("/updatePageAndXml")
    public int updatePageAndXml(@RequestParam(value = "pageKey", required = false) String pageKey
            , @RequestParam(value = "projectId") String projectId
            , @RequestParam(value = "pageType") String pageType
            , @RequestParam(value = "pageVersion") int pageVersion
            , @RequestParam(value = "createTime") Date createTime
            , @RequestParam(value = "lastUpdateTime") Date lastUpdateTime
            , @RequestParam(value = "createOperator") String createOperator
            , @RequestParam(value = "createOperatorId") String createOperatorId
            , @RequestParam(value = "doOperator") String doOperator
            , @RequestParam(value = "doOperatorId") String doOperatorId
            , @RequestParam(value = "frontOperator") String frontOperator
            , @RequestParam(value = "frontOperatorId") String frontOperatorId
            , @RequestParam(value = "finishCount") int finishCount
            , @RequestParam(value = "readOnly") boolean readOnly
            , @RequestParam(value = "methodRemark") String methodRemark) {
        pageKey = pageKey == null ? pageKey : pageKey.trim();
        projectId = projectId == null ? projectId : projectId.trim();
        pageType = pageType == null ? pageType : pageType.trim();
        createOperator = createOperator == null ? createOperator : createOperator.trim();
        createOperatorId = createOperatorId == null ? createOperatorId : createOperatorId.trim();
        doOperator = doOperator == null ? doOperator : doOperator.trim();
        doOperatorId = doOperatorId == null ? doOperatorId : doOperatorId.trim();
        frontOperator = frontOperator == null ? frontOperator : frontOperator.trim();
        frontOperatorId = frontOperatorId == null ? frontOperatorId : frontOperatorId.trim();
        methodRemark = methodRemark == null ? methodRemark : methodRemark.trim();

        PageInsertInParam pageInsertInParam = new PageInsertInParam();
        pageInsertInParam.setPageKey(pageKey);
        pageInsertInParam.setProjectId(projectId);
        pageInsertInParam.setPageType(pageType);
        pageInsertInParam.setPageVersion(pageVersion);
        pageInsertInParam.setCreateTime(createTime);
        pageInsertInParam.setLastUpdateTime(lastUpdateTime);
        pageInsertInParam.setCreateOperator(createOperator);
        pageInsertInParam.setCreateOperatorId(createOperatorId);
        pageInsertInParam.setDoOperator(doOperator);
        pageInsertInParam.setDoOperatorId(doOperatorId);
        pageInsertInParam.setFrontOperator(frontOperator);
        pageInsertInParam.setFrontOperatorId(frontOperatorId);
        pageInsertInParam.setFinishCount(finishCount);
        pageInsertInParam.setReadOnly(readOnly);
        pageInsertInParam.setMethodRemark(methodRemark);
        int updateCount = pageService.updatePageAndXml(pageInsertInParam);

        return updateCount;
    }

    /**
     * 删除远程页面，方法ID：DE20191003140516796BAC1703BA606
     *
     * @param pageKey 主键
     * @return 影响条数
     */
    @ApiOperation(value = "删除远程页面", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/deletePageAndXml")
    public int deletePageAndXml(@RequestParam(value = "pageKey") String pageKey) {
        pageKey = pageKey == null ? pageKey : pageKey.trim();

        PageInsertInParam pageInsertInParam = new PageInsertInParam();
        pageInsertInParam.setPageKey(pageKey);
        int updateCount = pageService.deletePageAndXml(pageInsertInParam);

        return updateCount;
    }

    /**
     * 增加页面到远程，方法ID：IN2019100313365444981638880CDD8
     *
     * @param pageKey          主键
     * @param projectId        项目名称
     * @param pageType         页面类型
     * @param pageVersion      页面版本
     * @param createTime       创建时间
     * @param lastUpdateTime   最后修改时间
     * @param createOperator   创建者
     * @param createOperatorId 创建者ID
     * @param doOperator       后台开发员
     * @param doOperatorId     后台开发ID
     * @param frontOperator    前端开发员
     * @param frontOperatorId  前端开发ID
     * @param finishCount      完成比较
     * @param readOnly         是否只读
     * @param methodRemark     方法说明
     * @return 影响条数
     */
    @ApiOperation(value = "增加页面到远程", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "projectId", value = "项目名称", dataType = "String", required = true)
            , @ApiImplicitParam(name = "pageType", value = "页面类型", dataType = "String", required = true)
            , @ApiImplicitParam(name = "pageVersion", value = "页面版本", dataType = "int", required = true)
            , @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date", required = true)
            , @ApiImplicitParam(name = "lastUpdateTime", value = "最后修改时间", dataType = "Date", required = true)
            , @ApiImplicitParam(name = "createOperator", value = "创建者", dataType = "String", required = true)
            , @ApiImplicitParam(name = "createOperatorId", value = "创建者ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "doOperator", value = "后台开发员", dataType = "String", required = true)
            , @ApiImplicitParam(name = "doOperatorId", value = "后台开发ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "frontOperator", value = "前端开发员", dataType = "String", required = true)
            , @ApiImplicitParam(name = "frontOperatorId", value = "前端开发ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "finishCount", value = "完成比较", dataType = "int", required = true)
            , @ApiImplicitParam(name = "readOnly", value = "是否只读", dataType = "boolean", required = true)
            , @ApiImplicitParam(name = "methodRemark", value = "方法说明", dataType = "String")
    })
    @PostMapping("/insertPage")
    public int insertPage(@RequestParam(value = "pageKey") String pageKey
            , @RequestParam(value = "projectId") String projectId
            , @RequestParam(value = "pageType") String pageType
            , @RequestParam(value = "pageVersion") int pageVersion
            , @RequestParam(value = "createTime") Date createTime
            , @RequestParam(value = "lastUpdateTime") Date lastUpdateTime
            , @RequestParam(value = "createOperator") String createOperator
            , @RequestParam(value = "createOperatorId") String createOperatorId
            , @RequestParam(value = "doOperator") String doOperator
            , @RequestParam(value = "doOperatorId") String doOperatorId
            , @RequestParam(value = "frontOperator") String frontOperator
            , @RequestParam(value = "frontOperatorId") String frontOperatorId
            , @RequestParam(value = "finishCount") int finishCount
            , @RequestParam(value = "readOnly") boolean readOnly
            , @RequestParam(value = "methodRemark", required = false) String methodRemark) {
        projectId = projectId == null ? projectId : projectId.trim();
        pageType = pageType == null ? pageType : pageType.trim();
        createOperator = createOperator == null ? createOperator : createOperator.trim();
        createOperatorId = createOperatorId == null ? createOperatorId : createOperatorId.trim();
        doOperator = doOperator == null ? doOperator : doOperator.trim();
        doOperatorId = doOperatorId == null ? doOperatorId : doOperatorId.trim();
        frontOperator = frontOperator == null ? frontOperator : frontOperator.trim();
        frontOperatorId = frontOperatorId == null ? frontOperatorId : frontOperatorId.trim();
        methodRemark = methodRemark == null ? methodRemark : methodRemark.trim();

        PageInsertInParam pageInsertInParam = new PageInsertInParam();
        pageInsertInParam.setPageKey(pageKey);
        pageInsertInParam.setProjectId(projectId);
        pageInsertInParam.setPageType(pageType);
        pageInsertInParam.setPageVersion(pageVersion);
        pageInsertInParam.setCreateTime(createTime);
        pageInsertInParam.setLastUpdateTime(lastUpdateTime);
        pageInsertInParam.setCreateOperator(createOperator);
        pageInsertInParam.setCreateOperatorId(createOperatorId);
        pageInsertInParam.setDoOperator(doOperator);
        pageInsertInParam.setDoOperatorId(doOperatorId);
        pageInsertInParam.setFrontOperator(frontOperator);
        pageInsertInParam.setFrontOperatorId(frontOperatorId);
        pageInsertInParam.setFinishCount(finishCount);
        pageInsertInParam.setReadOnly(readOnly);
        pageInsertInParam.setMethodRemark(methodRemark);
        int repetitionCount = pageService.insertPageBeforeCheck(pageInsertInParam);
        if (repetitionCount > 0)
            repetitionCount = pageService.updatePageAndXml(pageInsertInParam);
        else
            repetitionCount = pageService.insertPage(pageInsertInParam);

        return repetitionCount;
    }

}
