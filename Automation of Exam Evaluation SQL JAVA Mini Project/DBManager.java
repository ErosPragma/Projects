/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
//import miniproject.utils.*;
/**
 *
 * @author student
 */
public class DBManager extends javax.swing.JFrame {

    /**
     * Creates new form MiniProject
     */
    //ConnectToMYSQL cn=null;
    public DBManager() {
       // cn=new ConnectToMYSQL();
       
       try{  
         Class.forName("com.mysql.jdbc.Driver");  
              try (Connection con = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/project?characterEncoding=latin1&useConfigs=maxPerformance","testroot","testroot")) {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("");
            while(rs.next())
            System.out.println(rs.getString(1)+":"+rs.getString(2));  
    }
}catch(ClassNotFoundException | SQLException e){ System.out.println(e);}  
        initComponents();
       
    }

    private void LoadTableData(String tbl){
      try{
           ResultSet rs=cn.getResultSet("select * from "+tbl);
            jTable2.setModel(buildTableModel(rs));
      }catch(Exception ex){
          
          
      }
       
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxt_blname = new javax.swing.JTextField();
        jbtn_viewdata = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_fields_data = new javax.swing.JTable();
        btn_insertrow = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxt_query = new javax.swing.JTextField();
        jbtn_executequery = new javax.swing.JButton();
        txt_log = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Table");
        jLabel1.setToolTipText("");

        jbtn_viewdata.setText("View");
        jbtn_viewdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_viewdataActionPerformed(evt);
            }
        });

        tbl_fields_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Field", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_fields_data);

        btn_insertrow.setText("Insert");
        btn_insertrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertrowActionPerformed(evt);
            }
        });

        jLabel2.setText("Query");
        jLabel2.setToolTipText("");

        jbtn_executequery.setText("View");
        jbtn_executequery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_executequeryActionPerformed(evt);
            }
        });

        txt_log.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_log.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_log))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_insertrow)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_blname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_viewdata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_query, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_executequery)))
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_blname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_viewdata)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_query, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_executequery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_log)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_insertrow)
                .addGap(67, 67, 67))
        );

        jtxt_blname.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_viewdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_viewdataActionPerformed
        // TODO add your handling code here:
        
        LoadTableData(jtxt_blname.getText());
        generateControls();
    }//GEN-LAST:event_jbtn_viewdataActionPerformed

    private void btn_insertrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertrowActionPerformed
        // TODO add your handling code here:
        String _insertdata="",_insertcolumn="";
        DefaultTableModel model = (DefaultTableModel) tbl_fields_data.getModel();
        for (int count = 0; count < model.getRowCount(); count++){
            if(_insertdata==""){
                    _insertdata="'"+model.getValueAt(count, 1).toString()+"'";
                _insertcolumn=""+model.getValueAt(count, 0).toString()+"";        
            }else{
                           _insertdata+="," + "'"+model.getValueAt(count, 1).toString()+"'";
            _insertcolumn+="," + ""+model.getValueAt(count, 0).toString()+""; 
            }
       }
           _insertcolumn+="";
            
            txt_log.setText("insert into "+ jtxt_blname.getText() +"(" +_insertcolumn+") values (" +_insertdata+")");

    }//GEN-LAST:event_btn_insertrowActionPerformed

    private void jbtn_executequeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_executequeryActionPerformed
        try{
           ResultSet rs=cn.getResultSet(jtxt_query.getText());
            jTable2.setModel(buildTableModel(rs));
      }catch(Exception ex){
          
          txt_log.setText(ex.getMessage());
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_executequeryActionPerformed

    private void generateControls(){
        
       try{
           tbl_fields_data.removeAll();
            ResultSet rs=cn.getResultSet("select * from "+jtxt_blname.getText());
            ResultSetMetaData meta=rs.getMetaData();
            tbl_fields_data.removeAll();
             Vector<String> columnNames = new Vector<String>();
            int columnCount = meta.getColumnCount();
             DefaultTableModel model = (DefaultTableModel) tbl_fields_data.getModel();
            model.setRowCount(0);
            for (int column = 1; column <= columnCount; column++) {
               // columnNames.add(meta.getColumnName(column));
               
               
                model.addRow(new Object[]{meta.getColumnName(column), "",});
        
            }
            
       }catch(Exception ex){
           
           
           
       }
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DBManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBManager().setVisible(true);
            }
        });
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insertrow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtn_executequery;
    private javax.swing.JButton jbtn_viewdata;
    private javax.swing.JTextField jtxt_blname;
    private javax.swing.JTextField jtxt_query;
    private javax.swing.JTable tbl_fields_data;
    private javax.swing.JTextField txt_log;
    // End of variables declaration//GEN-END:variables
}
