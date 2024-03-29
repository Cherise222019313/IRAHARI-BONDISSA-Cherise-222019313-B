 
package student.information.system;

 
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class users extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

int q;
    
    public users() {
        initComponents();
        conn=db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        display();
       
    }
   
    public void display() 
    {
     try{
      pst = (PreparedStatement) conn.prepareStatement("select * from hostel");
    
    rs = pst.executeQuery();
    ResultSetMetaData stData = rs.getMetaData();
    
    q = stData.getColumnCount();
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    
    while(rs.next()){
    Vector columnData = new Vector();
   
    {
      columnData.add(rs.getString("id"));
      columnData.add(rs.getString("names"));
      columnData.add(rs.getString("room_no"));
      columnData.add(rs.getString("st_no"));
     
    RecordTable.addRow(columnData);
    }
    }
     }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex);
    }
   
    
    }
 /*  private void Getadmin() throws SQLException{
       try{
   pst = (PreparedStatement) conn.prepareStatement("select sum(hostel_name) from student where hostel_name=''");
   rs = pst.executeQuery();
    
    if(rs.next()){
    String sum = rs.getString("sum(hostel_name)");
    
   }
   }
       catch(Exception e){
           
       }}
    */
   
     
    private void initComponents() {
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

        jLabel3 = new javax.swing.JLabel("Student Number");
        txt_st = new javax.swing.JTextField();
        txt_st.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel2 = new javax.swing.JLabel("Room Number");
        txt_room = new javax.swing.JTextField();
        txt_room.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jLabel5 = new javax.swing.JLabel("Names");
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel("ID");
        txt_id = new javax.swing.JTextField();
        txt_id.setPreferredSize(new java.awt.Dimension(150, 28)); // Set preferred width
        jComboBox1.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select...", "Bengahz", "Kamborge", "Viette", "Titanic" }));

        cmd_add = new javax.swing.JButton("Add", new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/Save-icon.png")));
        cmd_update = new javax.swing.JButton("Update", new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/update icon.png")));
        cmd_delete = new javax.swing.JButton("Delete", new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/delete_16x16.gif")));
        jButton1 = new javax.swing.JButton("Clear", new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/erase-128.png")));
        cmd_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_addActionPerformed(evt);
            }
        });
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateActionPerformed(evt);
            }
        });
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        hGroup.addGroup(layout.createParallelGroup()
            .addComponent(jLabel3)
            .addComponent(jLabel2)
            .addComponent(jLabel5)
            .addComponent(jLabel4)
        );
        hGroup.addGroup(layout.createParallelGroup()
            .addComponent(txt_st)
            .addComponent(txt_room)
            .addComponent(jComboBox1)
            .addComponent(txt_id)
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
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "ID", "Names", "Room_numbers", "Number_of_student"
                }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1 = new javax.swing.JScrollPane(jTable1);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }


 
    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
          String value1=txt_id.getText();
         int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0){
         String sql ="delete from hostel where id=? ";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
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
        
        }
    
    } 
    private void cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateActionPerformed
       if(txt_id.getText().isEmpty() ||txt_room.getText().isEmpty() || txt_st.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Missing Information");
        }
       else{        
     try{

   String value1=txt_id.getText();
   String value2=(String) jComboBox1.getSelectedItem();
   String value3=txt_room.getText();
   String value4=txt_st.getText();
 

   String sql="update hostel set  names='"+value2+"', room_no='"+value3+"', st_no='"+value4+"' where id='"+value1+"'";

   pst=conn.prepareStatement(sql);

   pst.execute();
   JOptionPane.showMessageDialog(null,"Data Updated");  
   display();
 }

  catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
}
       }     
    } 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txt_room.setText("");
        txt_st.setText("");
        jComboBox1.setSelectedItem("");
        //txt_id.setText("");       
    } 
    private void cmd_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_addActionPerformed
   if(txt_room.getText().isEmpty() || txt_st.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"please fill empty fields");
   }else{
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
       if(p==0){        // TODO add your handling code here:

        try {

            String sql ="insert into hostel  values (null,?,?,?) ";

            pst=conn.prepareStatement(sql);
            pst.setString(1,(String)jComboBox1.getSelectedItem());
            pst.setString(2,txt_room.getText());
            pst.setString(3,txt_st.getText());
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         MainMenu h= new MainMenu();
         h.setVisible(true);
         this.dispose();
    } 
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int selectedRow =jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        txt_id.setText(model.getValueAt(selectedRow, 0).toString());
       jComboBox1.setSelectedItem(model.getValueAt(selectedRow, 1).toString());
        txt_room.setText(model.getValueAt(selectedRow, 2).toString());
       txt_st.setText(model.getValueAt(selectedRow,3 ).toString());
           
        
    } 
    private void txt_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roomActionPerformed
        // TODO add your handling code here:
    } 
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new users().setVisible(true);
            }
        });
    }

    
    
    
    
     private javax.swing.JButton cmd_add;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_room;
    private javax.swing.JTextField txt_st;
 }
