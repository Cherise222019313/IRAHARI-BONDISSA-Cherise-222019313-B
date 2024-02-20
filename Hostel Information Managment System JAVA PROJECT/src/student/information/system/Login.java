package student.information.system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
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

public class Login extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Login() {
        initComponents();
        conn = db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        currentDate();

    }

    public void currentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        txt_date.setText((month + 1) + "/" + day + "/" + year);
    }

      private void initComponents() {
        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txt_username = new JTextField();
        txt_password = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();
        jMenuBar1 = new JMenuBar();
        txt_date = new JMenu();
        txt_time = new JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "System Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Condensed", 0, 36), new java.awt.Color(0, 102, 204)));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        JPanel firstColumnPanel = new JPanel(new BorderLayout());
        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 24));
        jLabel5.setText("Hostels");
        firstColumnPanel.add(jLabel5, BorderLayout.NORTH);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/hostel.png")));
        firstColumnPanel.add(jLabel4, BorderLayout.CENTER);
        jPanel1.add(firstColumnPanel);

        JPanel secondColumnPanel = new JPanel(new GridLayout(0, 1));
        jPanel1.add(secondColumnPanel);

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel1.setText("Username");
        secondColumnPanel.add(jLabel1);
        secondColumnPanel.add(txt_username);

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel2.setText("Password");
        secondColumnPanel.add(jLabel2);
        secondColumnPanel.add(txt_password);

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jLabel3.setText("Category");
        secondColumnPanel.add(jLabel3);
        jComboBox1.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..", "Admin", "User" }));
        secondColumnPanel.add(jComboBox1);

        jButton1.setBackground(new java.awt.Color(255, 213, 0));
        jButton1.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        secondColumnPanel.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 213, 0));
        jButton2.setFont(new java.awt.Font("Rockwell Condensed", 1, 18));
        jButton2.setText("Signup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        secondColumnPanel.add(jButton2);

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


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (txt_username.getText().isEmpty() || txt_password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please Fill Empty Fields");
        } else {
            try {
                String query = "select * from users where username=? and password=? and division=?";
                conn = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");
                pst = conn.prepareStatement(query);
                pst.setString(1, txt_username.getText());
                pst.setString(2, String.valueOf(txt_password.getPassword()));
                pst.setString(3, String.valueOf(jComboBox1.getSelectedItem()));
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Success");
                    if (jComboBox1.getSelectedIndex() == 1) {
                        MainMenu j = new MainMenu();
                        j.setVisible(true);
                        this.setVisible(false);
                    } else if (jComboBox1.getSelectedIndex() == 2) {
                        register h = new register();
                        h.setVisible(true);
                        setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username and password do not match");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox1.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(this, "Admin already registered");
        } else {
            Signup g = new Signup();
            g.setVisible(true);
            this.dispose();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private JMenu txt_date;
    private JPasswordField txt_password;
    private JMenu txt_time;
    private JTextField txt_username;
}
