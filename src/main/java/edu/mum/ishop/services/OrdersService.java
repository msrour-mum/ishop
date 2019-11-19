package edu.mum.ishop.services;

import edu.mum.ishop.dao.UsersDAO;
import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.modelView.UserData;

import java.util.Optional;

public class OrdersService {

    public Order createOrder(int userId)
    {
        if(userId == 0)
            return new Order();
        return new Order(userId);
    }

    public void addOrderLine(Order order, OrderLine orderLine)
    {
        Optional<OrderLine> orderToAddOrEdit = order.getOrderLines()
                .stream()
                .filter(ol -> ol.getId() == orderLine.getId())
                .findFirst();

        if(orderToAddOrEdit.isEmpty()) {
            order.getOrderLines().add(orderLine);
        }
        else {
            orderToAddOrEdit.get().setQuantity(orderLine.getQuantity());
        }
    }
    public boolean Checkout(Order order, UserData userData)
    {
       order.setCheckout(true);
       //UsersDAO.Save(order);
        return true;
    }
}
