package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import dao.UserDao;
import model.User;

import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScr {

	private JFrame frame;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScr window = new LoginScr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(337, 25, 86, 20);
		frame.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(337, 50, 86, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnConfirmLogin = new JButton("Zaloguj");
		btnConfirmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginUser();
			}
			
		});
		btnConfirmLogin.setBounds(334, 74, 89, 23);
		frame.getContentPane().add(btnConfirmLogin);
	}
	public void addUser(){
		UserDao userDao = new UserDao();
		User user = new User();
		user.setLogin(textFieldLogin.getText());
		user.setPassword(textFieldPassword.getText());
		userDao.addUser(user);
		
	}
	public void loginUser(){
		UserDao userDao = new UserDao();
		User user = new User();
		user.setLogin(textFieldLogin.getText());
		user.setPassword(textFieldPassword.getText());
		User uRs = userDao.loginUser(user);
		if(uRs==null){
			System.out.println("Nie ma takiego uzytkwonika");
		}
		else {
			System.out.println(uRs.toString());
		}
	}
}
