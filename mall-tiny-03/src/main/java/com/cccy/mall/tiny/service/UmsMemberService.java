package com.cccy.mall.tiny.service;

import com.cccy.mall.tiny.common.api.CommonResult;

/**
 * @author Zhai
 * 2020/9/1 15:12
 */

public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
