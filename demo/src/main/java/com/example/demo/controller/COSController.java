package com.example.demo.controller;

import com.example.demo.util.Msg;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.region.Region;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Date;

/**
 * @program: demo
 * @description: 关于COS的签名获取服务
 * @author: Yao Yunzhi
 * @create: 2020-06-17 11:18
 **/
@RestController
public class COSController{
    // 初始化永久密钥信息
    String secretId = "AKIDNK6bsgu5ZkjS9bKAPQHsDI7j7QUMw1aM";
    String secretKey = "77qshKj5A4h38xa8PgjT0UiV3LQDoBTS";
    int duration = 1800;
    String region = "ap-nanjing";
    String bucket = "auction-1300038466";

   /**
    * @Author xu yingliang,Yao Yunzhi
    * @Description 返回上传文件的签名
    * @Date 14:45 2020/6/18
    * @Param [key]  文件名称
    * @return com.example.demo.util.Msg
    **/
    @GetMapping("/uploadFile")
    public String upload(String key){
        // 要签名的 key, 生成的签名只能用于对应此 key 的上传
        return "";
    }

    /**
     * @Author xu yingliang
     * @Description 返回下载需要的签名
     * @Date 14:54 2020/6/18
     * @Param [key]  文件名称
     * @return com.example.demo.util.Msg
     **/
    @GetMapping("downloadFile")
    public String download(String key){
        //String sign = signer.buildAuthorizationStr(HttpMethodName.GET, key, cred, expiredTime);
        return "";
    }

    /**
     * @Author xu yingliang
     * @Description 删除需要的签名
     * @Date 14:55 2020/6/18
     * @Param [key]
     * @return com.example.demo.util.Msg
     **/
    @GetMapping("deleteFile")
    public String deleteFile(String key){
        //String sign = signer.buildAuthorizationStr(HttpMethodName.DELETE, key, cred, expiredTime);
        return "";
    }
}
