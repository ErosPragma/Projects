package fts.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.jndi.cosnaming.CNCtx;
import java.sql.*;  
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author student
 */
public class ConnectToMYSQL {
    Connection con=null;
    public ConnectToMYSQL() {
        try{  
            //Update the connection details
           String database="";
           String url = "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=latin1&useConfigs=maxPerformance";
           Class.forName ("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection (url,"testroot","testroot");
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
    public String getSingleStringVal(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();  
                rs=stmt.executeQuery(qry); 
                if(rs.next())
                    return rs.getString(1);
                return null;
            }
        }catch(Exception ex){
            System.err.println(ex+"");
        }  
        return null;
    }  
    public int getSingleIntVal(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();  
                rs=stmt.executeQuery(qry); 
                if(rs.next())
                    return rs.getInt(1);
                return 0;
            }
        }catch(Exception ex){
        }  
        return -1;
    }   
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

    }
    public int InsertQuery(String qry){
        try{
            if(!con.isClosed()){               
               Statement statement = con.createStatement();
               statement.executeUpdate(qry);
               ResultSet rs=statement.getGeneratedKeys();
               if(rs.next())
                return rs.getInt(1);
               return 1;
            }
        }catch(Exception ex){
            System.err.println("Query:"+qry+"");
            System.err.println(ex.getMessage()+"");
            return -1;
        }
        return 0;
    }
    
    public int ExecuteQuery(String qry){
        try{
            if(!con.isClosed()){               
               Statement statement = con.createStatement();
               statement.executeUpdate(qry);
               return 1;
            }
        }catch(Exception ex){
            System.err.println("Query:"+qry+"");
            System.err.println(ex.getMessage()+"");
            return -1;
        }
        return 0;
    }
    public boolean  isValidText(String s){
        
        if(s.trim().length()>0){
            return true;
        }
        return false;
    }


}
