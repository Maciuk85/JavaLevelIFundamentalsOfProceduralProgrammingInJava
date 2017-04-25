package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.RacingGameConstants;
import controller.LoginController;
import model.User;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;


	public MainFrame() {
		super(RacingGameConstants.GAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(RacingGameConstants.FRAME_X, RacingGameConstants.FRAME_Y, RacingGameConstants.FRAME_WIDTH, RacingGameConstants.FRAME_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

	public void init(){

		LoginController loginController = new LoginController(new User(), new LoginPanel());

	}
	public void replacePanel(JPanel newPanel){
		getContentPane().removeAll();
		getContentPane().add(newPanel);
		revalidate();
		repaint();
	}
}
