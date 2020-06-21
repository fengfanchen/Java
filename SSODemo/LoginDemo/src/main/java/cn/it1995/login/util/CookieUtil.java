package cn.it1995.login.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CookieUtil {

    public static final String COOKIE_KEY = "LOGIN_COOKIE";

    public static String getLoginCookie(HttpServletRequest request, HttpServletResponse response){

        if(request.getCookies() != null){

            for(Cookie cookie : request.getCookies()){

                String name = cookie.getName();
                if(COOKIE_KEY.equals(name)){

                    return cookie.getValue();
                }
            }
        }

        return null;
    }


    public static String setLoginCookie(HttpServletRequest request, HttpServletResponse response){

        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(COOKIE_KEY, uuid);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return uuid;
    }
}
