package com.example.demo.controller;

import com.example.demo.model.CurrencyEntity;
import com.example.demo.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping(path = "/all")
    public List<CurrencyEntity> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }
    @GetMapping(path = "/{name}")
    public List<CurrencyEntity> getCurrenciesByName(@PathVariable String name) {
        return currencyService.getCurrenciesByName(name);
    }

}
