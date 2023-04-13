package com.example.demo.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Rate {
    ZonedDateTime date;
    Value buy;
    Value sell;
}
