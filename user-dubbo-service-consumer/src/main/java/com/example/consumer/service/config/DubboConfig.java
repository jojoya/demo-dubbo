package com.example.consumer.service.config;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

//    private static final Logger LOGGER = LoggerFactory.getLogger(DubboConfig.class);

    @Bean("dubbo")
    public ProtocolConfig dubboProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
//        int port = Integer.parseInt(Repostory.getProperty("dubboPort").toString());
        int port = 20880;
//        LOGGER.info("dubbo provider dubbo port = {}", port);
        protocolConfig.setPort(port);
        protocolConfig.setId("dubbo");
        protocolConfig.setServer(null);
        return protocolConfig;
    }

    @Bean("rest")
    public ProtocolConfig restProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
//        int port = Integer.parseInt(Repostory.getProperty("restPort").toString());
        int port = 8888;
//        LOGGER.info("dubbo provider rest port = {}", port);
        protocolConfig.setPort(port);
        protocolConfig.setId("rest");
        protocolConfig.setServer("tomcat");
        return protocolConfig;
    }
}
