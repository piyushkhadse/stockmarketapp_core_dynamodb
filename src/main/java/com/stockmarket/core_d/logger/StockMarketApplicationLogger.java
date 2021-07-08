package com.stockmarket.core_d.logger;

import com.stockmarket.core_d.events.publisher.KafkaPublisher;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

@NoArgsConstructor
public class StockMarketApplicationLogger implements StockMarketLogger {

    @Value("${log.messaging.producer.topic}")
    protected String topic;
    @Autowired
    protected KafkaPublisher publisher;
    protected Logger logger;
    protected Level level;
    protected Properties properties;

    public <T> StockMarketApplicationLogger(Class<T> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public static <T> StockMarketApplicationLogger getLogger(Class<T> clazz) {
        return new StockMarketApplicationLogger(clazz);
    }

    public StockMarketLogger log(String message, Object... parameters) {
        if (this.level == null) {
            this.level = Level.INFO;
        }

        switch (this.level) {
            case DEBUG:
                logger.debug(message, parameters);
                break;
            case WARN:
                logger.warn(message, parameters);
                break;
            case ERROR:
                logger.error(message, parameters);
                break;
            case INFO:
            default:
                logger.info(message, parameters);
                break;
        }

        return this;
    }


    public StockMarketLogger info() {
        this.level = Level.INFO;
        return this;
    }

    public StockMarketLogger debug() {
        this.level = Level.DEBUG;
        return this;
    }

    public StockMarketLogger warn() {
        this.level = Level.WARN;
        return this;
    }

    public StockMarketLogger error() {
        this.level = Level.ERROR;
        return this;
    }

}
