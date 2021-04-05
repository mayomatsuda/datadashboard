import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
    class for logging in to the system
*/

//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.WindowEvent;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Set;
//
//
//public class login extends javax.swing.JFrame implements VerificationServer {
//
//        jPanel1 = new javax.swing.JPanel();
//        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
//        jPassword = new javax.swing.JPasswordField();
//        jUsername = new javax.swing.JTextField();
//        jButtonLogin = new javax.swing.JButton();
//        jButton2Exit = new javax.swing.JButton();
//        jLabel1 = new javax.swing.JLabel();
//
//        jLabel2.setText("Username");
//
//        jLabel3.setText("Password");
//
//        jPassword.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jPasswordActionPerformed(evt);
//            }
//        });
//
//        jButtonLogin.setText("Login");
//        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButtonLoginActionPerformed(evt);
//            }
//        });
//
//        jButton2Exit.setText("Exit");
//        jButton2Exit.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ExitActionPerformed(evt);
//            }
//        });
//
//
//}

public class login {
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		/* User label for the user label */
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10 , 20 , 80 , 25);
		panel.add(userLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20 ,165 , 25);
		panel.add(userText);
		
		frame.setVisible(true);
	}
}