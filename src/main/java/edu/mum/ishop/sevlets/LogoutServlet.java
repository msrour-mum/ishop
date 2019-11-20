package edu.mum.ishop.sevlets;


import edu.mum.ishop.util.AttributeName;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="logout", urlPatterns = "/logout")
public class LogoutServlet  extends HttpServlet {

    private edu.mum.ishop.services.ProductsService productsService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(AttributeName.userSession);
        req.getSession().removeAttribute(AttributeName.cartSession);
        resp.sendRedirect("/home");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
