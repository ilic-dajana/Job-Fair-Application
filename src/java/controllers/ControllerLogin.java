
package controllers;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

            return "proba?faces-redirect=true";
        }
      return "error?faces-redirect=true";
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
