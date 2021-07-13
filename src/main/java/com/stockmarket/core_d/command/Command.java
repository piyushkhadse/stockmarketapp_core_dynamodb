package com.stockmarket.core_d.command;

import com.stockmarket.core_d.domain.Error;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class Command implements Serializable {
    private String aggregateId;
    private String aggregateType;
    private List<Error> errors;
    @Transient
    private Map<String, Object> referenceData;

    protected Command(String aggregateId, String aggregateType) {
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.errors = new ArrayList<>();
        this.referenceData = new HashMap<>();
    }
}
