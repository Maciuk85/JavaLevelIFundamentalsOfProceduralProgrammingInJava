package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

public class HomePanel extends JPanel {

	private JButton btnBack;
	public HomePanel() {
		super();
		this.setBounds(0, 0, 1434, 1262);
		setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(378, 86, 691, 273);
		add(btnBack);

	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

}
