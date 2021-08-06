package com.example.dubbozookeeperserver;

import com.example.dubbocommonsapi.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Default {@link DemoService}
 *
 * @see DemoService
 * @since 2.7.0
 */
@DubboService(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        logger.info("调用dubbo服务端，参数{}",name);
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}