package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyValues {
    String currencyCode;
    List<RateByClientType> rateByClientType;
}
