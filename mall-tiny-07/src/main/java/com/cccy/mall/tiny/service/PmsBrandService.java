package com.cccy.mall.tiny.service;

import com.cccy.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Zhai
 * 2020/8/31 22:25
 */

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
