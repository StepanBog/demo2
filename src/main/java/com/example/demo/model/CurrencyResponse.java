package com.example.demo.model;

import lombok.Data;

@Data
public class CurrencyResponse {

    Integer status;
    String message;
    CurrencyValues data;
}
