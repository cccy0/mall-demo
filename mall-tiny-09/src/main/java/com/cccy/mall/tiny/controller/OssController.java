package com.cccy.mall.tiny.controller;

import com.cccy.mall.tiny.common.api.CommonResult;
import com.cccy.mall.tiny.service.impl.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zhai
 * 2020/9/6 18:17
 */
@Api(tags = "Oss管理")
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResult<Object> upload(MultipartFile file) throws IOException {
        ossService.upload(file.getBytes());
        return CommonResult.success("ok");
    }

    @ApiOperation(value = "下载文件")
    @RequestMapping(value = "/download/{key}", method = RequestMethod.GET)
    public void callback(HttpServletResponse response, @PathVariable("key") String key) throws IOException {
        ossService.download(key, response);
    }
}
