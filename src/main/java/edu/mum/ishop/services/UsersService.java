package edu.mum.ishop.services;

import edu.mum.ishop.dao.DataAccessManager;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.UserData;
import org.mindrot.jbcrypt.BCrypt;

public class UsersService {

    public boolean AddUser(User usr)
    {
        DataAccessManager da=new DataAccessManager();
        return da.User_Add(usr);
    }

    public UserData login (String username, String pass)
    {
        DataAccessManager da=new DataAccessManager();
        String encPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
        return da.User_Login(username,encPass);
    }
}
