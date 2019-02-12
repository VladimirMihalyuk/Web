package by.isysoi.Model.Entity;

import java.math.BigDecimal;

public class Bet {

    private int id;
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bet(BigDecimal amount) {
        setAmount(amount);
    }

    public Bet(int id, BigDecimal amount) {
        setId(id);
        setAmount(amount);
    }


}
