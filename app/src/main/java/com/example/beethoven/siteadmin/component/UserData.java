package com.example.beethoven.siteadmin.component;

import java.io.Serializable;

/**
 * Created by beethoven on 10.07.2017.
 */

public class UserData implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String nameUser;
    private String password;

    public UserData() {
    }

    public UserData(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
