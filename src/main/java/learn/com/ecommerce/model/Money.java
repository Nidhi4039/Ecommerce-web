package learn.com.ecommerce.model;

import lombok.Data;

@Data
public class Money {
    private final double amount;
    private final String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
