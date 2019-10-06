package com.lh.mybatisuse.unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 得到参数
 * @author 梁昊
 * @date 2019/9/24
 * @function
 * @editLog
 */
//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//@Service
@Component
@RefreshScope
public class GetPropertiesClass {
    @Value("${server.port}")
    private String port;
    @Value("${eureka.instance.metadata-map.version}")
    private String version;
    @Value("${spring.application.name}")
    private String springApplicationName;
    @Value("${liangHaoSign}")
    private String liangHaoSign;
    @Value("${uploadFileFolder}")
    private String uploadFileFolder;

    public String getUploadFileFolder(){
        return this.uploadFileFolder;
    }
    /**
     * 得到端口号
     * @return
     */
    public String getPort(){
        return this.port;
    }

    /**
     * 得到版本
     * @return
     */
    public String getVersion(){
        return this.version;
    }

    /**
     * 得到微服务名称
     * @return
     */
    public String getApplicationName(){
        return this.springApplicationName;
    }

    /**
     * 自定义测试标识
     * @return
     */
    public String getLiangHaoSign(){
        return this.liangHaoSign;
    }
}
