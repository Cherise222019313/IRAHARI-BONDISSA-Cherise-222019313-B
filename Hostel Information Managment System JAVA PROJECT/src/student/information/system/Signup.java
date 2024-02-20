 package student.information.system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class Signup extends javax.swing.JFrame {
    Connection conn=null;
   ResultSet rs=null;
   PreparedStatement pst=null;
    public Signup() {
    	design();
        conn=db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        currentDate();
    }
 public void currentDate (){
        
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        txt_date.setText((month+1)+"/"+day+"/"+year);
    }
     private void design() {
         jPanel1 = new JPanel();
         jLabel2 = new JLabel();
         jPanel2 = new JPanel();
         jLabel4 = new JLabel();
         jLabel5 = new JLabel();
         jLabel6 = new JLabel();
         txt_username = new JTextField();
         jButton1 = new JButton();
         Login = new JButton();
         txt_password = new JPasswordField();
         jComboBox1 = new JComboBox<>();
         jLabel7 = new JLabel();
         jMenuBar1 = new JMenuBar();
         txt_date = new JMenu();
         txt_time = new JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel2.setSize(2000, 900);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\hostels_Information_System\\src\\student\\information\\system\\images\\hostel.png"));
        jPanel1.add(jLabel2, BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATE ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Condensed", 1, 18)));
        jPanel2.setLayout(new GridLayout(0, 1));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4);

        txt_username.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel2.add(txt_username);

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5);

        txt_password.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel2.add(txt_password);

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel6.setText("Division");
        jPanel2.add(jLabel6);

        jComboBox1.setFont(new java.awt.Font("Rockwell Condensed", 1, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select...", "user" }));
        jPanel2.add(jComboBox1);

        jButton1.setFont(new java.awt.Font("Rockwell Condensed", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\images.png"));
        jButton1.setText("Signup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        Login.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login);

        jPanel1.add(jPanel2, BorderLayout.CENTER);

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 24));
        jLabel7.setText("Hostels");
        jPanel1.add(jLabel7, BorderLayout.NORTH);

        txt_date.setText("Date");
        txt_date.setFont(new java.awt.Font("Rockwell Condensed", 1, 14));
        jMenuBar1.add(txt_date);

        txt_time.setText("Time");
        txt_time.setFont(new java.awt.Font("Rockwell Condensed", 1, 14));
        jMenuBar1.add(txt_time);

        setJMenuBar(jMenuBar1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    
 
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {

        Login p =new Login();
        p.setVisible(true);
        this.setVisible(false);
    } 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(txt_username.getText().isEmpty()||txt_password.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Please Fill Empty Fields" );
        }
        else{
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){         
        try {

            String sql ="insert into users  values (null,?,?,?) ";

            pst=conn.prepareStatement(sql);
             pst.setString(1,txt_username.getText());
            pst.setString(2,txt_password.getText());
            pst.setString(3,(String)jComboBox1.getSelectedItem());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data is saved successfully");
            Login h=new Login();
            h.setVisible(true);
            this.dispose();
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

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    private JButton Login;
   private JButton jButton1;
   private JComboBox<String> jComboBox1;
   private JLabel jLabel2;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JMenuBar jMenuBar1;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JMenu txt_date;
   private JPasswordField txt_password;
   private JMenu txt_time;
   private JTextField txt_username;

   
}
