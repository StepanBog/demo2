package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class RateByType {
    String rateType;
    List<String> ratesForPeriod;
    Rate lastActualRate;
}
