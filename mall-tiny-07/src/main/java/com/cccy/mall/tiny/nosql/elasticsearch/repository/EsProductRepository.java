package com.cccy.mall.tiny.nosql.elasticsearch.repository;

import com.cccy.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Zhai
 * 2020/9/2 14:31
 */

public interface EsProductRepository  extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return Page
     */
    Page<EsProduct> findAllByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
