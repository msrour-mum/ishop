package edu.mum.ishop.model;

import java.util.Date;

public class Order {

    private int id;
    private int userId;
    private Date orderDate;
    private float tax;
    private float shipping;
    private float subtotal;
    private float total;
    private boolean IsCheckout;

    public Order(int id, int userId, Date orderDate, float tax, float shipping, float subtotal, float total, boolean isCheckout) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.tax = tax;
        this.shipping = shipping;
        this.subtotal = subtotal;
        this.total = total;
        IsCheckout = isCheckout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isCheckout() {
        return IsCheckout;
    }

    public void setCheckout(boolean checkout) {
        IsCheckout = checkout;
    }
}
