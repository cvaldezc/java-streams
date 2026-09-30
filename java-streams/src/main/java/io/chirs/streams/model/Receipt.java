package io.chirs.streams.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Receipt {

    private Transaction transactionOrigin;
    private BigDecimal exchangeRate;

}
