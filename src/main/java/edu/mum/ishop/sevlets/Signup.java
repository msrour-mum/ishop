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

@WebServlet(name ="Signup", urlPatterns = "/signup")
public class Signup  extends HttpServlet {

    private edu.mum.ishop.services.UsersService UsersService;

    @Override
    public void init() throws ServletException {

        UsersService = new UsersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* String search = req.getParameter("search");
        List<Product> products = productsService.getProducts(search);
        req.setAttribute("products", products);*/
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pass = req.getParameter("password");
        String repass = req.getParameter("repassword");
//        if (pass!=repass)
//        {
//            //req.setAttribute("ErrorMsg","Password Not Match");
//
//            req.setAttribute("isErrMsgsPresent", true);
//            req.setAttribute("errMsgs", "Password Not Match");
//            req.getRequestDispatcher("/signup").forward(req, resp);
//            return;
//
//        }

        User u =new User();
        u.setAddress(req.getParameter("address"));
        u.setAdmin(false);
        u.setEmail(req.getParameter("email"));
        u.setUserName(req.getParameter("userName"));

        String generatedSecuredPasswordHash = BCrypt.hashpw(pass, BCrypt.gensalt(12));
        u.setPassword(generatedSecuredPasswordHash);
        if (UsersService.AddUser(u)) {
            //req.getRequestDispatcher("/home").forward(req, resp);
            resp.sendRedirect("/login");
        }
        else
        {
            System.err.println("Error at user add");
        }
    }

}
