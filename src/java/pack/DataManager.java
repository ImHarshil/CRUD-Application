/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikhil
 */
public class DataManager {
    private static String dbdriver="com.mysql.jdbc.Driver";
    private static String dbuser="root";
    private static String dburl="jdbc:mysql://localhost:3306/app_attendancedb";
    private static String dbpassword="";
      
 public static ResultSet executeQuery(){
     Connection con;
     Statement st;
     ResultSet rs = null;
        try {
            Class.forName(dbdriver);
            con=DriverManager.getConnection(dburl,dbuser,dbpassword);
            st=con.createStatement();
            rs=st.executeQuery("select * from studentmaster");
            return rs;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
            
        }
        return rs;
 }
 public static ResultSet executeQuery(String qry){
     Connection con;
     Statement st;
     ResultSet rs = null;
        try {
            Class.forName(dbdriver);
            con=DriverManager.getConnection(dburl,dbuser,dbpassword);
            st=con.createStatement();
            rs=st.executeQuery(qry);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
            
        }
        return rs;
 }
 public static void executeUpdate(String qry){
        try {
            Connection con;
            Statement st;
            Class.forName(dbdriver);
            con=DriverManager.getConnection(dburl,dbuser,dbpassword);
            st=con.createStatement();
            st.executeUpdate(qry);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
            
        }
     
 }
}
