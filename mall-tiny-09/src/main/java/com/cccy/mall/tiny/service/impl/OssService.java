package com.cccy.mall.tiny.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zhai
 * 2020/9/6 17:57
 */
@Service
public class OssService {
    private static final Logger logger = LoggerFactory.getLogger(OssService.class);
    @Value("${aliyun.oss.policy.expire}")
    private int ALIYUN_OSS_EXPIRE;
    @Value("${aliyun.oss.maxSize}")
    private int ALIYUN_OSS_MAX_SIZE;
    @Value("${aliyun.oss.callback}")
    private String ALIYUN_OSS_CALLBACK;
    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKET_NAME;
    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.dir.prefix}")
    private String ALIYUN_OSS_DIR_PREFIX;

    @Autowired
    private OSS oss;

    public void upload(byte[] bytes) {
        String key = IdUtil.createSnowflake(1, 1).nextIdStr();
        System.out.println("file key: " + key);
        PutObjectResult result = oss.putObject(ALIYUN_OSS_BUCKET_NAME, key, new ByteArrayInputStream(bytes));
        System.out.println(JSONUtil.toJsonStr(result.getResponse()));
    }

    public void download(String key, HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = null;
        try {
            OSSObject object = oss.getObject(ALIYUN_OSS_BUCKET_NAME, key);
            InputStream inputStream = object.getObjectContent();
            byte[] bytes = IoUtil.readBytes(inputStream);
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
