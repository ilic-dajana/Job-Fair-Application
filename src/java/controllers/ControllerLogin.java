
package controllers;

import beans.Konkurs;
import beans.User;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.Return;
import util.SessionUtils;
import util.dao.KompanijaDao;
import util.dao.UserDao;


/**
 *
 * @author dajana
 */
@ManagedBean(name = "ControllerLogin")
@SessionScoped
public class ControllerLogin implements Serializable {
    private String username, password;
    
    public String login(){
        
        if(UserDao.proveriKorisnika(username, password)){
            User user = UserDao.dohUser(username);
            
            if(user == null){
                return "index?faces-redirect=true";
            }
            SessionUtils.putUser(user);
            SessionUtils.putUsername(username);
            
            String res = ControllerPage.checkAdmin(username);
            if(res!= null)
               return res;
            res=ControllerPage.checkKompanija(username);
            if(res!= null)  
                return res;
            res=ControllerPage.checkStudent(username);
            if(res!= null)
               return res;
            username = password = "";
            
        }else{
            return null;
        }
        return null;
    }

     public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        SessionUtils.invalidateSession();
        SessionUtils.putUser(null);
        username = password = "";
        return "login?faces-redirect=true";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


   
    
    
}
