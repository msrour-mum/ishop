package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.Product;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.UserData;
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

@WebServlet(name ="login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private edu.mum.ishop.services.UsersService UsersService;

    @Override
    public void init() throws ServletException {

        UsersService = new UsersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("inputEmail");
        String pass=req.getParameter("inputPassword");
        UserData user=UsersService.login(username,pass);
        if (user!=null) {
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/home");
        }
        else
        {
            req.setAttribute("isError",true);
            req.setAttribute("errMsg","Invaild UserName and password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
