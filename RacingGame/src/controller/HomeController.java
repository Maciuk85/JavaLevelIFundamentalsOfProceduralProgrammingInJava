package controller;

import app.Application;
import gui.HomePanel;
import gui.LoginPanel;
import model.User;

public class HomeController implements Controller{
	
	private HomePanel homepanel;
	private User user;

	public HomeController(User user, HomePanel homepanel) {
		super();
		this.homepanel = homepanel;
		this.user = user;
		initView();
		initController();
	}

	@Override
	public void initView() {
		Application.mainFrame.replacePanel(homepanel);
		
	}

	@Override
	public void initController() {
		homepanel.getBtnBack().addActionListener(e -> back());
		
	}
private void back(){
	new LoginController(new User(),new LoginPanel());
	
}
}
