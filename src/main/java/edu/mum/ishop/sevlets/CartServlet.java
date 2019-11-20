package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.model.Product;
import edu.mum.ishop.modelView.UserData;
import edu.mum.ishop.services.AuthenticationService;
import edu.mum.ishop.services.OrdersService;
import edu.mum.ishop.services.ProductsService;
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

        Order order;
        UserData userData = req.getSession().getAttribute("user-data") != null ?
                (UserData) req.getSession().getAttribute("user-data") : null;

        if(req.getSession().getAttribute(AttributeName.cartSession) == null)
        {
            //Cart is empty.
            if(userData != null)
            {
                //User Logged in & cart is not empty
               order = ordersService.createOrder(userData.getUserId());
            }
            else //Guest User and cart is empty;
            {
                order = ordersService.createOrder(0);
            }
        } // Cart is not empty
        else
        {
            order = (Order)req.getSession().getAttribute(AttributeName.cartSession);
            //Check if user is logged in (exists)
            if(userData != null) //logged in user
            {
                order.setUserId(userData.getUserId());
            }
        }

        if(req.getParameter("productId") != null) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            ordersService.addOrderLine(order, productId);
            req.getSession().setAttribute(AttributeName.cartSession, order);
        }
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
