package gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.CarDao;
import model.Car;

public class GarageScr {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JComboBox comboBoxCarName;
	private JProgressBar progressBarEngine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GarageScr window = new GarageScr();
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
	public GarageScr() {
		initialize();
		refreshCarInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 865, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		progressBarEngine = new JProgressBar();
		progressBarEngine.setBounds(120, 165, 184, 27);
		progressBarEngine.setMinimum(0);
		progressBarEngine.setMaximum(10);
		
		frame.getContentPane().add(progressBarEngine);
		
		JProgressBar progressBarTires = new JProgressBar();
		progressBarTires.setBounds(120, 203, 184, 27);
		frame.getContentPane().add(progressBarTires);
		
		JProgressBar progressBarAcceleration = new JProgressBar();
		progressBarAcceleration.setBounds(120, 241, 184, 27);
		frame.getContentPane().add(progressBarAcceleration);
		
		JProgressBar progressBarBreaks = new JProgressBar();
		progressBarBreaks.setBounds(120, 279, 184, 27);
		frame.getContentPane().add(progressBarBreaks);
		
		comboBoxCarName = new JComboBox();
		comboBoxCarName.setBounds(52, 105, 252, 27);
		frame.getContentPane().add(comboBoxCarName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setEditable(false);
		textFieldUserName.setEnabled(false);
		textFieldUserName.setBounds(52, 24, 252, 57);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
	}
	
	public void refreshCarInfo(){
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getAllUserCars(1);
		comboBoxCarName.removeAllItems();
		for(int i=0;i<cars.size();i++){
			Car car = cars.get(i);
			comboBoxCarName.addItem(car.getName());
			progressBarEngine.setValue(car.getEngine());
		}
	}
	
}
