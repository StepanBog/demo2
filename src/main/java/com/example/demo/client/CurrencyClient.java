package com.example.demo.client;

import com.example.demo.model.CurrencyResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyClient",url = "${currency.url}")
public interface CurrencyClient {

    @GetMapping(path = "/",consumes = "application/json")
    @Timed("clientTime")
    CurrencyResponse getCurrencies(@RequestParam String get, @RequestParam String pairs, @RequestParam String key);
}
