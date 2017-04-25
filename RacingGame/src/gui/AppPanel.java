package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.RacingGameConstants;

public class AppPanel extends JPanel {

	protected JButton btnBack;
	
	public AppPanel() {
		super();
		this.setBounds(0, 0, RacingGameConstants.PANEL_WIDTH, RacingGameConstants.PANEL_HEIGHT);
		this.setLayout(null);
		
		btnBack=new JButton("Back");
		btnBack.setBounds(378,685,204,50);
		add(btnBack);
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

}
