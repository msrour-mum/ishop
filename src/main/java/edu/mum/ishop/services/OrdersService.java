package edu.mum.ishop.services;

import edu.mum.ishop.dao.UsersDAO;
import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.model.Product;
import edu.mum.ishop.modelView.UserData;

import java.util.Optional;

public class OrdersService {

    private ProductsService productsService;
    public OrdersService()
    {
        productsService = new ProductsService();
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
    public boolean Checkout(Order order, UserData userData)
    {
       order.setCheckout(true);
       //UsersDAO.Save(order);
        return true;
    }
}
