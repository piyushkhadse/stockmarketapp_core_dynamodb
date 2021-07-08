package com.stockmarket.core_d.domain;

import com.stockmarket.core_d.events.DomainEvent;

import org.springframework.data.annotation.Transient;
import java.util.ArrayList;
import java.util.List;


public abstract class AggregateRoot {
    @Transient
    private List<DomainEvent> events = new ArrayList();

    public AggregateRoot() {

    }

    public void registerEvent(DomainEvent event) {
        this.events.add(event);
    }

    public void clear(){
        this.events.clear();
    }public List<DomainEvent> events()  {
        return this.events;
    }


}
