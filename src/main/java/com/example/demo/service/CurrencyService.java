package com.example.demo.service;

import com.example.demo.client.CurrencyClient;
import com.example.demo.model.CurrencyEntity;
import com.example.demo.model.CurrencyResponse;
import com.example.demo.model.CurrencyTracker;
import com.example.demo.properties.CurrencyClientProperties;
import com.example.demo.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {

    private CurrencyTracker currencyTracker;
    private final CurrencyClient currencyClient;
    private final CurrencyRepository currencyRepository;

    private final CurrencyClientProperties clientProperties;

    public List<CurrencyEntity> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public List<CurrencyEntity> getCurrenciesByName(String name) {
        return currencyRepository.findByCurrency(name);
    }

    public void getCurrenciesFromClient() {
        CurrencyResponse currencies = currencyClient.getCurrencies(clientProperties.getGet(), clientProperties.getPairs(), clientProperties.getKey());

        currencyTracker.track(currencies);

        List<CurrencyEntity> currencyEntities = new ArrayList<>(List.of(
                CurrencyEntity.builder()
                        .currency("EURRUB")
                        .value(currencies.getData().getEURRUB())
                        .build(),
                CurrencyEntity.builder()
                        .currency("USDRUB")
                        .value(currencies.getData().getUSDRUB())
                        .build(),
                CurrencyEntity.builder()
                        .currency("GBPRUB")
                        .value(currencies.getData().getGBPRUB())
                        .build()
        ));
        currencyRepository.saveAll(currencyEntities);
    }

}
