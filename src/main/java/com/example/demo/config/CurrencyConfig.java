package com.example.demo.config;

import com.example.demo.model.CurrencyTracker;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CurrencyConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CurrencyTracker currencyTracker(MeterRegistry meterRegistry) {
        return new CurrencyTracker(meterRegistry);
    }
}
