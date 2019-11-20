package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.Product;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.OrderView;
import edu.mum.ishop.modelView.UserData;
import edu.mum.ishop.services.OrdersService;
import edu.mum.ishop.services.ProductsService;
import edu.mum.ishop.services.UsersService;
import edu.mum.ishop.util.AttributeName;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="orders", urlPatterns = "/orders")
public class OrdersServlet extends HttpServlet {

    private edu.mum.ishop.services.OrdersService ordersService;

    @Override
    public void init() throws ServletException {

        ordersService = new OrdersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserData userData = req.getSession().getAttribute(AttributeName.userSession) != null ?
                (UserData) req.getSession().getAttribute(AttributeName.userSession) : null;
        if (userData==null || !userData.getIsAdmin())
        {
            resp.sendRedirect("/login");
        }
        else {
            List<OrderView> orders = ordersService.getAllOrders();
            req.setAttribute("orders",orders);
            req.getRequestDispatcher("/orders.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
