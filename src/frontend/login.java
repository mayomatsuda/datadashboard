package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import backend.VerificationServer;

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

/* this class is made to work with the pop up login and to call the verification server */
public class login implements ActionListener{
	
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		frame.setVisible(true);
		
		/* User name label for the user label */
		userLabel = new JLabel("User-name");
		userLabel.setBounds(10 , 20 , 80 , 25);
		panel.add(userLabel);
		
		/* username adding */
		userText = new JTextField(20);
		userText.setBounds(100, 20 ,165 , 25);
		panel.add(userText);
		
		/* Password label for the password */
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10 , 60 , 80 , 25);
		panel.add(passwordLabel);
		
		/*  To enter the password */
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 60 ,165 , 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10,90,80,25);
		button.addActionListener(new login());
		panel.add(button);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = userText.getText();
		String password = passwordText.getText();
		VerificationServer verify = new VerificationServer();
		verify.getResult(user, password);
	}
}