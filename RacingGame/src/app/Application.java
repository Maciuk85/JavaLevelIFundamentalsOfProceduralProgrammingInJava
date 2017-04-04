package app;

import java.awt.EventQueue;

import gui.MainFrame;

public class Application {

	public static MainFrame mainFrame;
	
	public static void main(String[] args) {
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
