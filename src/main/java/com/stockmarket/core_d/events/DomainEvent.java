package com.stockmarket.core_d.events;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@DynamoDBDocument
public abstract class DomainEvent implements Serializable {
    @DynamoDBAttribute
    private String eventId;
    @DynamoDBAttribute
    private String aggregateId;
    @DynamoDBAttribute
    private String aggregateType;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private Integer aggregateVersion;
    @DynamoDBAttribute
    private String generatedDate;

    protected DomainEvent(String aggregateId, String aggregateType, String name, Integer aggregateVersion) {
        this.eventId = UUID.randomUUID().toString();
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.name = name;
        this.aggregateVersion = aggregateVersion;
        this.generatedDate = Instant.now().toString();
    }

    protected DomainEvent(String aggregateId, String aggregateType, String name) {
        this.eventId = UUID.randomUUID().toString();
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.name = name;
        this.generatedDate = Instant.now().toString();
    }
}
