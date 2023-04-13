package com.example.demo.model;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Data
public class RateByClientType {
    String clientType;
    List<RateByType> ratesByType;
}
