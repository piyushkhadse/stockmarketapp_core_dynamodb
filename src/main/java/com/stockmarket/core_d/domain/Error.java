package com.stockmarket.core_d.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Error implements Serializable {
    private String reasonCode;
    private String description;
}
