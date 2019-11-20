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

@WebServlet(name ="products", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    private edu.mum.ishop.services.ProductsService productsService;

    @Override
    public void init() throws ServletException {

        productsService = new ProductsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserData userData = req.getSession().getAttribute(AttributeName.userSession) != null ?
                (UserData) req.getSession().getAttribute(AttributeName.userSession) : null;
        if (userData==null || !userData.getIsAdmin())
        {
            resp.sendRedirect("/products");
        }
        else {
            List<Product> orders = productsService.getAllProducts();
            req.setAttribute("products",orders);
            req.getRequestDispatcher("/products.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
