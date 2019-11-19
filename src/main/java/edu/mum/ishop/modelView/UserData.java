package edu.mum.ishop.modelView;

import java.util.Date;

public class UserData {

    private int userId;
    private String userName;
    private Date loginTime;
    private boolean isAdmin;

    public UserData(int userId, String userName, Date loginTime, boolean isAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.loginTime = loginTime;
        this.isAdmin = isAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
