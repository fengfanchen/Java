package cn.it1995.Object;

public class MySession {

    public String cookie;
    public String salt;
    public String offset;

    public MySession(String cookie, String salt, String offset) {

        this.cookie = cookie;
        this.salt = salt;
        this.offset = offset;
    }
}
