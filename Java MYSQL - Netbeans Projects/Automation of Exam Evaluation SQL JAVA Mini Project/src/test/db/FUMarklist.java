package test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.table.DefaultTableModel;


public class FUMarklist extends javax.swing.JFrame {

    public String name;
    public int id;
    public String branch;
    public String course;
    public int courseid;
    public String code="sub";
    public String status;
    MySQLConnect ms = new MySQLConnect();
    
    DefaultTableModel model = new DefaultTableModel();
    
    @SuppressWarnings("empty-statement")
    public FUMarklist(int i, String n, int cid,String c,String b,String s) {
        
        name = n;
        id = i;
        branch = b;
        courseid = cid;
        course = c;
        status = s;
        code = code + Integer.toString(cid%10);
        
        boolean flg=false;
        
        String[] columnNames = new String[]{""};
        String querry = "select a.studid,m."+code+" from allocated a,marklist m where m.id like a.studid and fid = "+id+" and courseid = "+courseid+";";
        
        System.out.println(querry);
        try{
        Class.forName(ms.driver);  
            try (Connection con = DriverManager.getConnection(  
                    ms.url,ms.username,ms.password)) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(querry);
                while(rs.next())
                {
                    if (!flg)
                    {
                        flg=true;
                        columnNames = new String[]{"Student ID", "Mark"};
                        model.setColumnIdentifiers(columnNames);
                    }
                    System.out.println(rs.getString(1));
                    model.addRow(new Object[]{(rs.getString(1)),rs.getString(2)});
                }     
                if (!flg)
                {
                    model.setColumnIdentifiers(columnNames);
                    model.addRow(new Object[]{"\n\nYou Have no papers to evaluate"});
                }           
    }
    }catch(Exception e){ System.out.println(e);}
        initComponents();
        
    }

    private void readTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //int array[][] = new int [model.getRowCount()] [model.getColumnCount()];
        int i,j;
        
        try{  
            Class.forName(ms.driver);  
            try (Connection con = DriverManager.getConnection(  
                    ms.url,ms.username,ms.password)) {
                Statement stmt=con.createStatement();
              
                for (i =  (model.getRowCount() - 1 ); i >= 0; --i) {
                     int temp = Integer.parseInt(((String)model.getValueAt(i, 1)));
                     if (temp < 0 || temp > 100)
                     {
                         dispose();
                         new FUMarklist(id,name,courseid,course,branch,"Invalid mark entry").setVisible(true);
                     }
                      String querry = "update marklist set "+code+" = "+temp+" where id = "+((String)model.getValueAt(i, 0))+";" ;
                     //System.out.println(querry);
                     stmt.executeUpdate(querry);
                 }              
                }
        }catch(Exception e){ System.out.println(e);}  
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tfname1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfbranch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfbranch1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("ID");

        tfname1.setEditable(false);
        tfname1.setText(Integer.toString(id));
        tfname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfname1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        tfname.setEditable(false);
        tfname.setText(name);

        jLabel2.setText("Branch");

        tfbranch.setEditable(false);
        tfbranch.setText(branch);
        tfbranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfbranchActionPerformed(evt);
            }
        });

        jTable1.setModel(model);
        jTable1.setCellSelectionEnabled(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setEditingColumn(1);
        jTable1.setRowHeight(20);
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Subject");

        tfbranch1.setEditable(false);
        tfbranch1.setText(course);
        tfbranch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfbranch1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(status);

        jMenu1.setText("Back");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfname, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(tfname1)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfbranch, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfbranch1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfname1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfbranch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfbranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfbranchActionPerformed

   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        readTableData();
          dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfbranch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfbranch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfbranch1ActionPerformed

    private void tfname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfname1ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTable1PropertyChange

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenu1MenuSelected

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfbranch;
    private javax.swing.JTextField tfbranch1;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfname1;
    // End of variables declaration//GEN-END:variables
}
