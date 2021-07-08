package com.stockmarket.core_d.exception;

import com.stockmarket.core_d.domain.Error;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
public class ApplicationException extends RuntimeException{

    private Error error;
    @Transient
    private Integer statusCode;

    public ApplicationException(Error error, Integer statusCode) {
        this.error = error;
        this.statusCode = statusCode;
    }
}
