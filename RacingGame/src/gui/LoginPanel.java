package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends AppPanel {
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldPassword;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		super();
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(61, 17, 431, 39);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(61, 67, 431, 39);
		add(passwordFieldPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(61, 143, 431, 202);
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
