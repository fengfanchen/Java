package cn.it1995.service;

import cn.it1995.Object.MySession;
import cn.it1995.repository.SessionRepository;
import cn.it1995.tool.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LoginService {

    @Autowired
    SessionRepository sessionRepository;

    public String generateCookie(){

        String cookie = generateString(32);
        String salt = generateString(16);
        String offset = generateString(16);

        MySession mySession = new MySession(cookie, salt, offset);
        sessionRepository.addSession(mySession);
        return cookie;
    }


    public String getSaltByCookie(String cookie){

        return sessionRepository.getSaltByCookie(cookie);
    }

    public String getOffsetByCookie(String cookie){

        return sessionRepository.getOffsetByCookie(cookie);
    }

    public boolean isUserExist(String userName){

        if(userName.equals("admin")){

            return true;
        }

        return false;
    }

    public boolean isPasswordCorrect(String cookie, String password) throws Exception {

        String saltByCookie = sessionRepository.getSaltByCookie(cookie);
        String vi = sessionRepository.getOffsetByCookie(cookie);
        String decrypt = AESUtil.decrypt(password, saltByCookie, vi);
        if(decrypt.equals("admin")){

            return true;
        }

        return false;
    }

    public void removeAllSession(){

        sessionRepository.clearAllSession();
    }


    protected String generateString(Integer length){

        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();

        //cookie
        StringBuffer cookieSb = new StringBuffer();
        for(int i = 0; i < length; ++i){

            //产生0-61的数字
            int number = random.nextInt(62);

            //将产生的数字通过length次承载到sb中
            cookieSb.append(str.charAt(number));
        }

        return new String(cookieSb);
    }
}
