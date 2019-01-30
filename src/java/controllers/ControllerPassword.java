/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.dao.UserDao;

/**
 *
 * @author dajana
 */

@ManagedBean(name = "ControllerPassword")
@SessionScoped
public class ControllerPassword {
    
    public String oldPassword, newPassword, username, confirmNewPassword;

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String changePassword(){
        
        if(UserDao.proveriKorisnika(username, oldPassword)){
           UserDao.promeniPassword(username, oldPassword, newPassword);
            return "index";
        }
        
        return "error";
    }    
    
    public ControllerPassword() {
    }  
    
    public ControllerPassword(String oldPassword, String newPassword, String username) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.username = username;
    }
    
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
    
}
