package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.modelView.UserData;
import edu.mum.ishop.services.AuthenticationService;
import edu.mum.ishop.services.OrdersService;
import edu.mum.ishop.services.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private OrdersService ordersService;
    private AuthenticationService authenticationService;

    @Override
    public void init() throws ServletException {

        ordersService = new OrdersService();
        authenticationService = new AuthenticationService();
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

        if(req.getSession().getAttribute("cart") != null)
        {
            //User Logged in & Cart is empty.
            if(userData != null)
            {
               order = ordersService.createOrder(userData.getUserId());
            }
            else //Guest User and cart is empty;
            {
                order = ordersService.createOrder(0);
            }
        } // Cart is not empty
        else
        {
            order = (Order)req.getSession().getAttribute("cart");
            //Check if user is logged in (exists)
            if(userData != null) //logged in user
            {
                order.setUserId(userData.getUserId());
            }
        }

        OrderLine orderLine = new OrderLine( Integer.parseInt(req.getParameter("id")),
                Integer.parseInt(req.getParameter("orderId")),
                Integer.parseInt(req.getParameter("productId")),
                Float.parseFloat(req.getParameter("unitPrice")),
                Integer.parseInt(req.getParameter("Quantity")));

        ordersService.addOrderLine(order, orderLine);
        req.getSession().setAttribute("cart", order);
    }
}
