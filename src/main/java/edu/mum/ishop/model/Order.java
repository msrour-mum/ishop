package edu.mum.ishop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private LocalDate orderDate;
    private float tax;
    private float shipping;
    private float subtotal;
    private float total;
    private boolean isCheckout;

    private List<OrderLine> orderLines;

    public Order()
    {
        this.orderLines = new ArrayList<>();
        this.shipping = 1.25F;
        this.tax = 2.25F;
    }
    public Order(int userId)
    {
        this.userId = userId;
        this.shipping = 1.25F;
        this.tax = 2.25F;
        this.orderLines = new ArrayList<>();
    }
    public Order(int id, int userId, LocalDate orderDate, float tax, float shipping, float subtotal, float total, boolean isCheckout) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.tax = tax;
        this.shipping = shipping;
        this.subtotal = subtotal;
        this.total = total;
        this.isCheckout = isCheckout;
        this.orderLines = new ArrayList<>();
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
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
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
