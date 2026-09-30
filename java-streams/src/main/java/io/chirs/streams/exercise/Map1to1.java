package io.chirs.streams.exercise;

import io.chirs.streams.model.Receipt;
import io.chirs.streams.model.Transaction;

import java.math.BigDecimal;
import java.util.*;

public class Map1to1 {

    private static Map<String, BigDecimal> exchangeCurrencies;
    public static void main(String[] args) {
        Transaction trx1 = new Transaction(1L, BigDecimal.valueOf(234.43), "USD");
        Transaction trx2 = new Transaction(2L, BigDecimal.valueOf(2354.43), "USD");
        Transaction trx3 = new Transaction(3L, BigDecimal.valueOf(8756.54), "PEN");
        Collection<Transaction> transactions = List.of(trx1, trx2, trx3);

        exchangeCurrencies = Map.of("USD", BigDecimal.valueOf(3.5), "PEN", BigDecimal.valueOf(1));

        transactions.stream().map(trx -> new Receipt(trx, obtenerTipoCambio(trx.getCurrencyCode())))
                .forEach(System.out::println);
    }
    public static BigDecimal obtenerTipoCambio(String moneda) {
        return Optional.ofNullable(exchangeCurrencies.get(moneda)).orElseThrow(() -> new RuntimeException("Moneda no encontrada"));
    }
}
