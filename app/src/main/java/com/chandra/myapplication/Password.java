package com.chandra.myapplication;

public class Password {
    private String application;
    private String password;

    public Password(String application, String password) {
        this.application = application;
        this.password = password;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
