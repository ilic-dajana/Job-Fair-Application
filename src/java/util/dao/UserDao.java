package util.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import util.DB;

/**
 *
 * @author dajana
 */
public class UserDao {
    public static boolean proveriUsername(String username) throws SQLException{
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
                return false;
            else
                return true;
                   
        }catch(Exception e){
            return false;
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                DB.getInstance().putConnection(conn);
        }    
    } 
    
    public static boolean unesiUser(String username, String password) throws SQLException{
          Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DB.getInstance().getConnection();
            if(conn == null)
                return false;
            ps = conn.prepareStatement("INSERT INTO User(username, password) VALUES(?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;       
        }catch(Exception e){
            return false;
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                DB.getInstance().putConnection(conn);
        }    
        
    }
    
    public static int nadjiUserKljuc(String username) throws SQLException{
      Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DB.getInstance().getConnection();
            if(conn == null)
                return -1;
            ps = conn.prepareStatement("SELECT id FROM User WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                return rs.getInt("id");
            else
                return -1;
                   
        }catch(Exception e){
            return -1;
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                DB.getInstance().putConnection(conn);
        }    
    } 
    
    public static boolean unesiStudent(String username, String password, String ime, String prezime, 
                                     int telefon, String email, int godStudija, int diplomirao) throws SQLException{
        
        boolean flag = unesiUser(username, password);
        if(!flag)
            return false;
        int UserKey = nadjiUserKljuc(username);
        
        if(UserKey < 0)
            return false;
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DB.getInstance().getConnection();
            if(conn == null)
                return false;
            ps = conn.prepareStatement("INSERT INTO student(id, ime, prezime, telefon, email, godina_studija, diplomirao) VALUES(?,?,?,?,?,?,?)");
            ps.setInt(1, UserKey);
            ps.setString(2, ime);
            ps.setString(3, prezime);
            ps.setInt(4, telefon);
            ps.setString(5, email);
            ps.setInt(6, godStudija);
            ps.setInt(7, diplomirao);
            
            ps.executeUpdate();
            return true;       
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
