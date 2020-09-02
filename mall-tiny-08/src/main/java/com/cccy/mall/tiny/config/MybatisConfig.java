package com.cccy.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhai
 * 2020/8/31 22:23
 */
@Configuration
@MapperScan(value = {"com.cccy.mall.tiny.mbg.mapper", "com.cccy.mall.tiny.dao"})
public class MybatisConfig {
}
