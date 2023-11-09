package system.gathering.config;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import system.gathering.object.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@WebListener
public class SessionConfig implements HttpSessionListener {

    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    //중복로그인 지우기
    public synchronized static String getSessionidCheck(String type, String compareId){
        String result = "";
        for( String key : sessions.keySet() ){
            HttpSession hs = sessions.get(key);
            log.info("sessions = {}",sessions);
            log.info("hs={}",hs);
            log.info("user={}",hs.getAttribute(type));
            User attribute = (User)hs.getAttribute(type);
            if(hs != null &&  hs.getAttribute(type) != null && attribute.getUserId().equals(compareId) ){
                result =  key.toString();
                log.info("result={}",result);
            }
        }


        removeSessionForDoubleLogin(result);
        return result;
    }

    private static void removeSessionForDoubleLogin(String userId){
        System.out.println("remove userId : " + userId);
        if(userId != null && userId.length() > 0){
            sessions.get(userId).invalidate();
            sessions.remove(userId);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se);
        sessions.put(se.getSession().getId(), se.getSession());
        log.info("ddddddddddddddddddddd");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());
        }
    }
}
