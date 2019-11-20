package edu.mum.ishop.sevlets;

import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.UserData;
import edu.mum.ishop.services.UsersService;
import edu.mum.ishop.util.AttributeName;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="Signup", urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {

    private edu.mum.ishop.services.UsersService usersService;

    @Override
    public void init() throws ServletException {

        usersService = new UsersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pass = req.getParameter("password");
        String email = req.getParameter("email");
        User u =new User();
        u.setAddress(req.getParameter("address"));
        u.setAdmin(false);
        u.setEmail(email);
        u.setUserName(req.getParameter("userName"));

        String generatedSecuredPasswordHash = BCrypt.hashpw(pass, BCrypt.gensalt(12));
        u.setPassword(generatedSecuredPasswordHash);
        if (usersService.AddUser(u)) {
            UserData userData = usersService.login(email, pass);

            if (userData!=null) {
                req.getSession().setAttribute(AttributeName.userSession,userData);

                if(req.getSession().getAttribute(AttributeName.returnUrlSession) == null)
                    resp.sendRedirect("/home");
                else {
                    String returnUrl = (String) req.getSession().getAttribute(AttributeName.returnUrlSession);
                    req.getSession().setAttribute(AttributeName.returnUrlSession, null);
                    resp.sendRedirect(returnUrl);
                }
            }
        }
        else
        {
            System.err.println("Error at user add");
        }
    }

}
