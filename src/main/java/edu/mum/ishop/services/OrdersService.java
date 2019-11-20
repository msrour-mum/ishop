package edu.mum.ishop.services;

import edu.mum.ishop.dao.DataAccessManager;
import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;

import edu.mum.ishop.modelView.OrderView;
import edu.mum.ishop.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrdersService {

    private ProductsService productsService;
    private DataAccessManager dataAccess;

    public OrdersService()
    {
        productsService = new ProductsService();
        this.dataAccess = new DataAccessManager();
    }

    public Order createOrder(int userId)
    {
        if(userId == 0)
            return new Order();
        return new Order(userId);
    }

    public void addOrderLine(Order order, int productId)
    {
        Product product = productsService.getProduct(productId);

        Optional<OrderLine> optionalOderLineToAddOrEdit = order.getOrderLines()
                .stream()
                .filter(ol -> ol.getProduct().getId() == product.getId())
                .findFirst();

        if(optionalOderLineToAddOrEdit.isEmpty()) {

            OrderLine orderLine = new OrderLine(product.getId(),
                    product.getPrice(),
                    product);
            order.getOrderLines().add(orderLine);
        }
        else {
             OrderLine oderLineToAddOrEdit  = optionalOderLineToAddOrEdit.get();
             oderLineToAddOrEdit.setQuantity(oderLineToAddOrEdit.getQuantity() + 1);
             oderLineToAddOrEdit.setSubtotal(oderLineToAddOrEdit.getQuantity() * oderLineToAddOrEdit.getUnitPrice());
        }

        float subTotal = (float) order
                .getOrderLines()
                .stream()
                .mapToDouble(ol -> ol.getQuantity() * ol.getUnitPrice())
                .sum();

        order.setSubtotal(subTotal);

        float total = subTotal + order.getShipping() + order.getTax();
        order.setTotal(total);
    }

    public void removeOrderLine(Order order, int productId)
    {
        Product product = productsService.getProduct(productId);

        Optional<OrderLine> optionalOrderLine = order.getOrderLines()
                .stream()
                .filter(ol -> ol.getProduct().getId() == product.getId())
                .findFirst();

        if(optionalOrderLine.isPresent()){
            OrderLine oderLineToRemove = optionalOrderLine.get();
            oderLineToRemove.setQuantity(oderLineToRemove.getQuantity() - 1);
            oderLineToRemove.setSubtotal(oderLineToRemove.getQuantity() * oderLineToRemove.getUnitPrice());

            if(oderLineToRemove.getQuantity() <= 0) {

                order.getOrderLines().remove(oderLineToRemove);
            }
        }

        float subTotal = (float) order
                .getOrderLines()
                .stream()
                .mapToDouble(ol -> ol.getQuantity() * ol.getUnitPrice())
                .sum();

        order.setSubtotal(subTotal);

        float total = subTotal + order.getShipping() + order.getTax();
        order.setTotal(total);
    }

    public boolean checkout(Order order, int userId)
    {
        order.setUserId(userId);
       order.setCheckout(true);
       order.setOrderDate(LocalDate.now());
       return dataAccess.Order_Add(order);
    }


    public List<OrderView> getAllOrders()
    {
        List<OrderView> orders = dataAccess.OrderView_SelectAll();
        return orders;
    }
}
