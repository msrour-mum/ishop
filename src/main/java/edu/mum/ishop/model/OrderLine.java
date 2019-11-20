package edu.mum.ishop.model;

public class OrderLine {

    private int id;
    private int orderId;
    private int productId;
    private Product product;
    private float unitPrice;
    private int quantity;
    private float subtotal;

    public OrderLine(){

    }

    public OrderLine(int id, int orderId, int productId, float unitPrice, int quantity, float subtotal) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public OrderLine(int productId, float unitPrice, Product product) {
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = 1;
        this.product = product;
        this.subtotal = unitPrice * this.quantity;
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
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
