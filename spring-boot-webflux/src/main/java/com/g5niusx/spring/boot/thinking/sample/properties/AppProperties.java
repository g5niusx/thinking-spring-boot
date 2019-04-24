package com.g5niusx.spring.boot.thinking.sample.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * app.properties 注入的实体
 *
 * @author g5niusx
 */
// 将配置文件加载到程序中
@PropertySource(value = "classpath:app.properties", encoding = "utf-8")
// 将对象和配置文件中的 prefix 关联
@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppProperties {
    private String author;
    private String name;
    private String desc;
}
