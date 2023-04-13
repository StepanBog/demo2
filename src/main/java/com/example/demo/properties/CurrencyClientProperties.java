package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Data
@Component
@ConfigurationProperties(prefix = "currency")
public class CurrencyClientProperties {
    String currencyCodes;
    String rateType;
    Boolean lastActualForDate;
    String clientType;
    ZonedDateTime date;
}
