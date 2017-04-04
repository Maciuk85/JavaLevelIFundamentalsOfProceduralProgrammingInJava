package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldPassword;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		super();
		this.setBounds(0, 0, 1434, 1262);
		setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(262, 17, 431, 39);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(272, 103, 414, 39);
		add(passwordFieldPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(262, 193, 570, 202);
		add(btnLogin);

	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	public JPasswordField getPasswordFieldPassword() {
		return passwordFieldPassword;
	}

	public void setPasswordFieldPassword(JPasswordField passwordFieldPassword) {
		this.passwordFieldPassword = passwordFieldPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	
	
	
}
