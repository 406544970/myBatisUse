package com.lh.mybatisuse.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
@Configuration
public class PageHelperConfiguration {
    //    private static final Logger log = LoggerFactory.getLogger(PageHelperConfiguration.class);
    @Bean
    public PageHelper pageHelper() {
//        log.info("------Register MyBatis PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        p.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}