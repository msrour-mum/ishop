package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Product;
import edu.mum.ishop.model.User;
import edu.mum.ishop.services.ProductsService;
import edu.mum.ishop.services.UsersService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="index", urlPatterns = "/index")
public class IndexServlet  extends HttpServlet {

    private edu.mum.ishop.services.ProductsService productsService;

    @Override
    public void init() throws ServletException {

        productsService = new ProductsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products =productsService.getAllProducts();
        req.setAttribute("products", products);
        //req.getRequestDispatcher("/index-product").forward(req, resp);
       req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       doGet(req,resp);
    }

}
