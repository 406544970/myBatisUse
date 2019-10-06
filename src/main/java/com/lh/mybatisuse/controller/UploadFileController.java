package com.lh.mybatisuse.controller;

import com.lh.mybatisuse.unit.GetPropertiesClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 梁昊
 * @date 2019/10/5
 * @function
 * @editLog
 */
@CrossOrigin
@RestController
@RequestMapping("/UploadFileController")
@Api(value = "上传、下载文件控制层", description = "包括：HTTP上传")
public class UploadFileController {
    @Autowired
    GetPropertiesClass getPropertiesClass;

    /**
     * 单文件上传
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionary", value = "路径名，如：select", dataType = "String", required = true),
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true),
    })
    @PostMapping(value = "/uploadFile")
    public ResultVO uploadFile(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return getUploadFileResultVO(fileStreamArray, dictionary, fileName);
    }

    /**
     * 单文件上传SELECT
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileSelect")
    public ResultVO uploadFileSelect(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return getUploadFileResultVO(fileStreamArray, "select", fileName);
    }

    /**
     * 单文件上传UPDATE
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileUpdate")
    public ResultVO uploadFileUpdate(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return getUploadFileResultVO(fileStreamArray, "update", fileName);
    }

    /**
     * 单文件上传INSERT
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileInsert")
    public ResultVO uploadFileInsert(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return getUploadFileResultVO(fileStreamArray, "insert", fileName);
    }

    /**
     * 单文件上传DELETE
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileDelete")
    public ResultVO uploadFileDelete(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return getUploadFileResultVO(fileStreamArray, "delete", fileName);
    }

    private ResultVO getUploadFileResultVO(byte[] fileStreamArray, String dictionary, String fileName) throws IOException {
        if (fileStreamArray == null || fileStreamArray.length == 0) {
            return ResultStruct.error("上传失败，文件体为空！", ResultVO.class);
        } else {
            if (uploadFilePrivate(fileStreamArray, dictionary, fileName))
                return ResultStruct.success(true);
            else
                return ResultStruct.error("上传失败！", ResultVO.class);
        }
    }

    /**
     * 下载文件
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionary", value = "带扩展名的文件名", dataType = "String", required = true),
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/downLoadFile")
    public byte[] downLoadFile(@RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        dictionary = dictionary == null ? null : dictionary.trim();
        fileName = fileName == null ? null : fileName.trim();
        fileName += ".xml";
        String allPathFileName = String.format("%s%s%s%s%s"
                , getPropertiesClass.getUploadFileFolder()
                , File.separator
                , dictionary
                , File.separator
                , fileName);

        File file = new File(allPathFileName);
        if (file.exists()) {
            byte[] resultArray = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(allPathFileName);
            int read = fileInputStream.read(resultArray, 0, resultArray.length);
            fileInputStream.close();
            if (read > -1)
                return resultArray;
            else
                return null;
        } else
            return null;
    }

    private boolean uploadFilePrivate(byte[] fileStreamArray, String dictionary, String fileName) throws IOException {
        String allPathFileName = String.format("%s%s%s%s%s"
                , getPropertiesClass.getUploadFileFolder()
                , File.separator
                , dictionary
                , File.separator
                , fileName);

        File file = new File(allPathFileName);
        File parent = file.getParentFile();
        if (!parent.exists())
            parent.mkdirs();

        FileOutputStream fileOutputStream = new FileOutputStream(allPathFileName);
        fileOutputStream.write(fileStreamArray, 0, fileStreamArray.length);
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }
}
