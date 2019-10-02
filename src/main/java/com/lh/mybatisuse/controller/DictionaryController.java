package com.lh.mybatisuse.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.mybatisuse.model.DictionaryModel;
import com.lh.mybatisuse.model.InPutParam.DictionaryDeleteInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryInsertInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryUpdateInParam;
import com.lh.mybatisuse.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:31
 * @function
 * @editLog
 */
@EnableEurekaClient
@RestController
@RequestMapping("/dictionaryController")
@Api(value = "数据字典", description = "未与Mongodb同步")
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    /**
     * 返回字典列表，方法ID：SE20190921232129273
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
    })
    @PostMapping("/selectDictionaryListString")
    public List<String> selectDictionaryListString(@RequestParam(value = "signName") String signName) {
        List<DictionaryModel> dictionaryModels = dictionaryService.selectDictionaryList(signName);
        List<String> list = new ArrayList<>();
        if (dictionaryModels != null) {
            for (DictionaryModel dictionaryModel:
                    dictionaryModels) {
                list.add(dictionaryModel.getValue());
            }
        }
        dictionaryModels.clear();
        return list;
    }

    /**
     * 返回字典列表，方法ID：SE20190921232129273
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
    })
    @PostMapping("/selectDictionaryList")
    public List<DictionaryModel> selectDictionaryList(@RequestParam(value = "signName") String signName) {
        return dictionaryService.selectDictionaryList(signName);
    }

    /**
     * 返回字典列表，方法ID：SE20190921234229276
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @param page     当前页数
     * @param limit    每页条数
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/selectDictionaryListPage")
    public ResultVOPage selectDictionaryListPage(@RequestParam(value = "signName") String signName
            , @RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "10") int limit) {
        PageHelper.startPage(page, limit);
        List<DictionaryModel> dictionaryModels = dictionaryService.selectDictionaryList(signName);
        PageInfo pageInfo = new PageInfo<>(dictionaryModels, limit);
        return ResultStruct.successPage(dictionaryModels, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 增加字典，方法ID：SE20190922000753468
     *
     * @param contentName 内容
     * @param sortNo      出现顺序
     * @param remark      备注
     * @return 影响条数
     */
    @ApiOperation(value = "增加字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentName", value = "内容", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "sortNo", value = "出现顺序", dataType = "int", required = true)
            , @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    @PostMapping("/insertDictionary")
    public ResultVO insertDictionary(@RequestParam(value = "contentName") String contentName
            , @RequestParam(value = "signName") String signName
            , @RequestParam(value = "sortNo") int sortNo
            , @RequestParam(value = "remark", required = false) String remark) {
        contentName = contentName == null ? contentName : contentName.trim();
        remark = remark == null ? remark : remark.trim();

        DictionaryInsertInParam dictionaryInsertInParam = new DictionaryInsertInParam();
        String mainKey = contentName;
        dictionaryInsertInParam.setId(mainKey);
        dictionaryInsertInParam.setSignName(signName);
        dictionaryInsertInParam.setContentName(contentName);
        dictionaryInsertInParam.setSortNo(sortNo);
        dictionaryInsertInParam.setRemark(remark);
        int repetitionCount = dictionaryService.insertDictionaryBeforeCheck(dictionaryInsertInParam);
        if (repetitionCount > 0)
            return ResultStruct.error("增加失败，有" + repetitionCount + "条数据已重复！", ResultVO.class);
        int resultCount = dictionaryService.insertDictionary(dictionaryInsertInParam);
        if (resultCount > 0)
            return ResultStruct.success(resultCount);
        else
            return ResultStruct.error("增加失败", ResultVO.class);
    }

    /**
     * 修改字典，方法ID：SE20190922002032445
     *
     * @param id            主键
     * @param idWhere       主键, Where字段
     * @param signNameWhere 标识, Where字段
     * @param defaultSelect 是否选择
     * @param sortNo        出现顺序
     * @param stopSign      是否停用
     * @param remark        备注
     * @return 影响条数
     */
    @ApiOperation(value = "修改字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
            , @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signNameWhere", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "defaultSelect", value = "是否选择", dataType = "boolean")
            , @ApiImplicitParam(name = "sortNo", value = "出现顺序", dataType = "int")
            , @ApiImplicitParam(name = "stopSign", value = "是否停用", dataType = "boolean")
            , @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    @PostMapping("/updateDictionaryByAll")
    public ResultVO updateDictionaryByAll(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "defaultSelect", required = false) boolean defaultSelect
            , @RequestParam(value = "sortNo", required = false) int sortNo
            , @RequestParam(value = "stopSign", required = false) boolean stopSign
            , @RequestParam(value = "remark", required = false) String remark) {
        id = id == null ? id : id.trim();
        idWhere = idWhere == null ? idWhere : idWhere.trim();
        signNameWhere = signNameWhere == null ? signNameWhere : signNameWhere.trim();
        String contentName = id;
        remark = remark == null ? remark : remark.trim();

        DictionaryUpdateInParam dictionaryUpdateInParam = new DictionaryUpdateInParam();
        dictionaryUpdateInParam.setId(id);
        dictionaryUpdateInParam.setIdWhere(idWhere);
        dictionaryUpdateInParam.setSignNameWhere(signNameWhere);
        dictionaryUpdateInParam.setContentName(contentName);
        dictionaryUpdateInParam.setDefaultSelect(defaultSelect);
        dictionaryUpdateInParam.setSortNo(sortNo);
        dictionaryUpdateInParam.setStopSign(stopSign);
        dictionaryUpdateInParam.setRemark(remark);

        if (id != null && signNameWhere != null) {
            DictionaryInsertInParam dictionaryInsertInParam = new DictionaryInsertInParam();
            dictionaryInsertInParam.setId(id);
            dictionaryInsertInParam.setSignName(signNameWhere);
            int repetitionCount = dictionaryService.insertDictionaryBeforeCheck(dictionaryInsertInParam);
            if (repetitionCount > 0) {
                return ResultStruct.error("增加失败，有" + repetitionCount + "条数据已重复！", ResultVO.class);
            }
        }
        int updateCount = dictionaryService.updateDictionaryByAll(dictionaryUpdateInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }

    /**
     * 停用，方法ID：SE20190922002032445
     *
     * @param idWhere       主键, Where字段
     * @param signNameWhere 标识, Where字段
     * @param stopSign      是否停用
     * @return 影响条数
     */
    @ApiOperation(value = "修改字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signNameWhere", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "stopSign", value = "是否停用", dataType = "boolean", required = true)
    })
    @PostMapping("/updateDictionaryOfStopSign")
    public ResultVO updateDictionaryOfStopSign(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "stopSign") boolean stopSign) {
        idWhere = idWhere == null ? idWhere : idWhere.trim();
        signNameWhere = signNameWhere == null ? signNameWhere : signNameWhere.trim();

        DictionaryUpdateInParam dictionaryUpdateInParam = new DictionaryUpdateInParam();
        dictionaryUpdateInParam.setIdWhere(idWhere);
        dictionaryUpdateInParam.setSignNameWhere(signNameWhere);
        dictionaryUpdateInParam.setStopSign(stopSign);
        int updateCount = dictionaryService.updateDictionaryByAll(dictionaryUpdateInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }
    /**
     * 删除，方法ID：SE20190922094746611
     *
     * @param id 主键
     * @param signName 标识
     * @return 影响条数
     */
    @ApiOperation(value = "删除", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
            , @ApiImplicitParam(name = "signName", value = "标识", dataType = "String")
    })
    @PostMapping("/deleteDictionaryBySignAndId")
    public int deleteDictionaryBySignAndId(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "signName", required = false) String signName) {
        id = id == null ? id : id.trim();
        signName = signName == null ? signName : signName.trim();

        DictionaryDeleteInParam dictionaryDeleteInParam = new DictionaryDeleteInParam();
        dictionaryDeleteInParam.setId(id);
        dictionaryDeleteInParam.setSignName(signName);
        int updateCount = dictionaryService.deleteDictionaryBySignAndId(dictionaryDeleteInParam);

        return updateCount;
    }
    /**
     * 根据标识得到内容，方法ID：SE20190924091144625
     *
     * @param id 表inf_dictionaryName,字段名id:主键
     * @return 内容
     */
    @ApiOperation(value = "根据标识得到内容", notes = "内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/selectSignById")
    public ResultVO selectSignById(@RequestParam(value = "id") String id) {
        return ResultStruct.success(dictionaryService.selectSignById(id));
    }


}
