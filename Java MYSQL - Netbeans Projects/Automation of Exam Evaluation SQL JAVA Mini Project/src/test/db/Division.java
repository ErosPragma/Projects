/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manu
 */
public class Division {
    
    @SuppressWarnings("empty-statement")
    Division()
    {
        String stdid="";
        String courseid="";
        String fid="";
        
        int count=0;
        String querry1 = "select st.id as stdid, st.clgid, c.id as courseid from students st,course c where c.branch like st.branch  order by courseid;";
        String querry2 = "select f.id as fdid,f.clgid, c.id as courseid from faculty f,course c where c.branch like f.branch order by courseid;";
        //String querry3 = ;
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
            try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/project?characterEncoding=latin1&useConfigs=maxPerformance","testroot","testroot")) {
                Statement stmt1=con.createStatement();
                Statement stmt2=con.createStatement();
                Statement stmt3=con.createStatement();
         
                ResultSet rs1 = stmt1.executeQuery(querry1) ;
                ResultSet rs2 = stmt2.executeQuery(querry2);
               
                
                rs2.next();
                while(rs1.next())
                {
                     
                    //System.out.println(rs1.getString(1));
                    stdid = rs1.getString(1);
                    courseid = rs1.getString(3);
                    //System.out.println(courseid+"\t"+rs2.getString(3));
                    if ( courseid.equals(rs2.getString(3))  )
                    {
                        fid = rs2.getString(1);
                        //System.out.println(stdid+"\t"+courseid+"\t"+fid);
                        stmt3.executeUpdate("insert into allocated values ("+Integer.parseInt(fid)+","+Integer.parseInt(courseid)+","+Integer.parseInt(stdid)+");");
                        count++;                      
                    }
                    else
                    {    while(rs2.next() && courseid.equals(rs2.getString(3))==false);
                    
                        fid = rs2.getString(1);
                        //System.out.println(stdid+"\t"+courseid+"\t"+fid);
                        stmt3.executeUpdate("insert into allocated values ("+Integer.parseInt(fid)+","+Integer.parseInt(courseid)+","+Integer.parseInt(stdid)+");");
                        count++;
                    }
                    if (count%5 == 0)
                        rs2.next();
                }
                /*rs1.close();
                rs2.close();*/
            }
 
        }catch(Exception e )
        { 
            System.out.println("-");}  
        
    }
}
