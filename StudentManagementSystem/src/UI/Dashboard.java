/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Code.DBconnect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Admin
 */
public class Dashboard extends javax.swing.JFrame {
    
    Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public Dashboard() {
        initComponents();
        conn=(Connection) DBconnect.connect();
        tableload();
    }

    public void tableload()
    {
        try {
            String sql="SELECT Id,Name,Age,Grade FROM student";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void tabledata()
    {
        int row=Table1.getSelectedRow();
        String id=Table1.getValueAt(row,0).toString();
        String name=Table1.getValueAt(row,1).toString();
        String age=Table1.getValueAt(row,2).toString();
        String grade=Table1.getValueAt(row,0).toString();
        txtId.setText(id);
        txtName.setText(name);
        txtAge.setText(age);
        cmbGrade.setSelectedItem(grade);
    }
    public void search()
    {
        String search=txtSearch.getText();
        try {
            String sql="SELECT * FROM student WHERE Name LIKE '%"+search+"%' OR Id LIKE '%"+search+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    public void update()
    {
        String id=txtId.getText();
        String name=txtName.getText();
        String age=txtAge.getText();
        String grade=cmbGrade.getSelectedItem().toString();
        
        try {
            String sql="UPDATE student SET name='"+name+"',age='"+age+"',grade='"+grade+"' WHERE id='"+id+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
             JOptionPane.showMessageDialog(null, "Data updated successfully:\nName: " + name + "\nAge: " + age + "\nGrade: " + grade, "Success", JOptionPane.INFORMATION_MESSAGE);

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void clear()
    {
        txtSearch.setText("");
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        cmbGrade.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmbGrade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 60));

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Grade");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 50, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Age");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));

        txtAge.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 170, 30));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel4.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, 30));

        cmbGrade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        jPanel4.add(cmbGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("ID");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 30, 20));

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel4.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 30, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 210));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 40));

        btnInsert.setBackground(new java.awt.Color(51, 255, 51));
        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 40));

        btnUpdate.setBackground(new java.awt.Color(0, 204, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 80, 40));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 450));

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 440, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
           String name = txtName.getText().trim();  // Remove leading/trailing spaces
    int age = 0, grade = 0;

    // Validate name is not empty
    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Name cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate name contains only letters and spaces
    if (!name.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "Name can only contain letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate age (check if it's a valid integer and between 1 to 100)
    try {
        age = Integer.parseInt(txtAge.getText().trim());
        if (age <= 0 || age > 100) {
            JOptionPane.showMessageDialog(null, "Age must be between 1 and 100!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid age! Please enter a valid age!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate grade selection (Check if a valid grade is selected)
    if (cmbGrade.getSelectedIndex() == 0) { // Index 0 is the "Select" option
        JOptionPane.showMessageDialog(null, "Please select a valid grade!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get grade from ComboBox (convert to integer)
    grade = Integer.parseInt(cmbGrade.getSelectedItem().toString());

    // If everything is valid, show a success message (or save the data)

    // Optionally, clear the form fields
    txtName.setText("");
    txtAge.setText("");
    cmbGrade.setSelectedIndex(0);


        try {
            String sql="INSERT INTO student (name,age,grade) VALUES ('"+name+"','"+age+"','"+grade+"')";
            pst=conn.prepareStatement(sql);
            pst.execute();    
            JOptionPane.showMessageDialog(null, "Data inserted successfully:\nName: " + name + "\nAge: " + age + "\nGrade: " + grade, "Success", JOptionPane.INFORMATION_MESSAGE);

            
           
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        tableload();
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        tabledata();
    }//GEN-LAST:event_Table1MouseClicked

    private void Table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyReleased
        tabledata();
    }//GEN-LAST:event_Table1KeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
        tableload();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete!");
        if(check==0)
        {
            String id=txtId.getText();
            
            try {
                String sql="DELETE FROM student WHERE id='"+id+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                  JOptionPane.showMessageDialog(null, "Data deleted successfully" , "Success", JOptionPane.INFORMATION_MESSAGE);
                  

            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       
            }
        }
        tableload();
        clear();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAge;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
