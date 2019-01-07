/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DB;

/**
 *
 * @author dajana
 */
public class UserLoginDao {
    public static boolean nadjiUsername(String username) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DB.getInstance().getConnection();
            if(conn == null)
                return false;
            ps = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
            ps.setString(1, username);                    
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                return true;
            else
                return false;
                   
        }catch(Exception e){
            return false;
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                DB.getInstance().putConnection(conn);
        }    
    }
    
     public static boolean uporediPassword(String username,String password) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DB.getInstance().getConnection();
            if(conn == null)
                return false;
            ps = conn.prepareStatement("SELECT * FROM User WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            String pass ="";
            if(rs.next()){
                pass = rs.getString("password");            
                if(pass.compareTo(password) == 0)
                    return true;
            }
            return false;
                   
        }catch(Exception e){
            return false;
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                DB.getInstance().putConnection(conn);
        }    
    }
    
    
}
