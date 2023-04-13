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
        EURRUB.set(currencyResponse.getData().get(0).getRateByClientType().get(0)
                           .getRatesByType().get(0)
                           .getLastActualRate().getSell().getOriginalValue());
        GBPRUB.set(currencyResponse.getData().get(1).getRateByClientType().get(0)
                           .getRatesByType().get(0)
                           .getLastActualRate().getSell().getOriginalValue());
        USDRUB.set(currencyResponse.getData().get(2).getRateByClientType().get(0)
                           .getRatesByType().get(0)
                           .getLastActualRate().getSell().getOriginalValue());
    }
}
