package com.stockmarket.core_d.events;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.stockmarket.core_d.enums.Events;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DynamoDBDocument
public class CompanyRegisteredEvent extends DomainEvent {
    @DynamoDBAttribute
    private String companyName;
    @DynamoDBAttribute
    private String companyCode;
    @DynamoDBAttribute
    private String companyCEO;
    @DynamoDBAttribute
    private Double companyTurnover;
    @DynamoDBAttribute
    private String companyWebsite;
    @DynamoDBAttribute
    private String stockExchange;

    public CompanyRegisteredEvent(String aggregateId, String aggregateType, String companyName, String companyCode,
                                  String companyCEO, Double companyTurnover, String companyWebsite, String stockExchange) {
        super(aggregateId, aggregateType, Events.COMPANY_REGISTERED_EVENT.getValue());
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.companyCEO = companyCEO;
        this.companyTurnover = companyTurnover;
        this.companyWebsite = companyWebsite;
        this.stockExchange = stockExchange;
    }
}
