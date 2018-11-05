package cn.whale.retrofit.retrofitdemo;

/**
 * Created by nuts on 2018/11/5.
 */

public class User {
    private String uuid;
    private String username;
    private String passwd;
    private String pkgname;
    private int vcode;

    public User(String uuid, String username, String passwd, String pkgname, int vcode) {
        this.uuid = uuid;
        this.username = username;
        this.passwd = passwd;
        this.pkgname = pkgname;
        this.vcode = vcode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPkgname() {
        return pkgname;
    }

    public void setPkgname(String pkgname) {
        this.pkgname = pkgname;
    }

    public int getVcode() {
        return vcode;
    }

    public void setVcode(int vcode) {
        this.vcode = vcode;
    }
}
