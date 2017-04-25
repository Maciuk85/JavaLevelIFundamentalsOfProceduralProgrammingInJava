package app;

import java.awt.EventQueue;

import database.DBConnection;
import gui.MainFrame;

public class Application {

	public static MainFrame mainFrame;
	
	public static void main(String[] args) {
		DBConnection.getInstance().init();
		DBConnection.getInstance().registerShutdownHook();
		startUpApplication();

	}

	private static void startUpApplication(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new MainFrame();
					mainFrame.setVisible(true);
					mainFrame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
