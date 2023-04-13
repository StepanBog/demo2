package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "currency")
public class CurrencyClientProperties {

    private String url;
    private String key;
    private String get;
    private String pairs;
}
