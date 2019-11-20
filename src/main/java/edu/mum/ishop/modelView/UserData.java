package edu.mum.ishop.modelView;

import java.time.LocalDateTime;
import java.util.Date;

public class UserData {

    private int userId;
    private String userName;
    private String email;
    private String address;
    private boolean isAdmin;
    private LocalDateTime loginTime;

    public UserData(int userId, String userName, String email, String address, boolean isAdmin, LocalDateTime loginTime) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.isAdmin = isAdmin;

        this.loginTime  = loginTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
