package com.example.demo.model;


import com.google.common.util.concurrent.AtomicDouble;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Data;

@Data
public class CurrencyTracker {
    AtomicDouble USDRUB;
    AtomicDouble EURRUB;
    AtomicDouble GBPRUB;

    public CurrencyTracker(MeterRegistry meterRegistry) {
        this.USDRUB = new AtomicDouble();
        this.EURRUB = new AtomicDouble();
        this.GBPRUB = new AtomicDouble();
        meterRegistry.gauge("USDRUB", USDRUB);
        meterRegistry.gauge("EURRUB", EURRUB);
        meterRegistry.gauge("GBPRUB", GBPRUB);
    }

    public void track(CurrencyResponse currencyResponse) {
        USDRUB.set(currencyResponse.getData().getUSDRUB());
        EURRUB.set(currencyResponse.getData().getEURRUB());
        GBPRUB.set(currencyResponse.getData().getGBPRUB());
    }
}
