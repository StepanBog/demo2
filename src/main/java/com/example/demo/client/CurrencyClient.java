package com.example.demo.client;

import com.example.demo.model.CurrencyResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;

@FeignClient(name = "currencyClient", url = "${currency.url}")
public interface CurrencyClient {

    @GetMapping(consumes = "application/json")
    @Timed("clientTime")
    CurrencyResponse getCurrencies(@RequestParam(value = "currencyCode.in") String currencyCodes,
                                   @RequestParam(value = "rateType.eq") String rateType,
                                   @RequestParam(value = "lastActualForDate.eq") Boolean lastActualForDate,
                                   @RequestParam(value = "clientType.eq") String clientType,
                                   @RequestParam(value = "date.lte") ZonedDateTime date);
}
