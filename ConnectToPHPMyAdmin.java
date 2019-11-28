/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_dbms;
import java.sql.*;
import javax.swing.DefaultListModel;
/**
 *
 * @author Manu
 */
public class ConnectToPHPMyAdmin {
    Connection con=null;
    public ConnectToPHPMyAdmin() {
        try{
            //Update the connection details
           String url = "jdbc:mysql://remotemysql.com:3306/fBdTIWLEzp";
           Class.forName ("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection (url,"fBdTIWLEzp","06Pijj4Ftu");
           System.out.println ("Database connection established");
        }catch(Exception e){
            System.out.println(e);
        }
    }
     public ResultSet getResultSet(String qry){
        System.err.println(qry+"");
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();
                rs=stmt.executeQuery(qry);
            }
        }catch(Exception ex){
               System.err.println(ex+"");
        }
        return rs;
    }
//     DefaultListModel listModel = new DefaultListModel();
     public void getNames(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();
                rs=stmt.executeQuery(qry);
                while(rs.next())
                    gVar.names.add(rs.getString(1));
//                return null;
            }
        }catch(Exception ex){
            System.err.println(ex+"");
        }
//        return null;
    }
}
