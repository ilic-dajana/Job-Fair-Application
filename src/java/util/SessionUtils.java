package util;

import beans.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        } else {
            return null;
        }
    }
    
    public static void putUser(User user){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
    }
    public static void putUsername(String username){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
    }
    
    public static void invalidateSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public static User getUser(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (User) session.getAttribute("user");
    }
}