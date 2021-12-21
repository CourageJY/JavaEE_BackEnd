package com.pet.minio.service;

import io.minio.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Objects;

@Service
public class minIOService {
    @Resource
    MinioClient minioClient;

    //默认minIO Client地址
    public String baseUrl="http://112.124.12.171:9090/pet/";

    public String uploadFile(MultipartFile file,String folder)
    {
        BucketExistsArgs args= BucketExistsArgs.builder()
                .bucket("pet")
                .build();

        // 检查存储桶是否已经存在
        boolean isExist = false;
        try {
            isExist = minioClient.bucketExists(args);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        //不存在则创建桶
        if(isExist) {
            System.out.println("Bucket already exists.");
        } else {
            MakeBucketArgs makeArgs= MakeBucketArgs.builder()
                    .bucket("pet")
                    .build();
            try {
                minioClient.makeBucket(makeArgs);
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
        //随机生成文件名
        String fileName= Instant.now().toString();
        int index= Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf(".");
        String type=file.getOriginalFilename().substring(index,file.getOriginalFilename().length());
        fileName=folder+"/"+fileName+type;
        try {
            PutObjectArgs objectArgs = PutObjectArgs.builder()
                    .object(fileName)
                    .bucket("pet")
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(),file.getSize(),-1)
                    .build();
            minioClient.putObject(objectArgs);
            return baseUrl+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public byte[] getFile(String fileName)
    {
        // 调用statObject()来判断对象是否存在。
        // 如果不存在, statObject()抛出异常,
        // 否则则代表对象存在。
        StatObjectArgs args= StatObjectArgs.builder()
                .bucket("pet")
                .object(fileName)
                .build();
        try {
            minioClient.statObject(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetObjectArgs getArgs= GetObjectArgs.builder()
                .bucket("pet")
                .object(fileName)
                .build();


        // 获取"myobject"的输入流。
        InputStream stream =null;
        try {
            stream=minioClient.getObject(getArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 读取输入流直到EOF并打印到控制台。
        byte[] buf = new byte[16384];
        int bytesRead = 0;
        if(stream==null)
            return null;
        while (true) {
            try {
                if (!((bytesRead = stream.read(buf, 0, buf.length)) >= 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(buf, 0, bytesRead));
        }

        // 关闭流，此处为示例，流关闭最好放在finally块。
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    public String removeFile(String fileName)
    {
        RemoveObjectArgs args= RemoveObjectArgs.builder()
                .bucket("pet")
                .object(fileName)
                .build();
        // 从mybucket中删除myobject。
        try {
            minioClient.removeObject(args);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
