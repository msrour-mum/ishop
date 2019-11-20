package edu.mum.ishop.services;

import edu.mum.ishop.dao.DataAccessManager;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.UserData;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;

public class UsersService {

    public boolean AddUser(User usr)
    {
        DataAccessManager da=new DataAccessManager();
        return da.User_Add(usr);
    }

    public UserData login(String email, String pass)
    {
        DataAccessManager da=new DataAccessManager();
        User user=  da.User_Login(email);
        if (user==null)
            return  null;

       if (BCrypt.checkpw(pass , user.getPassword()))
       {
           UserData userData=new UserData(user.getId(),user.getUserName(),user.getEmail(),user.getAddress(),user.isAdmin(), LocalDateTime.now());
           return userData;
       }
       return null;

    }
}
