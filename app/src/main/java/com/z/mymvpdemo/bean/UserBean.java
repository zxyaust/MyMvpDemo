package com.z.mymvpdemo.bean;

public class UserBean {
    private String UName;
    private String Psd;

    public UserBean(String uname, String psd) {
        this.UName = uname;
        this.Psd = psd;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getPsd() {
        return Psd;
    }

    public void setPsd(String psd) {
        Psd = psd;
    }
}