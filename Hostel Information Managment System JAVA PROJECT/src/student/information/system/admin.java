package student.information.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 
public class admin extends javax.swing.JFrame {
   Connection conn=null;
     ResultSet rs=null;
    PreparedStatement pst=null;

    /**
     * Creates new form admin
     */
    public admin() {
        design();
        conn=db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
      display();
      Update_table3();
    }
    int q;
    
    public void display() 
    {
     try{
      pst = (PreparedStatement) conn.prepareStatement("select * from student");
    
    rs = pst.executeQuery();
    ResultSetMetaData stData = rs.getMetaData();
    
    q = stData.getColumnCount();
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    
    while(rs.next()){
    Vector columnData = new Vector();
   
    {
      columnData.add(rs.getString("id_no"));
      columnData.add(rs.getString("fname"));
      columnData.add(rs.getString("lname"));
      columnData.add(rs.getString("dob"));
       columnData.add(rs.getString("dob"));
       columnData.add(rs.getString("email"));
       columnData.add(rs.getString("telephone"));
       columnData.add(rs.getString("disability"));
       columnData.add(rs.getString("Hostel_name"));
       columnData.add(rs.getString("department"));
    RecordTable.addRow(columnData);
    }
    }
     }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    private void Update_table3() {
    try{
        
        
        String sql ="select * from student";
        
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        jTable1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs)); 

    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
             //e.printStackTrace();
            }
        }
    }
 
    @SuppressWarnings("unchecked")
     private void design() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hostel Record", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Condensed", 1, 18)));

        GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        jLabel3 = new JLabel("ID");
        txt_st = new JTextField();
        txt_st.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel2 = new JLabel("Names");
        txt_room = new JTextField();
        txt_room.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel5 = new JLabel("Hostel Name");
        jComboBox1 = new JComboBox<>();
        jLabel4 = new JLabel("D.O.B");
        txt_id = new JTextField();
        txt_id.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jComboBox1.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Select...", "Bengahz", "Kamborge", "Viette", "Titanic" }));

        // New labels and text fields
        jLabel6 = new JLabel("Gender");
        jTextField6 = new JComboBox<>();
        jTextField6.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jTextField6.setModel(new DefaultComboBoxModel<>(new String[] { "Select...", "Male", "Female" }));

        jTextField6.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel7 = new JLabel("Email");
        jTextField7 = new JTextField();
        jTextField7.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel8 = new JLabel("Telephone");
        jTextField8 = new JTextField();
        jTextField8.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel9 = new JLabel("Disability");
        jTextField9 = new JComboBox<>();
        jTextField9.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jTextField9.setModel(new DefaultComboBoxModel<>(new String[] { "Select...", "Yes", "No" }));

         jLabel10 = new JLabel("Hostel Name");
        jTextField10 = new JTextField();
        jTextField10.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel11 = new JLabel("Department");
        jTextField11 = new JTextField();
        jTextField11.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width

        cmd_add = new JButton("Add", new ImageIcon(getClass().getResource("/student/information/system/images/Save-icon.png")));
        cmd_update = new JButton("Update", new ImageIcon(getClass().getResource("/student/information/system/images/update icon.png")));
        cmd_delete = new JButton("Delete", new ImageIcon(getClass().getResource("/student/information/system/images/delete_16x16.gif")));
        jButton1 = new JButton("Clear", new ImageIcon(getClass().getResource("/student/information/system/images/erase-128.png")));
        cmd_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton5ActionPerformed(evt);
            }
        });
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
            }
        });
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //        cmd_deleteActionPerformed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //        jButton1ActionPerformed(evt);
            }
        });
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(jLabel3)
                .addComponent(jLabel2)
                .addComponent(jLabel5)
                .addComponent(jLabel4)
                .addComponent(jLabel6) // New label 6
                .addComponent(jLabel7) // New label 7
                .addComponent(jLabel8) // New label 8
                .addComponent(jLabel9) // New label 9
                .addComponent(jLabel10) // New label 10
                .addComponent(jLabel11) // New label 11
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(txt_st)
                .addComponent(txt_room)
                .addComponent(jComboBox1)
                .addComponent(txt_id)
                .addComponent(jTextField6) // New text field 6
                .addComponent(jTextField7) // New text field 7
                .addComponent(jTextField8) // New text field 8
                .addComponent(jTextField9) // New text field 9
                .addComponent(jTextField10) // New text field 10
                .addComponent(jTextField11) // New text field 11
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(cmd_add)
                .addComponent(cmd_update)
                .addComponent(cmd_delete)
                .addComponent(jButton1)
        );
        layout.setHorizontalGroup(hGroup);

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(txt_st)
                .addComponent(cmd_add)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txt_room)
                .addComponent(cmd_update)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jComboBox1)
                .addComponent(cmd_delete)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txt_id)
                .addComponent(jButton1)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jTextField6)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(jTextField7)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(jTextField8)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9)
                .addComponent(jTextField9)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(jTextField10)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11)
                .addComponent(jTextField11)
        );
        layout.setVerticalGroup(vGroup);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jLabel1 = new javax.swing.JLabel("HOSTEL MANAGEMENT SYSTEM");
        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 24));
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        jButton2 = new javax.swing.JButton("Back");
        jButton2.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        getContentPane().add(jButton2, java.awt.BorderLayout.EAST);

        jTable1 = new javax.swing.JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "ID", "Names", "Room_numbers", "Number_of_student"
                }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // jTable1MouseClicked(evt);
            }
        });
        jScrollPane1 = new javax.swing.JScrollPane(jTable1);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//add record into database
if(txt_st.getText().isEmpty() ||txt_room.getText().isEmpty() || jTextField7.getText().isEmpty()|| jTextField7.getText().isEmpty()|| jTextField7.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Please Fill Empty Fields");
        }
else{
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){        // TODO add your handling code here:

        try {
            String sql ="insert into student   values (null,?,?,?,?,?,?,?,?,?) ";

            pst=conn.prepareStatement(sql);
           // pst.setString(1,txt_id.getText());
            pst.setString(1,"c");
            pst.setString(2,"c");
            pst.setString(3, "x");
            pst.setString(4,"z"); 
            pst.setString(5,"x");
            pst.setString(6,"x");
            pst.setString(7,"xs");
            pst.setString(8,"s");
            pst.setString(9,txt_room.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data is saved successfully");
            display();

        }
        catch (Exception e)

        {
            JOptionPane.showMessageDialog(null,e);
            
        }
        finally {

            try{
                rs.close();
                pst.close();

            }
            catch(Exception e){

            }
        }
         
        }
                
       
        }
        


    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       //delete record
       String sql ="delete from student where id_no=? ";
            try{
                pst=conn.prepareStatement(sql);
               pst.setString(1,txt_id.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null,"Record Deleted");
                display();
            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e);
            }finally {

                try{
                    rs.close();
                    pst.close();

                }
                catch(Exception e){

                }
            }
       
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        MainMenu n= new MainMenu();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private  JButton cmd_add;
    private JButton cmd_delete;
    private JButton cmd_update;
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6; // New label 6
    private JLabel jLabel7; // New label 7
    private JLabel jLabel8; // New label 8
    private JLabel jLabel9; // New label 9
    private JLabel jLabel10; // New label 10
    private JLabel jLabel11; // New label 11
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txt_id;
    private JTextField txt_room;
    private JTextField txt_st;
    private JComboBox<String> jTextField6; // New text field 6
    private JTextField jTextField7; // New text field 7
    private JTextField jTextField8; // New text field 8
    private JComboBox<String> jTextField9; // New text field 9
    private JTextField jTextField10; // New text field 10
    private JTextField jTextField11; // New text field 11
 
    
    
    
}         