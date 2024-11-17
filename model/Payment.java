package model;

import java.util.Date;

public class Payment {
    private String id;
    private double amount;
    private Date date;
    private String paymentMethod;

    public Payment() {
    }

    public Payment(String id, double amount, Date date, String paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentId(String id) {
        this.id = id;
    }

    public String getPaymentId() {
        return this.id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }
}
