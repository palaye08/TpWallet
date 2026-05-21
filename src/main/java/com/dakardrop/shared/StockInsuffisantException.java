package com.dakardrop.shared;

/**
 * Levée lorsqu'un stock est insuffisant pour satisfaire une opération.
 */
public class StockInsuffisantException extends DakarDropException {

    public StockInsuffisantException(String message) {
        super(message);
    }

    public StockInsuffisantException(String message, Throwable cause) {
        super(message, cause);
    }
}
