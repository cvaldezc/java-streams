package io.chirs.streams.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Transaction {

    private Long id;
    private BigDecimal amount;
    private String currencyCode;
}
