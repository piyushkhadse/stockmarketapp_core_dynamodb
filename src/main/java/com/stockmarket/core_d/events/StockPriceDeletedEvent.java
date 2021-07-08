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
public class StockPriceDeletedEvent extends DomainEvent {
    @DynamoDBAttribute
    private String companyCode;

    public StockPriceDeletedEvent(String aggregateId, String aggregateType, String companyCode) {
        super(aggregateId, aggregateType, Events.STOCK_PRICE_DELETED_EVENT.getValue());
        this.companyCode = companyCode;
    }

}
