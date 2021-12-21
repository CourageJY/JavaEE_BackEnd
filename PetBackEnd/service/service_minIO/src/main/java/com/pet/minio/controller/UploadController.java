package com.pet.minio.controller;

import com.pet.minio.service.minIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/minIO")
@RefreshScope
@Api(value="mniIO",tags = "minIO",description = "上传文件、图片")
public class UploadController {
    @Autowired
    minIOService uploader;

    @ApiOperation(value="minIO")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file)
    {
        return uploader.uploadFile(file,"");
    }

    @ApiOperation(value="minIO")
    @RequestMapping(value = "/get/{fileName}",method = RequestMethod.GET)
    public byte[] getFile(@PathVariable("fileName") String fileName)
    {
        return uploader.getFile(fileName);
    }

    @ApiOperation(value="minIO")
    @RequestMapping(value = "/remove/{fileName}",method = RequestMethod.GET)
    public String removeFile(@PathVariable("fileName") String fileName)
    {
        return uploader.removeFile(fileName);
    }
}
