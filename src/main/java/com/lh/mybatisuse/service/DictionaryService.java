package com.lh.mybatisuse.service;

import com.lh.mybatisuse.model.DictionaryIniModel;
import com.lh.mybatisuse.model.DictionaryModel;
import com.lh.mybatisuse.model.InPutParam.DictionaryDeleteInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryInsertInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryUpdateInParam;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:21
 * @function
 * @editLog
 */
public interface DictionaryService {
    /**
     * 下载所有字典
     *
     * @return 所有字典
     */
    List<DictionaryIniModel> downIniDictionary();

    /**
     * 根据标识得到内容
     *
     * @param id 主键
     * @return 内容
     */
    String selectSignById(String id);
    /**
     * 返回字典列表
     *
     * @param signName 标识
     * @return List
     */
    List<DictionaryModel> selectDictionaryList(String signName);
    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    int insertDictionary(DictionaryInsertInParam dictionaryInsertInParam);

    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    int insertDictionaryBeforeCheck(DictionaryInsertInParam dictionaryInsertInParam);
    /**
     * 修改字典
     *
     * @param dictionaryUpdateInParam com.lh.authority.model.InPutParam.DictionaryUpdateInParam
     * @return 影响条数
     */
    int updateDictionaryByAll(DictionaryUpdateInParam dictionaryUpdateInParam);
    /**
     * 删除
     *
     * @param dictionaryDeleteInParam com.lh.authority.model.InPutParam.DictionaryDeleteInParam
     * @return 影响条数
     */
    int deleteDictionaryBySignAndId(DictionaryDeleteInParam dictionaryDeleteInParam);

}
