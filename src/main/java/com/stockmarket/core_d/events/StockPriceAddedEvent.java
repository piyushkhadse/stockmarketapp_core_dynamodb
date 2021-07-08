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
public class StockPriceAddedEvent extends DomainEvent {
    @DynamoDBAttribute
    private String companyCode;
    @DynamoDBAttribute
    private Double stockPrice;

    public StockPriceAddedEvent(String aggregateId, String aggregateType,
                                String companyCode, Double stockPrice) {
        super(aggregateId, aggregateType, Events.STOCK_PRICE_ADDED_EVENT.getValue());
        this.companyCode = companyCode;
        this.stockPrice = stockPrice;
    }
}
