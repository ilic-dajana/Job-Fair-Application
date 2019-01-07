
package controllers;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.dao.UserDao;
import util.dao.UserLoginDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "ControllerLogin")
@SessionScoped
public class ControllerLogin {
    private String username, password;
    private String msgUsername = "";
    private String msgPassword = "";
    
    public String login(){
        try {
            /*if(!UserLoginDao.nadjiUsername(username)){
                return "index";
            }*/
            
            if(UserLoginDao.uporediPassword(username,password)){
                return "proba";
            }
            return "error";
        } catch (SQLException ex) {            
            return "error";
        }        
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

    public String getMsgUsername() {
        return msgUsername;
    }

    public void setMsgUsername(String msgUsername) {
        this.msgUsername = msgUsername;
    }

    public String getMsgPassword() {
        return msgPassword;
    }

    public void setMsgPassword(String msgPassword) {
        this.msgPassword = msgPassword;
    }
    
    
    
}
