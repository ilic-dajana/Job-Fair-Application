
package controllers;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.Return;
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
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
          
            String res = ControllerPage.checkAdmin(username);
            if(res!= null)
                return res;
            res=ControllerPage.checkKompanija(username);
            if(res!= null)
               return res;
            res=ControllerPage.checkStudent(username);
            if(res!= null)
               return res;
            
        }
       
        return null;
    }

     public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "login";
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
