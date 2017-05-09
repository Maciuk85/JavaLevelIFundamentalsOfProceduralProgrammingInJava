import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainScr {

	private JFrame frame;
	private JTable tableMonday;
	private final String[] tableColumnNames = { "Nr", "Nazwa", "Od", "Do" };
	private JLabel lblPrzed;
	private JTextField textField;
	private JLabel lblGodzinaLekcyjna;
	private JLabel label;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScr window = new MainScr();
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
	public MainScr() {
		initialize();
		setupTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1314, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMonday = new JLabel("Poniedzia\u0142ek");
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMonday.setBounds(31, 25, 129, 33);
		frame.getContentPane().add(lblMonday);
		
		lblPrzed = new JLabel("Nazwa przedmiotu:");
		lblPrzed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrzed.setBounds(952, 49, 178, 39);
		frame.getContentPane().add(lblPrzed);
		
		textField = new JTextField();
		textField.setBounds(1116, 49, 150, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblGodzinaLekcyjna = new JLabel("Numer lekcji");
		lblGodzinaLekcyjna.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGodzinaLekcyjna.setBounds(956, 105, 150, 33);
		frame.getContentPane().add(lblGodzinaLekcyjna);
		
		label = new JLabel("");
		label.setBounds(962, 143, 46, 14);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1116, 99, 46, 39);
		frame.getContentPane().add(comboBox);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(1073, 195, 46, 14);
		frame.getContentPane().add(lblOd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(1102, 195, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(1191, 195, 46, 14);
		frame.getContentPane().add(lblDo);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(1220, 195, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 172, 249);
		frame.getContentPane().add(scrollPane);		
		tableMonday = new JTable();
		tableMonday.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		tableMonday.setFont(new Font("Calibri", Font.PLAIN, 15));
		tableMonday.setRowHeight(15);
		tableMonday.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		tableMonday.setRowSelectionAllowed(true);
		scrollPane.setViewportView(tableMonday);
						
					
	}

	public void setupTable() {

		DefaultTableModel model = new DefaultTableModel(tableColumnNames, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		model.addRow(new Object[] { "", "", "", "5" });
		tableMonday.setModel(model);

	}
}
