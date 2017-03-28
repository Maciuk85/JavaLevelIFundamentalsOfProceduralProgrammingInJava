package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import dao.UserDao;
import model.User;

import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class LoginScr {

	private JFrame frame;
	private JTextField textFieldLoginUser;
	private JPasswordField passwordFieldLoginPassword;
	private JTextField textFieldAddUser;
	private JPasswordField passwordFieldAddPassword;

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
		
		textFieldLoginUser = new JTextField();
		textFieldLoginUser.setBounds(111, 28, 86, 20);
		frame.getContentPane().add(textFieldLoginUser);
		textFieldLoginUser.setColumns(10);
		
		JButton btnConfirmLogin = new JButton("Zaloguj");
		btnConfirmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginUser();
//				JOptionPane.showMessageDialog(frame, "ttrasa"); //TODO w jakims warunku to dac
			}
			
		});
		btnConfirmLogin.setBounds(111, 77, 89, 23);
		frame.getContentPane().add(btnConfirmLogin);
		
		passwordFieldLoginPassword = new JPasswordField();
		passwordFieldLoginPassword.setBounds(111, 53, 86, 20);
		frame.getContentPane().add(passwordFieldLoginPassword);
		
		JButton btnAddUser = new JButton("Dodaj u\u017Cytownika");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUser();
			}
		});
		btnAddUser.setBounds(585, 77, 122, 23);
		frame.getContentPane().add(btnAddUser);
		
		textFieldAddUser = new JTextField();
		textFieldAddUser.setBounds(585, 28, 122, 20);
		frame.getContentPane().add(textFieldAddUser);
		textFieldAddUser.setColumns(10);
		
		passwordFieldAddPassword = new JPasswordField();
		passwordFieldAddPassword.setBounds(585, 53, 122, 20);
		frame.getContentPane().add(passwordFieldAddPassword);
	}
	public void addUser(){
		UserDao userDao = new UserDao();
		User user = new User();
		user.setLogin(textFieldAddUser.getText());
		user.setPassword(passwordFieldAddPassword.getText());
		userDao.addUser(user);
		textFieldAddUser.setText("");
	}
	public void loginUser(){
		UserDao userDao = new UserDao();
		User user = new User();
		user.setLogin(textFieldLoginUser.getText());
		user.setPassword(passwordFieldLoginPassword.getText());
		User uRs = userDao.loginUser(user);
		if(uRs==null){
			System.out.println("Nie ma takiego uzytkwonika");
		}
		else {
			System.out.println(uRs.toString());
		}
	}
}
