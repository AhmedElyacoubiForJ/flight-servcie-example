package edu.yacoubi.transaction.utils;

import edu.yacoubi.transaction.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtility {
    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 5000.0);
        paymentMap.put("acc4", 8000.0);
    }


    public static boolean validateCreditLimit(
            String accountNumber,
            double paidAmount) {
        if (paidAmount > paymentMap.get(accountNumber)) {
            throw new InsufficientAmountException("insufficient fund..!");
        } else {
            return true;
        }
    }
}
