package sicxe.machine;

import java.io.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class Assembler extends javax.swing.JFrame {

    DefaultTableModel memmodel = new DefaultTableModel();
    DefaultTableModel symmodel = new DefaultTableModel();
    DefaultTableModel opmodel = new DefaultTableModel();
    DefaultTableModel basemodel = new DefaultTableModel();
    DefaultTableModel litmodel = new DefaultTableModel();
    
    String inter="",object="",source="",error="";
    
    public Assembler() {
        initComponents();
    }
    
    public Assembler(boolean fl)
    {
        memmodel.setColumnIdentifiers(new String[]{"LOC","VAL"});
        opmodel.setColumnIdentifiers(new String[]{"OPCODE","HEX","SIZE"});
        litmodel.setColumnIdentifiers(new String[]{"NAME","ADD","VAL","SIZE"});
        symmodel.setColumnIdentifiers(new String[]{"NAME","R/A","VAL"});
        basemodel.setColumnIdentifiers(new String[]{"FLAG","LOC"});
        
        try{  
            
            Scanner sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-OPTAB.txt")); 
            while (sc.hasNext())
                opmodel.addRow(new String[]{sc.next(),sc.next(),sc.next()});
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-SYMTAB.txt")); 
            while (sc.hasNext())
                symmodel.addRow(new String[]{sc.next(),sc.next(),sc.next()});
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-LITTAB.txt")); 
            while (sc.hasNext())
                litmodel.addRow(new String[]{sc.next(),sc.next(),sc.next(),sc.next()});
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-BASETAB.txt")); 
            while (sc.hasNext())
                basemodel.addRow(new String[]{sc.next(),sc.next()});
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-memory.txt")); 
            while (sc.hasNext())
                memmodel.addRow(new String[]{sc.next(),sc.next()});

            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\objectcode.txt")); 
            sc.useDelimiter("\\Z"); 
            object = sc.next();
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\openfile.sic")); 
            sc.useDelimiter("\\Z"); 
            source = sc.next();
            
            sc = new Scanner(new File("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\file-list.txt")); 
            sc.useDelimiter("\\Z"); 
            inter = sc.next();
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assembler");
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(source);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 350, 240));

        jTable1.setModel(opmodel);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 270));

        jTable2.setModel(symmodel);
        jTable2.setEnabled(false);
        jScrollPane4.setViewportView(jTable2);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 160, 120));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 41, 1, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setLabelFor(this);
        jLabel1.setText("SICXE");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText(inter);
        jScrollPane5.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 390, 279));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText(object);
        jScrollPane6.setViewportView(jTextArea4);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 540, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("BASE TAB");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 70, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Intermediate File");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 137, -1));

        jTable3.setModel(memmodel);
        jTable3.setEnabled(false);
        jTable3.setRowSelectionAllowed(false);
        jScrollPane7.setViewportView(jTable3);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 110, 560));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("IMPORT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Memory");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Object File");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 70, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("OPTAB");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, 137, 10));

        jTable4.setModel(basemodel);
        jTable4.setEnabled(false);
        jScrollPane3.setViewportView(jTable4);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 110, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("SYMTAB");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 137, 20));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(error);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, 147, 21));

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("LITTAB");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 137, 20));

        jTable5.setModel(litmodel);
        jTable5.setEnabled(false);
        jScrollPane8.setViewportView(jTable5);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 250, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        Runtime run = Runtime.getRuntime();
        try{
            String cmd=/*"cd \"C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\\" \n */"wsl ls";
            System.out.println(cmd);
            Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            if ((line=buf.readLine())!=null) {
              error = "Assembling : "+line;
            }
            
            pr = run.exec("gcc Loader.c && .\\a.exe");
            pr.waitFor();
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            line = "";
            if ((line=buf.readLine())!=null) {
              error = "Loading : "+line;
            }
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
        dispose();
        new Assembler(true).show();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
}
