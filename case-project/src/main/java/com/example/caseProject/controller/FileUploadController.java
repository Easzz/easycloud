package com.example.caseProject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@Api(tags = "FileUploadController", description = "文件上传")
public class FileUploadController extends AbstractFileUploadController {

    @PostMapping(value = "/uploadCaseProject", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传")
    public Object uploadCaseProject(@RequestParam("file") @ApiParam(value = "上传的文件", required = true) MultipartFile file) {

        return upload(file,"caseProject");
    }


    @PostMapping(value = "/uploadItem", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传")
    public Object uploadItem(@RequestParam("file") @ApiParam(value = "上传的文件", required = true) MultipartFile file) {

        return upload(file,"item");
    }




    @PostMapping(value = "/uploadStandard", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传")
    public Object uploadStandard(@RequestParam("file") @ApiParam(value = "上传的文件", required = true) MultipartFile file) {

        return upload(file,"standard");
    }

    @PostMapping(value = "/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传")
    public Object uploadFile(@RequestParam("file") @ApiParam(value = "上传的文件", required = true) MultipartFile file) {

        return upload(file);
    }


    @PostMapping(value = "/uploadExcelFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传Excel")
    public Object uploadExcelFile(@ApiParam(value = "上传Excel", required = true) MultipartFile file) {
        return uploadExcel(file);
    }
}
