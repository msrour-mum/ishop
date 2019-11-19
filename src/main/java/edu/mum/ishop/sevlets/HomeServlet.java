package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Product;
import edu.mum.ishop.services.ProductsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="Home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private ProductsService productsService;

    @Override
    public void init() throws ServletException {

        productsService = new ProductsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        List<Product> products = productsService.getProducts(search);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
