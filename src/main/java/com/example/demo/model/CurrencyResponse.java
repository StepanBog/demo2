package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyResponse {

    List<CurrencyValues> data;
}
