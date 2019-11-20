package edu.mum.ishop.modelView;

import java.sql.Date;

public class OrderView {

    private int id;
    private int userId;
    private Date orderDate;
    private float tax;
    private float shipping;
    private float subtotal;
    private float total;
    private boolean isCheckout;

    private String userName;
    private String address;
    private String email;

    public OrderView(int id, int userId, Date orderDate, float tax, float shipping, float subtotal, float total, boolean isCheckout, String userName, String address, String email) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.tax = tax;
        this.shipping = shipping;
        this.subtotal = subtotal;
        this.total = total;
        this.isCheckout = isCheckout;
        this.userName = userName;
        this.address = address;
        this.email = email;
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
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
