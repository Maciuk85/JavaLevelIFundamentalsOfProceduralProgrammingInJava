package controller;

import app.Application;
import gui.HomePanel;
import gui.LoginPanel;
import model.User;

public class LoginController implements Controller{

	private User user;
	private LoginPanel loginPanel;
	
	public LoginController(User user, LoginPanel loginPanel) {
		super();
		this.user = user;
		this.loginPanel = loginPanel;
		initView();
		initController();
	}

	@Override
	public void initView() {
		Application.mainFrame.replacePanel(loginPanel);
		loginPanel.getTextFieldLogin().setText("Maciek");
		
	}

	@Override
	public void initController() {
		loginPanel.getBtnLogin().addActionListener(e -> loginUser());
		
	}

	private void loginUser(){
		new HomeController(new User(), new HomePanel());
	}
	
}
