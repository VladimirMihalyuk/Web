package by.isysoi.Model.Entity;

import java.math.BigDecimal;

/**
 * class that represent bet entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Bet {

    /**
     * id of bet
     */
    private int id;

    /**
     * amount of bet
     */
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


    private String FIO;

    /**
     * constructor to create bet
     * @param id id of bet
     * @param amount amount of bet
     */
    public Bet(int id, BigDecimal amount) {
        setId(id);
        setAmount(amount);
    }

    @Override
    public String toString() {
        return String.format("Bet:\n\tid - %d\n\tamount - %.2f", id, amount);
    }
}
