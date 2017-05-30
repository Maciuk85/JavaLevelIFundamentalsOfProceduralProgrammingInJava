import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MainScr {

	private JLabel lblDo2;
	private JLabel lblOd2;
	private JScrollPane scrollPaneMonday;
	private JScrollPane scrollPaneTuesday;
	private JScrollPane scrollPaneWednesday;
	private JScrollPane scrollPaneThursday;
	private JScrollPane scrollPaneFriday;
	private JFrame frame;
	private JTable tableMonday;
	private JTable tableTuesday;
	private JTable tableWednesday;
	private JTable tableThursday;
	private JTable tableFriday;
	private final String[] tableColumnNames = { "Nr", "Nazwa", "Od", "Do" };
	private JLabel lblNazwaPrzedmiotu;
	private JTextField textFieldNazwaPrzedmiotu;
	private JLabel lblLessonNumber;
	private JLabel label;
	private JTable table;
	private JComboBox comboBoxLessonNumber;
	private JComboBox comboBoxDay;
	private final String[] tableStartHours = { "8:00", "8:50", "9:45", "10:45", "11:40", "12:25", "13:30", "14:20" };
	private final String[] tableEndHours = { "8:45", "9:35", "10:30", "11:30", "12:25", "13:20", "14:15", "15:05" };

	private HashMap<String, JTable> daysMap;

	private ArrayList<Color> colors = new ArrayList<Color>();
	private int colorNumber = 0;
	
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
		setupStartData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1323, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		
		JLabel lblMonday = new JLabel("Poniedzia\u0142ek");
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMonday.setBounds(31, 25, 129, 33);
		frame.getContentPane().add(lblMonday);

		lblNazwaPrzedmiotu = new JLabel("Nazwa przedmiotu:");
		lblNazwaPrzedmiotu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNazwaPrzedmiotu.setBounds(987, 27, 151, 32);
		frame.getContentPane().add(lblNazwaPrzedmiotu);

		textFieldNazwaPrzedmiotu = new JTextField();
		textFieldNazwaPrzedmiotu.setBounds(1148, 30, 140, 32);
		frame.getContentPane().add(textFieldNazwaPrzedmiotu);
		textFieldNazwaPrzedmiotu.setColumns(10);

		comboBoxDay = new JComboBox();
		comboBoxDay.setBounds(1191, 73, 76, 30);
		frame.getContentPane().add(comboBoxDay);

		JLabel lblDay = new JLabel("Dzie\u0144 tygodnia:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay.setBounds(1058, 70, 106, 33);
		frame.getContentPane().add(lblDay);

		lblLessonNumber = new JLabel("Numer lekcji:");
		lblLessonNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLessonNumber.setBounds(1058, 124, 106, 33);
		frame.getContentPane().add(lblLessonNumber);

		label = new JLabel("");
		label.setBounds(962, 143, 46, 14);
		frame.getContentPane().add(label);

		comboBoxLessonNumber = new JComboBox();
		comboBoxLessonNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshLessonHours();
			}
		});
		comboBoxLessonNumber.setBounds(1191, 127, 76, 30);
		frame.getContentPane().add(comboBoxLessonNumber);

		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(1054, 169, 46, 14);
		frame.getContentPane().add(lblOd);

		lblOd2 = new JLabel("New label");
		lblOd2.setBounds(1091, 169, 46, 14);
		frame.getContentPane().add(lblOd2);

		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(1191, 169, 46, 14);
		frame.getContentPane().add(lblDo);

		lblDo2 = new JLabel("New label");
		lblDo2.setBounds(1230, 169, 46, 14);
		frame.getContentPane().add(lblDo2);

		scrollPaneMonday = new JScrollPane();
		scrollPaneTuesday = new JScrollPane();
		scrollPaneWednesday = new JScrollPane();
		scrollPaneThursday = new JScrollPane();
		scrollPaneFriday = new JScrollPane();

		tableMonday = new JTable();
		tableTuesday = new JTable();
		tableWednesday = new JTable();
		tableThursday = new JTable();
		tableFriday = new JTable();

		initializeTable(10, 63, scrollPaneMonday, tableMonday);
		initializeTable(215, 63, scrollPaneTuesday, tableTuesday);
		initializeTable(420, 63, scrollPaneWednesday, tableWednesday);
		initializeTable(630, 63, scrollPaneThursday, tableThursday);
		initializeTable(836, 63, scrollPaneFriday, tableFriday);

		JLabel lbl_Tuesday = new JLabel("Wtorek");
		lbl_Tuesday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_Tuesday.setBounds(261, 25, 83, 33);
		frame.getContentPane().add(lbl_Tuesday);

		JLabel lbl_Wednesday = new JLabel("\u015Aroda");
		lbl_Wednesday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_Wednesday.setBounds(463, 25, 67, 33);
		frame.getContentPane().add(lbl_Wednesday);

		JLabel lbl_Thursday = new JLabel("Czwartek");
		lbl_Thursday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_Thursday.setBounds(673, 25, 106, 33);
		frame.getContentPane().add(lbl_Thursday);

		JLabel lbl_Friday = new JLabel("Pi\u0105tek");
		lbl_Friday.setToolTipText("");
		lbl_Friday.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_Friday.setBounds(879, 25, 76, 33);
		frame.getContentPane().add(lbl_Friday);

		JButton buttonAdd = new JButton("Dodaj");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lessonNumber = (int) comboBoxLessonNumber.getSelectedItem();
				String day = (String) comboBoxDay.getSelectedItem();
				addLesson(daysMap.get(day), lessonNumber, textFieldNazwaPrzedmiotu.getText(),
						tableStartHours[lessonNumber - 1], tableEndHours[lessonNumber - 1]);
			}
		});
		buttonAdd.setBounds(1091, 194, 146, 41);
		frame.getContentPane().add(buttonAdd);

		JButton btnClear = new JButton("Wyszy\u015B\u0107");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearPlan();
			}
		});
		btnClear.setBounds(1091, 246, 146, 41);
		frame.getContentPane().add(btnClear);
		
		JButton btnChangeColor = new JButton("Zmie\u0144 kolor");
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(changeColor());
			}
		});
		btnChangeColor.setBounds(1091, 300, 146, 41);
		frame.getContentPane().add(btnChangeColor);

	}

	public void initializeTable(int x, int y, JScrollPane scrollPane, JTable table) {

		scrollPane.setBounds(x, y, 172, 249);
		frame.getContentPane().add(scrollPane);

		table.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		table.setFont(new Font("Calibri", Font.PLAIN, 15));
		table.setRowHeight(15);
		table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
	}

	public void setUpBackgroundColors(){
		colors.add(new Color(255, 0, 0));
		colors.add(new Color(0, 255, 0));
		colors.add(new Color(0, 0, 255));
		frame.getContentPane().setBackground(colors.get(0));
	}
	
	public void setupStartData() {
		setUpBackgroundColors();
		setUpDays();
		setUpLessonNumber();
		setupTables();
	}

	public void setUpDays() {
		daysMap = new HashMap<String, JTable>();

		comboBoxDay.addItem("Poniedzia³ek");
		comboBoxDay.addItem("Wtorek");
		comboBoxDay.addItem("Œroda");
		comboBoxDay.addItem("Czwartek");
		comboBoxDay.addItem("Pi¹tek");

		daysMap.put("Poniedzia³ek", tableMonday);
		daysMap.put("Wtorek", tableTuesday);
		daysMap.put("Œroda", tableWednesday);
		daysMap.put("Czwartek", tableThursday);
		daysMap.put("Pi¹tek", tableFriday);

	}

	public void setUpLessonNumber() {
		for (int i = 1; i <= 8; i++) {
			comboBoxLessonNumber.addItem(i);
		}
	}

	public void setupTables() {

		tableMonday.setModel(getModel());
		tableTuesday.setModel(getModel());
		tableWednesday.setModel(getModel());
		tableThursday.setModel(getModel());
		tableFriday.setModel(getModel());

	}

	public DefaultTableModel getModel() {
		DefaultTableModel model = new DefaultTableModel(tableColumnNames, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		for (int i = 1; i <= 8; i++) {
			model.addRow(new Object[] { "", "", "", "" });
		}
		return model;
	}

	public void refreshLessonHours() {
		Integer lessonNumber = (Integer) comboBoxLessonNumber.getSelectedItem();
		lblOd2.setText(tableStartHours[lessonNumber - 1]);
		lblDo2.setText(tableEndHours[lessonNumber - 1]);
	}

	public void addLesson(JTable day, int lesssonNumber, String subject, String startHours, String endHours) {
		day.getModel().setValueAt(lesssonNumber, lesssonNumber - 1, 0);
		day.getModel().setValueAt(subject, lesssonNumber - 1, 1);
		day.getModel().setValueAt(startHours, lesssonNumber - 1, 2);
		day.getModel().setValueAt(endHours, lesssonNumber - 1, 3);

	}
	
	public void clearPlan(){
		tableMonday.setModel(getModel());
		tableTuesday.setModel(getModel());
		tableWednesday.setModel(getModel());
		tableThursday.setModel(getModel());
		tableFriday.setModel(getModel());
	}
	
	public Color changeColor(){
		colorNumber++;
		if(colorNumber >= colors.size()){
			colorNumber = 0;
		}
		Color color = colors.get(colorNumber);
		return color;
		
	}
	
}