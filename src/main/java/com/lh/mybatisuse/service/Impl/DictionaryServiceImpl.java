package com.lh.mybatisuse.service.Impl;

import com.lh.mybatisuse.dao.DictionaryMapper;
import com.lh.mybatisuse.model.DictionaryModel;
import com.lh.mybatisuse.model.InPutParam.DictionaryDeleteInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryInsertInParam;
import com.lh.mybatisuse.model.InPutParam.DictionaryUpdateInParam;
import com.lh.mybatisuse.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:21
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    /**
     * 根据标识得到内容
     *
     * @param id 主键
     * @return 内容
     */
    @Override
    public String selectSignById(String id) {
        return dictionaryMapper.selectSignById(id);
    }

    /**
     * 返回字典列表
     *
     * @param signName 标识
     * @return List
     */
    @Override
    public List<DictionaryModel> selectDictionaryList(String signName) {
        return dictionaryMapper.selectDictionaryList(signName);
    }

    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertDictionary (DictionaryInsertInParam dictionaryInsertInParam) {
        return dictionaryMapper.insertDictionary(dictionaryInsertInParam);
    }

    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertDictionaryBeforeCheck(DictionaryInsertInParam dictionaryInsertInParam) {
        return dictionaryMapper.insertDictionaryBeforeCheck(dictionaryInsertInParam);
    }

    /**
     * 修改字典
     *
     * @param dictionaryUpdateInParam com.lh.authority.model.InPutParam.DictionaryUpdateInParam
     * @return 影响条数
     */
    @Override
    public int updateDictionaryByAll (DictionaryUpdateInParam dictionaryUpdateInParam) {
        return dictionaryMapper.updateDictionaryByAll(dictionaryUpdateInParam);
    }

    /**
     * 删除
     *
     * @param dictionaryDeleteInParam com.lh.authority.model.InPutParam.DictionaryDeleteInParam
     * @return 影响条数
     */
    @Override
    public int deleteDictionaryBySignAndId (DictionaryDeleteInParam dictionaryDeleteInParam) {
        return dictionaryMapper.deleteDictionaryBySignAndId(dictionaryDeleteInParam);
    }

}
