package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Order;
import edu.mum.ishop.services.OrdersService;
import edu.mum.ishop.util.AttributeName;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private OrdersService ordersService;
//    private AuthenticationService authenticationService;
//    private ProductsService productsService;

    @Override
    public void init() throws ServletException {

        ordersService = new OrdersService();
//        authenticationService = new AuthenticationService();
//        productsService = new ProductsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order order = getOrder(req);
        createOrderOnline(req, order);
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }

    private void createOrderOnline(HttpServletRequest req, Order order) {
        if(req.getParameter("productId") != null) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            ordersService.addOrderLine(order, productId);
            req.getSession().setAttribute(AttributeName.cartSession, order);
        }
    }

    private Order getOrder(HttpServletRequest req) {
        Order order;
        if (req.getSession().getAttribute(AttributeName.cartSession) == null) order = ordersService.createOrder(0);
        else order = (Order) req.getSession().getAttribute(AttributeName.cartSession);
        return order;
    }
}
