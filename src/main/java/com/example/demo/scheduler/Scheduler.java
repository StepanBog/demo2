package com.example.demo.scheduler;

import com.example.demo.service.CurrencyService;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Scheduler {

    private final CurrencyService currencyService;

    @Timed("schedulerTime")
    @Scheduled(fixedRate = 30000)
    public void update(){
        currencyService.getCurrenciesFromClient();
    }

}
