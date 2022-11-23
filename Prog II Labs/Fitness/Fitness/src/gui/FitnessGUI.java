package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import bp.Exercise;
import bp.ExerciseAerobic;
import bp.ExerciseStrength;
import bp.Gender;
import bp.Person;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FitnessGUI {

	private JFrame frame;
	private JTextField exerciseNameField;
	private JTextField exerciseDurationField;
	private JTextField maxRateField;
	private JTextField averageRateField;
	private JTextField totalDistanceField;
	private JTextField userIDField;
	private JTextField userIDField2;
	private JTextField firstNameField;
	private JTextField heightField;
	private JTextField weightField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField lastNameField;
	private JTextField yearField;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField userIDField3;
	private JTextField textField_5;
	private ExerciseStrength exeS = new ExerciseStrength();
	private ExerciseAerobic exeA = new ExerciseAerobic();
	private Person per = new Person();
	private JTextField yearE;
	private JTextField dayE;
	private JTextField monthE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessGUI window = new FitnessGUI();
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
	public FitnessGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel<Exercise> model = new DefaultListModel<>();

		DefaultListModel<String> model2 = new DefaultListModel<>();

		ArrayList<Exercise> exerciseArray = new ArrayList<Exercise>();

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 583, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 581, 609);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		exerciseNameField = new JTextField();
		exerciseNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				exerciseNameField.setText("");
				exerciseNameField.setForeground(Color.black);
			}
		});
		exerciseNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseNameField.setBounds(23, 177, 230, 33);
		panel_1.add(exerciseNameField);
		exerciseNameField.setColumns(10);

		JList<Exercise> list = new JList<>(model);
		list.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		list.setBounds(338, 150, 217, 361);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new CompoundBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), null));
		panel_1.add(list);

		JLabel exerciseNameText = new JLabel("<html><h3>Exercise Name:</h3></html>");
		exerciseNameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseNameText.setBounds(23, 150, 230, 27);
		panel_1.add(exerciseNameText);

		JLabel exerciseDateText = new JLabel("<html><h3>Exercise Date:</h3></html>");
		exerciseDateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDateText.setBounds(23, 211, 230, 27);
		panel_1.add(exerciseDateText);

		exerciseDurationField = new JTextField();
		exerciseDurationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				exerciseDurationField.setText(exerciseDurationField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		exerciseDurationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				exerciseDurationField.setText("");
			}
		});
		exerciseDurationField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDurationField.setColumns(10);
		exerciseDurationField.setBounds(23, 299, 230, 33);
		panel_1.add(exerciseDurationField);

		JLabel exerciseDurationText = new JLabel("<html><h3>Exercise Duration</h3></html>");
		exerciseDurationText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDurationText.setBounds(23, 272, 230, 27);
		panel_1.add(exerciseDurationText);

		maxRateField = new JTextField();
		maxRateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				maxRateField.setText(maxRateField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		maxRateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				maxRateField.setText("");
				maxRateField.setForeground(Color.black);
				maxRateField.setText(maxRateField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		maxRateField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maxRateField.setColumns(10);
		maxRateField.setBounds(23, 358, 230, 33);
		panel_1.add(maxRateField);

		JLabel maxRateText = new JLabel("<html><h3>Max Heart Rate:</h3></html>");
		maxRateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maxRateText.setBounds(23, 331, 230, 27);
		panel_1.add(maxRateText);

		averageRateField = new JTextField();
		averageRateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				averageRateField.setText(averageRateField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		averageRateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				averageRateField.setText("");
			}
		});
		averageRateField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		averageRateField.setColumns(10);
		averageRateField.setBounds(23, 418, 230, 33);
		panel_1.add(averageRateField);

		JLabel averageRateText = new JLabel("<html><h3>Average Heart Rate:</h3></html>");
		averageRateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		averageRateText.setBounds(23, 391, 230, 27);
		panel_1.add(averageRateText);

		totalDistanceField = new JTextField();
		totalDistanceField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				totalDistanceField.setText(totalDistanceField.getText().replaceAll("[^\\d.]", ""));
			}
		});
		totalDistanceField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				totalDistanceField.setText("");
			}
		});
		totalDistanceField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalDistanceField.setColumns(10);
		totalDistanceField.setBounds(23, 478, 230, 33);
		panel_1.add(totalDistanceField);

		JLabel totalDistanceText = new JLabel("<html><h3>Total Distance:</h3></html>");
		totalDistanceText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalDistanceText.setBounds(23, 451, 230, 27);
		panel_1.add(totalDistanceText);
		JRadioButton rAerobic = new JRadioButton("<html><h3>Aerobic</h3></html>");
		rAerobic.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				maxRateText.setText("<html><h3>Max Heart Rate:</h3></html>");
				averageRateText.setText("<html><h3>Average Heart Rate:</h3></html>");
				totalDistanceText.setText("<html><h3>Total Distance:</h3></html>");
			}
		});

		buttonGroup.add(rAerobic);
		rAerobic.setSelected(true);
		rAerobic.setBounds(23, 539, 94, 25);
		panel_1.add(rAerobic);

		JRadioButton rStrength = new JRadioButton("<html><h3>Strength</h3></html>");
		rStrength.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				maxRateText.setText("<html><h3>Weight Lifted:</h3></html>");
				averageRateText.setText("<html><h3>Total Sets:</h3></html>");
				totalDistanceText.setText("<html><h3>Total Reps:</h3></html>");
			}
		});
		buttonGroup.add(rStrength);
		rStrength.setBounds(124, 539, 129, 25);
		panel_1.add(rStrength);

		JButton btnRemove = new JButton("<html>R<br>E<br>M<br>O<br>V<br>  E<br></html>");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnRemove.setBounds(265, 331, 61, 178);
		panel_1.add(btnRemove);

		JLabel titleText = new JLabel("<html><h1>Fitness Tracker</h1></html>");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleText.setBounds(23, 0, 532, 33);
		panel_1.add(titleText);

		JLabel userIDText = new JLabel("<html><h2>USER ID:</h2></html>");
		userIDText.setFont(new Font("Tahoma", Font.BOLD, 18));
		userIDText.setBounds(23, 84, 85, 44);
		panel_1.add(userIDText);

		userIDField = new JTextField();
		userIDField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				userIDField.setText(userIDField.getText().replaceAll("[^\\d.]", ""));
			}
		});
		userIDField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userIDField.setText("");
			}
		});
		userIDField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDField.setColumns(10);
		userIDField.setBounds(110, 89, 142, 33);
		panel_1.add(userIDField);

		JButton btnAdd = new JButton("<html>A<br>D<br>D<br></html>");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rAerobic.isSelected()) {
					exeA.setStudentID(Integer.parseInt(userIDField.getText()));
					exeA.setMaxHeartRate(Integer.parseInt(maxRateField.getText()));
					exeA.setAverageHeartRate(Integer.parseInt(averageRateField.getText()));
					exeA.setDistance(Integer.parseInt(totalDistanceField.getText()));
					exeA.setExerciseName(exerciseNameField.getText());
					exeA.setExerciseDate(LocalDate.of(Integer.parseInt(yearE.getText()),
							Integer.parseInt(monthE.getText()), Integer.parseInt(dayE.getText())));
					exeA.setExerciseDuration(Duration.ofMinutes(Integer.parseInt(exerciseDurationField.getText())));
					exeA.save(exeA.getStudentID(), exeA.getExerciseDate(), exeA.getExerciseName(),
							exeA.getExerciseDuration());

				}

				if (rStrength.isSelected()) {
					exeS.setStudentID(Integer.parseInt(userIDField.getText()));
					exeS.setWeightLifted(Double.parseDouble(maxRateField.getText()));
					exeS.setSets(Integer.parseInt(averageRateField.getText()));
					exeS.setReps(Integer.parseInt(totalDistanceField.getText()));
					exeS.setExerciseName(exerciseNameField.getText());
					exeS.setExerciseDate(LocalDate.of(Integer.parseInt(yearE.getText()),
							Integer.parseInt(monthE.getText()), Integer.parseInt(dayE.getText())));
					exeS.setExerciseDuration(Duration.ofMinutes(Integer.parseInt(exerciseDurationField.getText())));
					exeS.save(exeS.getStudentID(), exeS.getExerciseDate(), exeS.getExerciseName(),
							exeS.getExerciseDuration());

				}

			}
		});
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnAdd.setBounds(265, 150, 61, 178);
		panel_1.add(btnAdd);

		yearE = new JTextField();
		yearE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				yearE.setText(yearE.getText().replaceAll("[^\\d.]", ""));

			}
		});
		yearE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				yearE.setText("");
			}
		});
		yearE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yearE.setColumns(10);
		yearE.setBounds(172, 238, 81, 33);
		panel_1.add(yearE);

		dayE = new JTextField();
		dayE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				dayE.setText(dayE.getText().replaceAll("[^\\d.]", ""));

			}
		});
		dayE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dayE.setText("");
			}
		});
		dayE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dayE.setColumns(10);
		dayE.setBounds(96, 238, 61, 33);
		panel_1.add(dayE);

		monthE = new JTextField();
		monthE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				monthE.setText(monthE.getText().replaceAll("[^\\d.]", ""));

			}
		});
		monthE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				monthE.setText("");
			}
		});
		monthE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monthE.setColumns(10);
		monthE.setBounds(23, 238, 61, 33);
		panel_1.add(monthE);

		JLabel label_5 = new JLabel("/");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(84, 238, 12, 33);
		panel_1.add(label_5);

		JLabel label_8 = new JLabel("/");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(159, 238, 12, 33);
		panel_1.add(label_8);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 135, 532, 2);
		panel_1.add(separator);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(23, 69, 532, 2);
		panel_1.add(separator_5);

		JLabel lblcopywritedProgramm = new JLabel(
				"<html><small><i>Property of AwesomeProgramming\u2122, Copyrighted 2018 \u00A9 </i></small></html>");
		lblcopywritedProgramm.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblcopywritedProgramm.setBounds(286, 549, 295, 33);
		panel_1.add(lblcopywritedProgramm);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 581, 587);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);

		JLabel userSettingsTitle = new JLabel("<html><h1>User Settings<h1></html>");
		userSettingsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		userSettingsTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userSettingsTitle.setBounds(23, 13, 532, 44);
		panel_2.add(userSettingsTitle);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 51, 532, 7);
		panel_2.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 88, 532, 7);
		panel_2.add(separator_2);

		JLabel lblnewUserupdateUser = new JLabel("<html><h2>New User/Update User<h2></html>");
		lblnewUserupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblnewUserupdateUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnewUserupdateUser.setBounds(23, 51, 532, 44);
		panel_2.add(lblnewUserupdateUser);

		userIDField2 = new JTextField();
		userIDField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				userIDField2.setText(userIDField2.getText().replaceAll("[^\\d.]", ""));
			}
		});
		userIDField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		userIDField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userIDField2.setText("");
			}
		});
		userIDField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDField2.setColumns(10);
		userIDField2.setBounds(23, 122, 248, 33);
		panel_2.add(userIDField2);

		firstNameField = new JTextField();
		firstNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				firstNameField.setText("");
			}
		});
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameField.setColumns(10);
		firstNameField.setBounds(23, 183, 114, 33);
		panel_2.add(firstNameField);

		JLabel nameText = new JLabel("<html><h3>Name:</h3></html>");
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameText.setBounds(23, 156, 248, 27);
		panel_2.add(nameText);

		JLabel userIDText2 = new JLabel("<html><h3>User ID:</h3></html>");
		userIDText2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDText2.setBounds(23, 88, 248, 27);
		panel_2.add(userIDText2);

		JLabel lblDateOfBirth = new JLabel("<html><h3>Date of Birth:</h3></html>\r\n");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(23, 217, 248, 27);
		panel_2.add(lblDateOfBirth);

		JLabel lblheight = new JLabel("<html><h3>Height:</h3></html>");
		lblheight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblheight.setBounds(307, 88, 248, 27);
		panel_2.add(lblheight);

		JLabel lblgender = new JLabel("<html><h3>Gender:</h3></html>");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblgender.setBounds(307, 217, 248, 27);
		panel_2.add(lblgender);

		heightField = new JTextField();
		heightField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				heightField.setText(heightField.getText().replaceAll("[^\\d.]", ""));
			}
		});
		heightField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				heightField.setText("");
			}
		});
		heightField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heightField.setColumns(10);
		heightField.setBounds(307, 122, 248, 33);
		panel_2.add(heightField);

		weightField = new JTextField();
		weightField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				weightField.setText(weightField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		weightField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				weightField.setText("");

			}
		});
		weightField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weightField.setColumns(10);
		weightField.setBounds(307, 183, 248, 33);
		panel_2.add(weightField);

		JLabel lblweight = new JLabel("<html><h3>Weight:</h3></html>");
		lblweight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblweight.setBounds(307, 156, 248, 27);
		panel_2.add(lblweight);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(23, 351, 532, 7);
		panel_2.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(23, 388, 532, 7);
		panel_2.add(separator_4);

		JLabel lbluserOptions = new JLabel("<html><h2>User Options<h2></html>");
		lbluserOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lbluserOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbluserOptions.setBounds(23, 351, 532, 44);
		panel_2.add(lbluserOptions);

		JComboBox genderBox = new JComboBox();
		genderBox.setBorder(new CompoundBorder());
		genderBox.setModel(new DefaultComboBoxModel(new String[] { "UNSPECIFIED", "MALE", "FEMALE" }));
		genderBox.setBackground(new Color(255, 255, 255));
		genderBox.setBounds(307, 246, 248, 31);
		panel_2.add(genderBox);

		lastNameField = new JTextField();
		lastNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastNameField.setText("");

			}
		});
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameField.setColumns(10);
		lastNameField.setBounds(157, 183, 114, 33);
		panel_2.add(lastNameField);

		yearField = new JTextField();
		yearField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				yearField.setText(yearField.getText().replaceAll("[^\\d.]", ""));
			}
		});
		yearField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				yearField.setText("");

			}
		});
		yearField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yearField.setColumns(10);
		yearField.setBounds(172, 244, 99, 33);
		panel_2.add(yearField);

		dayField = new JTextField();
		dayField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				dayField.setText(dayField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		dayField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dayField.setText("");
			}
		});
		dayField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dayField.setColumns(10);
		dayField.setBounds(96, 244, 61, 33);
		panel_2.add(dayField);

		monthField = new JTextField();
		monthField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				monthField.setText(monthField.getText().replaceAll("[^\\d.]", ""));

			}
		});
		monthField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				monthField.setText("");

			}
		});
		monthField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monthField.setColumns(10);
		monthField.setBounds(23, 244, 61, 33);
		panel_2.add(monthField);

		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(84, 244, 12, 33);
		panel_2.add(label);

		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(159, 244, 12, 33);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("<html><h3>User ID:</h3></html>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(23, 399, 248, 27);
		panel_2.add(label_2);

		userIDField3 = new JTextField();
		userIDField3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				userIDField3.setText(userIDField3.getText().replaceAll("[^\\d.]", ""));

			}
		});
		userIDField3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userIDField3.setText("");

			}
		});
		userIDField3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDField3.setColumns(10);
		userIDField3.setBounds(23, 428, 248, 33);
		panel_2.add(userIDField3);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(23, 428, 248, 33);
		panel_2.add(textField_5);

		JButton btnupdateUser = new JButton("<html><h3>Update User</h3></html>");
		btnupdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String genderString = (String) genderBox.getSelectedItem();
				per.setStudentID(Integer.parseInt(userIDField2.getText()));
				per.setWeight(Integer.parseInt(weightField.getText()));
				per.setHeight(Integer.parseInt(heightField.getText()));
				per.setGender(Gender.valueOf(genderString));
				per.setFirstName(firstNameField.getText());
				per.setLastName(lastNameField.getText());
				per.setBirthDate(LocalDate.of(Integer.parseInt(yearField.getText()),
						Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText())));

				per.save();
			}
		});
		btnupdateUser.setBounds(307, 294, 248, 44);
		panel_2.add(btnupdateUser);

		JButton btnDeleteUser = new JButton("<html><h3>Delete Selected</h3></html>");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				per.setStudentID(Integer.parseInt(userIDField3.getText()));
				per.delete(Integer.parseInt(userIDField3.getText()));

				String genderString = (String) genderBox.getSelectedItem();
				per.setStudentID(0);
				per.setWeight(0);
				per.setHeight(0);
				per.setGender(null);
				per.setFirstName(null);
				per.setLastName(null);
				per.setBirthDate(null);

				userIDField.setText("");
				monthField.setText("");
				dayField.setText("");
				yearField.setText("");
				firstNameField.setText("");
				lastNameField.setText("");
				weightField.setText("");
				heightField.setText("");
				genderBox.setSelectedItem("Unspecified");

			}
		});
		btnDeleteUser.setBounds(23, 526, 248, 44);
		panel_2.add(btnDeleteUser);

		JButton btnnewUser_1 = new JButton("<html><h3>Create User</h3></html>");
		btnnewUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String genderString = (String) genderBox.getSelectedItem();
				per.setStudentID(Integer.parseInt(userIDField2.getText()));
				per.setWeight(Integer.parseInt(weightField.getText()));
				per.setHeight(Integer.parseInt(heightField.getText()));
				per.setGender(Gender.valueOf(genderString));
				per.setFirstName(firstNameField.getText());
				per.setLastName(lastNameField.getText());
				per.setBirthDate(LocalDate.of(Integer.parseInt(yearField.getText()),
						Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText())));

				per.save();
			}
		});
		btnnewUser_1.setBounds(23, 294, 248, 44);
		panel_2.add(btnnewUser_1);

		JButton btnloadUser = new JButton("<html><h3>Load Selected</h3></html>");
		btnloadUser.setBounds(23, 474, 248, 44);
		panel_2.add(btnloadUser);

		JLabel lbluserList = new JLabel("<html><h3>User List:</h3></html>");
		lbluserList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbluserList.setBounds(307, 399, 248, 27);
		panel_2.add(lbluserList);

		JList<String> userList = new JList<String>(model2);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setBorder(new CompoundBorder(

				new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), null));
		userList.setBounds(307, 428, 248, 142);
		panel_2.add(userList);

		JButton button_5 = new JButton("");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(FitnessGUI.class.getResource("/gui/arrow-clicked.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(FitnessGUI.class.getResource("/gui/Webp.net-resizeimage.png")));
			}
		});
		button_5.setBounds(0, 0, 44, 44);
		panel_2.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});

		button_5.setIcon(new ImageIcon(FitnessGUI.class.getResource("/gui/Webp.net-resizeimage.png")));
		button_5.setRequestFocusEnabled(false);
		button_5.setFocusable(false);
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);

		JButton btnUserInfo = new JButton("<html><h3>USER INFO</h3></html>");
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		btnUserInfo.setBounds(412, 89, 142, 33);
		panel_1.add(btnUserInfo);

		JButton btnLoad = new JButton("<html><h3>LOAD USER</h3></html>");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					per.load(Integer.parseInt(userIDField.getText()));
					per.loadAll(Integer.parseInt(userIDField.getText()));

					userIDField2.setText(userIDField.getText());
					weightField.setText(String.valueOf(per.getWeight()));
					heightField.setText(String.valueOf(per.getHeight()));
					genderBox.setSelectedItem(per.getGenderString());
					firstNameField.setText(per.getFirstName());
					lastNameField.setText(per.getLastName());
					yearField.setText(String.valueOf(per.getBirthDate().getYear()));
					monthField.setText(String.valueOf(per.getBirthDate().getMonth().getValue()));
					dayField.setText(String.valueOf(per.getBirthDate().getDayOfMonth()));

					for (int n = 0; n < per.exerciseA.size(); n++) {
						model.addElement(per.exerciseA.get(n));
					}
					for (int n = 0; n < per.exerciseS.size(); n++) {
						model.addElement(per.exerciseS.get(n));
					}
					System.out.println(per.exerciseS.size());
					list.setModel(model);

					// if (rAerobic.isSelected()) {
					// maxRateField.setText(String.valueOf(exeA.getMaxHeartRate()));
					// averageRateField.setText(String.valueOf(exeA.getAverageHeartRate()));
					// totalDistanceField.setText(String.valueOf(exeA.getDistance()));
					// exerciseNameField.setText(exeA.getExerciseName());
					// yearE.setText("year");
					// monthE.setText("month");
					// dayE.setText("day");
					// exerciseDurationField.setText(String.valueOf(exeA.getExerciseDuration()));
					// }
					//
					// if (rStrength.isSelected()) {
					// maxRateField.setText(String.valueOf(exeS.getWeightLifted()));
					// averageRateField.setText(String.valueOf(exeS.getSets()));
					// totalDistanceField.setText(String.valueOf(exeS.getReps()));
					// exerciseNameField.setText(exeA.getExerciseName());
					// yearE.setText("year");
					// monthE.setText("month");
					// dayE.setText("day");
					// exerciseDurationField.setText(String.valueOf(exeA.getExerciseDuration())); }

				} catch (NumberFormatException e1) {

				}

			}
		});
		btnLoad.setBounds(264, 89, 142, 33);
		panel_1.add(btnLoad);

		JButton btnNewButton = new JButton("Load Exercise\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
if (rStrength.isSelected()) {
					
					
					maxRateField.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getWeightLifted()));
					averageRateField.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getSets()));
					totalDistanceField.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getReps()));
					exerciseNameField.setText(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getExerciseName());
					yearE.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getExerciseDate().getYear()));
					monthE.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getExerciseDate().getMonth().getValue()));
					dayE.setText((String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getExerciseDate().getDayOfMonth())));
					exerciseDurationField.setText((String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getExerciseDuration())));

					maxRateField.setText((String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getReps())));
					averageRateField.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getSets()));
					totalDistanceField.setText(String.valueOf(per.exerciseS.get(list.getSelectedIndex() - per.exerciseA.size()).getWeightLifted()));
					
				} else if (rAerobic.isSelected()) {
					
					maxRateField.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getMaxHeartRate()));
					averageRateField.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getAverageHeartRate()));
					totalDistanceField.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getDistance()));
					exerciseNameField.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getExerciseName()));
					yearE.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getExerciseDate().getYear()));
					monthE.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getExerciseDate().getMonth().getValue()));
					dayE.setText((String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getExerciseDate().getDayOfMonth())));
					exerciseDurationField.setText(String.valueOf(per.exerciseA.get(list.getSelectedIndex()).getExerciseDuration()));

				}
	
			}
		});
		btnNewButton.setBounds(338, 524, 217, 25);
		panel_1.add(btnNewButton);
		
		JLabel lblthisIsA = new JLabel("<html>This is a fitness tracker. Enter your exercises to keep track of your fitness routine. Saves to an off-site database. </html>");
		lblthisIsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblthisIsA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblthisIsA.setBounds(23, 34, 532, 37);
		panel_1.add(lblthisIsA);

	}
}
