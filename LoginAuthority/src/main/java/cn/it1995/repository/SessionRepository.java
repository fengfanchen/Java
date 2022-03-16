package cn.it1995.repository;

import cn.it1995.Object.MySession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SessionRepository {

    private ArrayList<MySession> sessionList = new ArrayList<MySession>();

    public void addSession(MySession session){

        sessionList.add(session);
    }

    public String getSaltByCookie(String cookie){

        for(MySession mySession : sessionList){

            if(mySession.cookie.equals(cookie)){

                return mySession.salt;
            }
        }

        return null;
    }

    public String getOffsetByCookie(String cookie){

        for(MySession mySession : sessionList){

            if(mySession.cookie.equals(cookie)){

                return mySession.offset;
            }
        }

        return null;
    }

    public boolean isSessionExist(MySession session){

        for(MySession mySession : sessionList){

            if(mySession.cookie.equals(session.cookie)){

                return true;
            }
        }

        return false;
    }

    public void clearAllSession(){

        sessionList.clear();
    }

}
