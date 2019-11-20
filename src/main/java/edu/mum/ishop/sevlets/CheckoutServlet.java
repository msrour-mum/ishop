package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.modelView.UserData;
import edu.mum.ishop.services.AuthenticationService;
import edu.mum.ishop.services.OrdersService;
import edu.mum.ishop.util.AttributeName;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="checkout", urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {
    private OrdersService ordersService;

    @Override
    public void init() throws ServletException {

        ordersService = new OrdersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute(AttributeName.userSession) == null)
            RedirectToLogin(req, resp, "/checkout");
        else
            req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute(AttributeName.userSession) == null) {
            RedirectToLogin(req, resp, "/checkout");
        }
        else {
            UserData userData = (UserData)req.getSession().getAttribute(AttributeName.userSession);
            Order order = (Order)req.getSession().getAttribute(AttributeName.cartSession);
            boolean success = ordersService.checkout(order, userData.getUserId());
            if(success)
            {
                req.getSession().setAttribute(AttributeName.cartSession, null);
                resp.sendRedirect("/thank-you");
            }
        }
    }

    private void RedirectToLogin(HttpServletRequest req, HttpServletResponse resp, String returnUrl) throws IOException {
        req.getSession().setAttribute(AttributeName.returnUrlSession, returnUrl);
        resp.sendRedirect("/login");
    }
}