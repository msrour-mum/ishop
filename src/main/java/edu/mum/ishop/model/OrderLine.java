package edu.mum.ishop.model;

public class OrderLine {

    private int id;
    private int orderId;
    private int productId;
    private float unitPrice;
    private int Quantity;
    private float Subtotal;

    public OrderLine(int id, int orderId, int productId, float unitPrice, int quantity, float subtotal) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        Quantity = quantity;
        Subtotal = subtotal;
    }
    public OrderLine(int id, int orderId, int productId, float unitPrice, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        Quantity = quantity;
        Subtotal = unitPrice * Quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float subtotal) {
        Subtotal = subtotal;
    }
}
