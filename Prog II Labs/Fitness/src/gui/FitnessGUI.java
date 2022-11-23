package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListModel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Window.Type;

public class FitnessGUI {

	private JFrame frmFitnessTracker;
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
	private ExerciseStrength exeS = new ExerciseStrength();
	private ExerciseAerobic exeA = new ExerciseAerobic();
	private Person per = new Person();
	private JTextField yearE;
	private JTextField dayE;
	private JTextField monthE;
	private DefaultListModel<Exercise> modelExercise = new DefaultListModel<>();
	private DefaultListModel<Person> modelUser = new DefaultListModel<>();
	// private DefaultListModel<Exercise> model3 = new DefaultListModel<>();
	private JList<Exercise> list = new JList<>();
	private JList<Person> userList = new JList<>();
	private JButton btnnewUser;
	private JButton btnLoad;
	private JButton btnAdd = new JButton("<html><u>A</u><br>D<br>D<br></html>");
	private JButton btnRemove = new JButton("<html><u>R</u><br>E<br>M<br>O<br>V<br>  E<br></html>");
	private JButton btnloadUser = new JButton("<html><h3>Load Selected</h3></html>");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessGUI window = new FitnessGUI();
					window.frmFitnessTracker.setVisible(true);
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

		DefaultListModel<String> model2 = new DefaultListModel<>();

		ArrayList<Exercise> exerciseArray = new ArrayList<Exercise>();

		frmFitnessTracker = new JFrame();
		frmFitnessTracker.setTitle("Fitness Tracker");
		frmFitnessTracker.setVisible(true);
		frmFitnessTracker.setResizable(false);
		frmFitnessTracker.setBounds(100, 100, 581, 637);
		frmFitnessTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFitnessTracker.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 581, 587);
		frmFitnessTracker.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		exerciseNameField = new JTextField();
		exerciseNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
		exerciseNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				exerciseNameField.setText("");
				exerciseNameField.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		exerciseNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseNameField.setBounds(23, 177, 230, 33);
		panel_1.add(exerciseNameField);
		exerciseNameField.setColumns(10);

		JLabel exerciseNameText = new JLabel("<html><h3>Exercise Name:</h3></html>");
		exerciseNameText.setFocusable(false);
		exerciseNameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseNameText.setBounds(23, 150, 230, 27);
		panel_1.add(exerciseNameText);

		JLabel exerciseDateText = new JLabel("<html><h3>Exercise Date:</h3></html>");
		exerciseDateText.setFocusTraversalKeysEnabled(false);
		exerciseDateText.setFocusable(false);
		exerciseDateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDateText.setBounds(23, 211, 230, 27);
		panel_1.add(exerciseDateText);

		exerciseDurationField = new JTextField();
		exerciseDurationField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
		exerciseDurationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				exerciseDurationField.setText(exerciseDurationField.getText().replaceAll("[^\\d.]", ""));

			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		exerciseDurationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				exerciseDurationField.setText("");
				exerciseDurationField.setForeground(Color.black);

			}
		});
		exerciseDurationField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDurationField.setColumns(10);
		exerciseDurationField.setBounds(23, 299, 230, 33);
		panel_1.add(exerciseDurationField);

		JLabel exerciseDurationText = new JLabel("<html><h3>Exercise Duration: </h3></html>");
		exerciseDurationText.setFocusable(false);
		exerciseDurationText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exerciseDurationText.setBounds(23, 272, 230, 27);
		panel_1.add(exerciseDurationText);

		maxRateField = new JTextField();
		maxRateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
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
		maxRateText.setFocusable(false);
		maxRateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maxRateText.setBounds(23, 331, 230, 27);
		panel_1.add(maxRateText);

		averageRateField = new JTextField();
		averageRateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
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
				averageRateField.setForeground(Color.black);

			}
		});
		averageRateField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		averageRateField.setColumns(10);
		averageRateField.setBounds(23, 418, 230, 33);
		panel_1.add(averageRateField);

		JLabel averageRateText = new JLabel("<html><h3>Average Heart Rate:</h3></html>");
		averageRateText.setFocusable(false);
		averageRateText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		averageRateText.setBounds(23, 391, 230, 27);
		panel_1.add(averageRateText);

		JLabel totalDistanceText = new JLabel("<html><h3>Total Distance:</h3></html>");
		totalDistanceText.setFocusable(false);
		totalDistanceText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalDistanceText.setBounds(23, 451, 230, 27);
		panel_1.add(totalDistanceText);
		JRadioButton rAerobic = new JRadioButton("<html><h3>A<u>e</u>robic</h3></html>");
		rAerobic.setFocusPainted(false);
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
		rAerobic.setBounds(23, 531, 94, 33);
		panel_1.add(rAerobic);

		JRadioButton rStrength = new JRadioButton("<html><h3><u>S</u>trength</h3></html>");
		rStrength.setMnemonic('s');
		rStrength.setMnemonic(KeyEvent.VK_S);
		rStrength.setFocusPainted(false);
		rStrength.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				maxRateText.setText("<html><h3>Weight Lifted:</h3></html>");
				averageRateText.setText("<html><h3>Total Sets:</h3></html>");
				totalDistanceText.setText("<html><h3>Total Reps:</h3></html>");
			}
		});
		buttonGroup.add(rStrength);
		rStrength.setBounds(124, 531, 129, 33);
		panel_1.add(rStrength);

		JLabel titleText = new JLabel("<html><h1>Fitness Tracker</h1></html>");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleText.setBounds(23, 22, 532, 33);
		panel_1.add(titleText);

		JLabel userIDText = new JLabel("<html><h2>USER ID:</h2></html>");
		userIDText.setFocusable(false);
		userIDText.setFont(new Font("Tahoma", Font.BOLD, 18));
		userIDText.setBounds(23, 84, 85, 44);
		panel_1.add(userIDText);

		userIDField = new JTextField();
		userIDField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLoad.doClick();
				}

			}
		});
		userIDField.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent arg0) {
			}
		});
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
				userIDField.setForeground(Color.BLACK);
			}
		});
		userIDField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDField.setColumns(10);
		userIDField.setBounds(110, 89, 142, 33);
		panel_1.add(userIDField);

		yearE = new JTextField();
		yearE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				yearE.setText((yearE.getText().replaceAll("\\p{P}", "")));
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
		yearE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					if (yearE.getText().length() >= 4) {
						e.consume();
					}

				} catch (NumberFormatException e6) {

				}
			}
		});
		yearE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					yearE.setText(yearE.getText().replaceAll("[^\\d.]", ""));

					monthE.setText(monthE.getText().replaceAll("[^\\d.]", ""));
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 28
							&& !yearE.getText().equals("2020") && !yearE.getText().equals("2024")
							&& !yearE.getText().equals("2028")) {
						dayE.setText("28");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2020")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2024")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 4 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 7 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 9 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 11 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}

				} catch (NumberFormatException e3) {

				}
			}
		});
		yearE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				yearE.setText("");
				yearE.setForeground(Color.black);
			}
		});
		yearE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yearE.setColumns(10);
		yearE.setBounds(172, 238, 81, 33);
		panel_1.add(yearE);

		dayE = new JTextField();
		dayE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					if (dayE.getText().length() >= 2) {
						e.consume();
					}
					if (dayE.getText().length() != 0) {
						if (Integer.parseInt(dayE.getText()) > 3) {
							e.consume();
						}
					}
				} catch (NumberFormatException e6) {

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					int n = 31;
					String b = "3";
					if (Integer.parseInt(monthE.getText()) == 2 && !yearE.getText().equals("2020")
							&& !yearE.getText().equals("2024") && !yearE.getText().equals("2028")) {
						n = 28;
						b = "2";
					}

					if (Integer.parseInt(monthE.getText()) == 2 && yearE.getText().equals("")) {
						n = 29;
						b = "2";
					}

					if (Integer.parseInt(monthE.getText()) == 2 && yearE.getText().equals("2020")) {
						n = 29;
						b = "2";
					}

					if (Integer.parseInt(monthE.getText()) == 2 && yearE.getText().equals("2024")) {
						n = 29;
						b = "2";
					}

					if (Integer.parseInt(monthE.getText()) == 2 && yearE.getText().equals("2028")) {
						n = 29;
						b = "2";
					}

					if (Integer.parseInt(monthE.getText()) == 7) {
						n = 30;
					}
					if (Integer.parseInt(monthE.getText()) == 4) {
						n = 30;
					}

					if (Integer.parseInt(monthE.getText()) == 9) {
						n = 30;
					}

					if (Integer.parseInt(monthE.getText()) == 11) {
						n = 30;
					}

					if (Integer.parseInt(dayE.getText()) > n) {
						dayE.setText(b);
						e.consume();
					}
				} catch (NumberFormatException e3) {

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				dayE.setText((dayE.getText().replaceAll("\\p{P}", "")));
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
		dayE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					dayE.setText(dayE.getText().replaceAll("[^\\d.]", ""));
					monthE.setText(monthE.getText().replaceAll("[^\\d.]", ""));
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 28
							&& !yearE.getText().equals("2020") && !yearE.getText().equals("2024")
							&& !yearE.getText().equals("2028")) {
						dayE.setText("28");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2020")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2024")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 4 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 7 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 9 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 11 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}

				} catch (NumberFormatException e3) {

				}
			}
		});
		dayE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dayE.setText("");
				dayE.setForeground(Color.black);
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
				try {

					monthE.setText(monthE.getText().replaceAll("[^\\d.]", ""));
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 28
							&& !yearE.getText().equals("2020") && !yearE.getText().equals("2024")
							&& !yearE.getText().equals("2028")) {
						dayE.setText("28");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2020")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 2 && Integer.parseInt(dayE.getText()) > 29
							&& yearE.getText().equals("2024")) {
						dayE.setText("29");
					}
					if (Integer.parseInt(monthE.getText()) == 4 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 7 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 9 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}
					if (Integer.parseInt(monthE.getText()) == 11 && Integer.parseInt(dayE.getText()) > 30) {
						dayE.setText("30");
					}

				} catch (NumberFormatException e3) {

				}
			}
		});
		monthE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				monthE.setText("");
				monthE.setForeground(Color.black);

			}
		});
		monthE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					if (monthE.getText().length() >= 2) {
						e.consume();
					}
					if (monthE.getText().length() != 0) {
						if (Integer.parseInt(monthE.getText()) > 1) {
							e.consume();
						}
					}
				} catch (NumberFormatException e6) {

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (Integer.parseInt(monthE.getText()) >= 13) {
						monthE.setText("1");
						e.consume();
					}
				} catch (NumberFormatException e6) {

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				monthE.setText((monthE.getText().replaceAll("\\p{P}", "")));
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
		monthE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monthE.setColumns(2);
		monthE.setBounds(23, 238, 61, 33);
		panel_1.add(monthE);

		JLabel label_5 = new JLabel("/");
		label_5.setFocusable(false);
		label_5.setRequestFocusEnabled(false);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(84, 238, 12, 33);
		panel_1.add(label_5);

		JLabel label_8 = new JLabel("/");
		label_8.setFocusable(false);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(159, 238, 12, 33);
		panel_1.add(label_8);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 135, 532, 2);
		panel_1.add(separator);

		JSeparator separator_5 = new JSeparator();
		separator_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		separator_5.setBounds(23, 74, 532, 2);
		panel_1.add(separator_5);

		JLabel lblcopywritedProgramm = new JLabel(
				"<html><small><i>Property of AwesomeProgramming\u2122, Copyrighted 2018 \u00A9 </i></small></html>");
		lblcopywritedProgramm.setFocusable(false);
		lblcopywritedProgramm.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblcopywritedProgramm.setBounds(275, 533, 295, 33);
		panel_1.add(lblcopywritedProgramm);

		btnRemove.setFocusable(false);
		btnRemove.setMnemonic(KeyEvent.VK_R);
		btnRemove.setRequestFocusEnabled(false);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg101) {
				btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				try {

					if (rStrength.isSelected()) {
						exeS.delete(
								(per.getExerciseA().get(list.getSelectedIndex() - per.getExerciseA().size())
										.getStudentID()),
								(per.getExerciseA().get(list.getSelectedIndex() - per.getExerciseA().size())
										.getExerciseDate()),
								(per.getExerciseA().get(list.getSelectedIndex() - per.getExerciseA().size())
										.getExerciseName()));
					} else if (rAerobic.isSelected()) {
						exeA.delete((per.getExerciseA().get(list.getSelectedIndex()).getStudentID()),
								(per.getExerciseA().get(list.getSelectedIndex()).getExerciseDate()),
								(per.getExerciseA().get(list.getSelectedIndex()).getExerciseName()));
					}
					modelExercise.removeElementAt(list.getSelectedIndex());
					clear();
					per.loadAll(per.getStudentID());
					refresh();
				} catch (NumberFormatException e) {
					if (maxRateField.getText().length() == 0) {
						maxRateField.setForeground(Color.RED);
						maxRateField.setText("*REQUIRED*");

					}
					if (averageRateField.getText().length() == 0) {
						averageRateField.setForeground(Color.RED);
						averageRateField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (exerciseNameField.getText().length() == 0) {
						exerciseNameField.setForeground(Color.RED);
						exerciseNameField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (yearE.getText().length() == 0) {
						yearE.setForeground(Color.RED);
						yearE.setText("***");
						;
					}
					if (monthE.getText().length() == 0) {
						monthE.setForeground(Color.RED);
						monthE.setText("***");

					}
					if (dayE.getText().length() == 0) {
						dayE.setForeground(Color.RED);
						dayE.setText("***");

					}

					if (exerciseDurationField.getText().length() == 0) {
						exerciseDurationField.setForeground(Color.RED);
						exerciseDurationField.setText("*REQUIRED*");

					}

				} catch (ArrayIndexOutOfBoundsException e) {
					if (maxRateField.getText().length() == 0) {
						maxRateField.setForeground(Color.RED);
						maxRateField.setText("*REQUIRED*");

					}
					if (averageRateField.getText().length() == 0) {
						averageRateField.setForeground(Color.RED);
						averageRateField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (exerciseNameField.getText().length() == 0) {
						exerciseNameField.setForeground(Color.RED);
						exerciseNameField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (yearE.getText().length() == 0) {
						yearE.setForeground(Color.RED);
						yearE.setText("***");
						;
					}
					if (monthE.getText().length() == 0) {
						monthE.setForeground(Color.RED);
						monthE.setText("***");

					}
					if (dayE.getText().length() == 0) {
						dayE.setForeground(Color.RED);
						dayE.setText("***");

					}

					if (exerciseDurationField.getText().length() == 0) {
						exerciseDurationField.setForeground(Color.RED);
						exerciseDurationField.setText("*REQUIRED*");

					}
				}
				btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnRemove.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnRemove.setBounds(265, 331, 61, 178);
		panel_1.add(btnRemove);

		btnAdd.setFocusTraversalKeysEnabled(false);
		btnAdd.setFocusable(false);
		btnAdd.setMnemonic(KeyEvent.VK_A);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {
					if (rAerobic.isSelected()) {
						exeA.setStudentID(per.getStudentID());
						exeA.setMaxHeartRate(Integer.parseInt(maxRateField.getText()));
						exeA.setAverageHeartRate(Integer.parseInt(averageRateField.getText()));
						exeA.setDistance(Double.parseDouble(totalDistanceField.getText()));
						exeA.setExerciseName(exerciseNameField.getText());
						exeA.setExerciseDate(LocalDate.of(Integer.parseInt(yearE.getText()),
								Integer.parseInt(monthE.getText()), Integer.parseInt(dayE.getText())));
						exeA.setExerciseDuration(Duration.ofMinutes(Integer.parseInt(exerciseDurationField.getText())));
						exeA.save(exeA.getStudentID(), exeA.getExerciseDate(), exeA.getExerciseName(),
								exeA.getExerciseDuration());

					}

					if (rStrength.isSelected()) {
						exeS.setStudentID(per.getStudentID());
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

					clear();
					per.loadAll(Integer.parseInt(userIDField.getText()));

					refresh();

				} catch (NumberFormatException e) {
					if (maxRateField.getText().length() == 0) {
						maxRateField.setForeground(Color.RED);
						maxRateField.setText("*REQUIRED*");

					}
					if (averageRateField.getText().length() == 0) {
						averageRateField.setForeground(Color.RED);
						averageRateField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (exerciseNameField.getText().length() == 0) {
						exerciseNameField.setForeground(Color.RED);
						exerciseNameField.setText("*REQUIRED*");

					}
					if (totalDistanceField.getText().length() == 0) {
						totalDistanceField.setForeground(Color.RED);
						totalDistanceField.setText("*REQUIRED*");

					}
					if (yearE.getText().length() == 0) {
						yearE.setForeground(Color.RED);
						yearE.setText("***");

					}
					if (monthE.getText().length() == 0) {
						monthE.setForeground(Color.RED);
						monthE.setText("***");

					}
					if (dayE.getText().length() == 0) {
						dayE.setForeground(Color.RED);
						dayE.setText("***");

					}

					if (exerciseDurationField.getText().length() == 0) {
						exerciseDurationField.setForeground(Color.RED);
						exerciseDurationField.setText("*REQUIRED*");

					}

				}
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnAdd.setBounds(265, 150, 61, 178);
		panel_1.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 177, 217, 331);
		panel_1.add(scrollPane);
		list.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setViewportView(list);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rAerobic.setSelected(true);
				colorFields();
				;

				maxRateText.setText("<html><h3>Max Heart Rate:</h3></html>");
				averageRateText.setText("<html><h3>Average Heart Rate:</h3></html>");
				totalDistanceText.setText("<html><h3>Total Distance:</h3></html>");

				if (modelExercise.getElementAt(list.getSelectedIndex()).getType() == true) {
					maxRateField
							.setText(String.valueOf(per.getExerciseA().get(list.getSelectedIndex()).getMaxHeartRate()));
					averageRateField.setText(
							String.valueOf(per.getExerciseA().get(list.getSelectedIndex()).getAverageHeartRate()));
					totalDistanceField
							.setText(String.valueOf(per.getExerciseA().get(list.getSelectedIndex()).getDistance()));
					exerciseNameField
							.setText(String.valueOf(per.getExerciseA().get(list.getSelectedIndex()).getExerciseName()));
					yearE.setText(String
							.valueOf(per.getExerciseA().get(list.getSelectedIndex()).getExerciseDate().getYear()));
					monthE.setText(String.valueOf(
							per.getExerciseA().get(list.getSelectedIndex()).getExerciseDate().getMonth().getValue()));
					dayE.setText((String.valueOf(
							per.getExerciseA().get(list.getSelectedIndex()).getExerciseDate().getDayOfMonth())));
					exerciseDurationField.setText(String.valueOf(
							per.getExerciseA().get(list.getSelectedIndex()).getExerciseDuration().toMinutes()));

				} else if (modelExercise.getElementAt(list.getSelectedIndex()).getType() == false) {
					rStrength.setSelected(true);
					maxRateText.setText("<html><h3>Weight Lifted:</h3></html>");
					averageRateText.setText("<html><h3>Total Sets:</h3></html>");
					totalDistanceText.setText("<html><h3>Total Reps:</h3></html>");

					maxRateField.setText(String.valueOf(per.getExerciseS()
							.get(list.getSelectedIndex() - per.getExerciseA().size()).getWeightLifted()));
					averageRateField.setText(String.valueOf(
							per.getExerciseS().get(list.getSelectedIndex() - per.getExerciseA().size()).getSets()));
					totalDistanceField.setText(String.valueOf(
							per.getExerciseS().get(list.getSelectedIndex() - per.getExerciseA().size()).getReps()));
					exerciseNameField.setText(String.valueOf(per.getExerciseS()
							.get(list.getSelectedIndex() - per.getExerciseA().size()).getExerciseName()));
					yearE.setText(String.valueOf(per.getExerciseS()
							.get(list.getSelectedIndex() - per.getExerciseA().size()).getExerciseDate().getYear()));
					monthE.setText(
							String.valueOf(per.getExerciseS().get(list.getSelectedIndex() - per.getExerciseA().size())
									.getExerciseDate().getMonth().getValue()));
					dayE.setText(
							(String.valueOf(per.getExerciseS().get(list.getSelectedIndex() - per.getExerciseA().size())
									.getExerciseDate().getDayOfMonth())));
					exerciseDurationField.setText(
							String.valueOf(per.getExerciseS().get(list.getSelectedIndex() - per.getExerciseA().size())
									.getExerciseDuration().toMinutes()));
				}
			}
		});
		list.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		list.setBounds(338, 150, 217, 361);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblexerciseList = new JLabel("<html><h3>Exercise List:</h3></html>");
		lblexerciseList.setFocusTraversalKeysEnabled(false);
		lblexerciseList.setFocusable(false);
		lblexerciseList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblexerciseList.setBounds(338, 150, 230, 27);
		panel_1.add(lblexerciseList);

		JButton button = new JButton("<html><h1><i><u>i</u></i></h1></html>");
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setFocusTraversalKeysEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder infoMessage = new StringBuilder();
				infoMessage.append(
						"<html>This is a fitness tracker. Enter your exercises to keep track of your fitness routine. Saves to an off-site database. "
								+ "<br><dl>" + "<dt>Shortcuts:<dt>" + "<dd>Load; [ENTER] (while in person area) <dd>"
								+ "<dd>Add; [ENTER] (while in exercise area) <dd>" + "<dd>Remove; [DELETE]<dd>"
								+ "<dd>Create/Update; [ENTER] (while in user info page) <dd>"
								+ "<dd>Load Selected; [ENTER] (while in meta-user section) <dd>"
								+ "<dd>Delete Selected; [DELETE] (while in meta-user section) <dd>" + "</dl> </html>");

				JOptionPane.showMessageDialog(null, infoMessage);

			}
		});
		button.setMnemonic('i');
		button.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		button.setContentAreaFilled(false);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(533, 9, 22, 33);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 581, 605);
		frmFitnessTracker.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);

		JLabel userSettingsTitle = new JLabel("<html><h1>User Settings<h1></html>");
		userSettingsTitle.setFocusable(false);
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
		lblnewUserupdateUser.setFocusable(false);
		lblnewUserupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblnewUserupdateUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnewUserupdateUser.setBounds(23, 51, 532, 44);
		panel_2.add(lblnewUserupdateUser);

		userIDField2 = new JTextField();
		userIDField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
		});
		userIDField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				userIDField2.setText(userIDField2.getText().replaceAll("[^\\d.]", ""));
			}

			@Override
			public void focusGained(FocusEvent e) {
				userIDField2.setForeground(Color.BLACK);
				userIDField2.setText("");
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
		firstNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
		});
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
		nameText.setFocusable(false);
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameText.setBounds(23, 156, 248, 27);
		panel_2.add(nameText);

		JLabel userIDText2 = new JLabel("<html><h3>User ID:</h3></html>");
		userIDText2.setFocusable(false);
		userIDText2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDText2.setBounds(23, 88, 248, 27);
		panel_2.add(userIDText2);

		JLabel lblDateOfBirth = new JLabel("<html><h3>Date of Birth:</h3></html>\r\n");
		lblDateOfBirth.setFocusable(false);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(23, 217, 248, 27);
		panel_2.add(lblDateOfBirth);

		JLabel lblheight = new JLabel("<html><h3>Height:</h3></html>");
		lblheight.setFocusable(false);
		lblheight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblheight.setBounds(307, 88, 248, 27);
		panel_2.add(lblheight);

		JLabel lblgender = new JLabel("<html><h3>Gender:</h3></html>");
		lblgender.setFocusable(false);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblgender.setBounds(307, 217, 248, 27);
		panel_2.add(lblgender);

		heightField = new JTextField();
		heightField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
		});
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
				heightField.setForeground(Color.BLACK);

			}
		});
		heightField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heightField.setColumns(10);
		heightField.setBounds(307, 122, 248, 33);
		panel_2.add(heightField);

		weightField = new JTextField();
		weightField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
		});
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
				weightField.setForeground(Color.BLACK);

			}
		});
		weightField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weightField.setColumns(10);
		weightField.setBounds(307, 183, 248, 33);
		panel_2.add(weightField);

		JLabel lblweight = new JLabel("<html><h3>Weight:</h3></html>");
		lblweight.setFocusable(false);
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
		lbluserOptions.setFocusable(false);
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
		lastNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
		});
		lastNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastNameField.setText("");

			}

			@Override
			public void focusLost(FocusEvent arg0) {

			}
		});
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameField.setColumns(10);
		lastNameField.setBounds(157, 183, 114, 33);
		panel_2.add(lastNameField);

		yearField = new JTextField();
		yearField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (yearField.getText().length() >= 4) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_PERIOD) {
					String text = yearField.getText();
					yearField.setText(text);
				}
			}
		});
		yearField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					monthField.setText(monthField.getText().replaceAll("[^\\d.]", ""));
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 28
							&& !yearField.getText().equals("") && !yearField.getText().equals("2020")
							&& !yearField.getText().equals("2024") && !yearField.getText().equals("2028")) {
						dayField.setText("28");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2020")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2024")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 4 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 7 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 9 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 11 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
				} catch (NumberFormatException e5) {

				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				yearField.setForeground(Color.BLACK);
			}
		});
		yearField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				yearField.setText("");
				yearField.setForeground(Color.BLACK);

			}
		});
		yearField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yearField.setColumns(10);
		yearField.setBounds(172, 244, 99, 33);
		panel_2.add(yearField);

		dayField = new JTextField();
		dayField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dayField.getText().length() >= 2) {
					e.consume();
				}
				if (dayField.getText().length() != 0) {
					if (Integer.parseInt(dayField.getText()) > 3) {
						e.consume();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int n = 31;
				String b = "3";
				if (Integer.parseInt(monthField.getText()) == 2 && !yearField.getText().equals("")
						&& !yearField.getText().equals("2020") && !yearField.getText().equals("2024")
						&& !yearField.getText().equals("2028")) {
					n = 28;
					b = "2";
				}

				if (Integer.parseInt(monthField.getText()) == 2 && yearField.getText().equals("")) {
					n = 29;
					b = "2";
				}

				if (Integer.parseInt(monthField.getText()) == 2 && yearField.getText().equals("2020")) {
					n = 29;
					b = "2";
				}

				if (Integer.parseInt(monthField.getText()) == 2 && yearField.getText().equals("2024")) {
					n = 29;
					b = "2";
				}

				if (Integer.parseInt(monthField.getText()) == 2 && yearField.getText().equals("2028")) {
					n = 29;
					b = "2";
				}
				if (Integer.parseInt(monthField.getText()) == 7) {
					n = 30;
				}
				if (Integer.parseInt(monthField.getText()) == 4) {
					n = 30;
				}

				if (Integer.parseInt(monthField.getText()) == 9) {
					n = 30;
				}

				if (Integer.parseInt(monthField.getText()) == 11) {
					n = 30;
				}

				if (Integer.parseInt(dayField.getText()) > n) {
					dayField.setText(b);
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
				
			}
		});
		dayField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					dayField.setText(dayField.getText().replaceAll("[^\\d.]", ""));
					monthField.setText(monthField.getText().replaceAll("[^\\d.]", ""));
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 28
							&& !yearField.getText().equals("") && !yearField.getText().equals("2020")
							&& !yearField.getText().equals("2024") && !yearField.getText().equals("2028")) {
						dayField.setText("28");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2020")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2024")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 4 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 7 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 9 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 11 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
				} catch (NumberFormatException e5) {

				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				dayField.setForeground(Color.BLACK);
			}
		});
		dayField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				dayField.setText("");
				dayField.setForeground(Color.BLACK);
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
				try {

					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 28
							&& !yearField.getText().equals("") && !yearField.getText().equals("2020")
							&& !yearField.getText().equals("2024") && !yearField.getText().equals("2028")) {
						dayField.setText("28");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2020")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 2 && Integer.parseInt(dayField.getText()) > 29
							&& yearField.getText().equals("2024")) {
						dayField.setText("29");
					}
					if (Integer.parseInt(monthField.getText()) == 4 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 7 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 9 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
					if (Integer.parseInt(monthField.getText()) == 11 && Integer.parseInt(dayField.getText()) > 30) {
						dayField.setText("30");
					}
				} catch (NumberFormatException e5) {

				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				monthField.setForeground(Color.BLACK);
			}
		});
		monthField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				monthField.setText("");
				monthField.setForeground(Color.BLACK);

			}
		});
		monthField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (monthField.getText().length() >= 2) {
					e.consume();
				}
				if (monthField.getText().length() != 0) {
					if (Integer.parseInt(monthField.getText()) > 1) {
						e.consume();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Integer.parseInt(monthField.getText()) >= 13) {
					monthField.setText("1");
					e.consume();

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				monthField.setText((monthField.getText().replaceAll("\\p{P}", "")));
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeNew();
				}
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
		label_2.setFocusable(false);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(23, 399, 248, 27);
		panel_2.add(label_2);

		JButton btnupdateUser = new JButton("<html><h3>Update User</h3></html>");
		btnupdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnupdateUser.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				try {
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

				} catch (NumberFormatException e) {
					if (userIDField2.getText().length() == 0) {
						userIDField2.setForeground(Color.RED);
						userIDField2.setText("*REQUIRED*");

					}
					if (weightField.getText().length() == 0) {
						weightField.setForeground(Color.RED);
						weightField.setText("*REQUIRED*");

					}
					if (heightField.getText().length() == 0) {
						heightField.setForeground(Color.RED);
						heightField.setText("*REQUIRED*");

					}
					if (firstNameField.getText().length() == 0) {
						firstNameField.setForeground(Color.RED);
						firstNameField.setText("*REQUIRED*");

					}

					if (yearField.getText().length() == 0) {
						yearField.setForeground(Color.RED);
						yearField.setText("***");
						;
					}
					if (monthField.getText().length() == 0) {
						monthField.setForeground(Color.RED);
						monthField.setText("***");

					}
					if (dayField.getText().length() == 0) {
						dayField.setForeground(Color.RED);
						dayField.setText("***");

					}
				}
				btnupdateUser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnupdateUser.setBounds(307, 294, 248, 44);
		panel_2.add(btnupdateUser);

		JButton btnDeleteUser = new JButton("<html><h3>Delete Selected</h3></html>");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {
					per.setStudentID(Integer.parseInt(userIDField3.getText()));

					btnDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

					int confirmMessage = JOptionPane.showConfirmDialog(frmFitnessTracker,
							"Are you sure you want to delete user #" + userIDField3.getText()
									+ "? There is no undoing this command.",
							"Delete Message", JOptionPane.YES_NO_OPTION);

					btnDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					if (confirmMessage == JOptionPane.YES_OPTION) {
						per.delete(Integer.parseInt(userIDField3.getText()));

						per.loadAllPeople();
						refreshUsers();
						clearUsers();

						userIDField.setText("");
						monthField.setText("");
						dayField.setText("");
						yearField.setText("");
						firstNameField.setText("");
						lastNameField.setText("");
						weightField.setText("");
						heightField.setText("");
						genderBox.setSelectedItem("Unspecified");
					} else {

					}
				} catch (NumberFormatException e4) {

				}
				btnDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnDeleteUser.setBounds(23, 526, 248, 44);
		panel_2.add(btnDeleteUser);

		JLabel lbluserList = new JLabel("<html><h3>User List:</h3></html>");
		lbluserList.setFocusable(false);
		lbluserList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbluserList.setBounds(307, 399, 248, 27);
		panel_2.add(lbluserList);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(307, 428, 248, 142);
		panel_2.add(scrollPane_1);
		userList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int x = userList.getSelectedIndex();
				userIDField3.setText(String.valueOf(modelUser.getElementAt(x).getStudentID()));

			}
		});
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setAlignmentY(1.0f);
		userList.setBounds(0, 0, 215, 326);
		scrollPane_1.setViewportView(userList);

		JButton btnload = new JButton("LOAD ALL USERS");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnload.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				per.loadAllPeople();
				refreshUsers();
				clearUsers();
				btnload.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			}
		});
		btnload.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setColumnHeaderView(btnload);

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

		btnnewUser = new JButton("<html><h3>Create User</h3></html>");
		btnnewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnnewUser.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {

					String genderString = (String) genderBox.getSelectedItem();
					per.setStudentID(Integer.parseInt(userIDField2.getText()));
					per.setWeight(Integer.parseInt(weightField.getText()));
					per.setHeight(Integer.parseInt(heightField.getText()));
					per.setGender(Gender.valueOf(genderString));
					per.setFirstName(firstNameField.getText());
					per.setLastName(lastNameField.getText());
					per.setBirthDate(LocalDate.of(Integer.parseInt(yearField.getText()),
							Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText())));
					userIDField.setText(String.valueOf(per.getStudentID()));
					per.save();
					btnLoad.doClick();

				} catch (NumberFormatException e) {
					if (userIDField2.getText().length() == 0) {
						userIDField2.setForeground(Color.RED);
						userIDField2.setText("*REQUIRED*");

					}
					if (weightField.getText().length() == 0) {
						weightField.setForeground(Color.RED);
						weightField.setText("*REQUIRED*");

					}
					if (heightField.getText().length() == 0) {
						heightField.setForeground(Color.RED);
						heightField.setText("*REQUIRED*");

					}
					if (firstNameField.getText().length() == 0) {
						firstNameField.setForeground(Color.RED);
						firstNameField.setText("*REQUIRED*");

					}
					if (lastNameField.getText().length() == 0) {
						lastNameField.setForeground(Color.RED);
						lastNameField.setText("*REQUIRED*");

					}
					if (yearField.getText().length() == 0) {
						yearField.setForeground(Color.RED);
						yearField.setText("***");
						;
					}
					if (monthField.getText().length() == 0) {
						monthField.setForeground(Color.RED);
						monthField.setText("***");

					}
					if (dayField.getText().length() == 0) {
						dayField.setForeground(Color.RED);
						dayField.setText("***");

					}

				}
				
				try {
		
					if (lastNameField.getText().toLowerCase().equals("money")
							&& firstNameField.getText().toLowerCase().equals("c")
							&& (LocalDate.now().getMonthValue() == Integer.parseInt(monthField.getText()))
							&& (LocalDate.now().getDayOfMonth() == Integer.parseInt(dayField.getText()))
							&& (LocalDate.now().getYear() == Integer.parseInt(yearField.getText()))) {
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image image = toolkit.getImage(getClass().getResource("arrow2.png"));
						Point hotspot = new Point(0, 0);
						Cursor cursor = toolkit.createCustomCursor(image, hotspot, "cursor");
						panel_1.setCursor(cursor);
						panel_2.setCursor(cursor);
					} else {
						panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						;
					}
				} catch (NumberFormatException e) {

				}
				
				btnnewUser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			}
		});
		btnnewUser.setBounds(23, 294, 248, 44);
		panel_2.add(btnnewUser);

		btnloadUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		btnloadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnloadUser.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				System.out.println(userIDField3.getText());
				
				try {

					clear();
					colorUserFields();
					clearUserFields();
					per.load(Integer.parseInt(userIDField3.getText()));
					per.loadAll(Integer.parseInt(userIDField3.getText()));

					userIDField2.setText(userIDField3.getText());
					weightField.setText(String.valueOf(per.getWeight()));
					heightField.setText(String.valueOf(per.getHeight()));
					genderBox.setSelectedItem(per.getGenderString());
					firstNameField.setText(per.getFirstName());
					lastNameField.setText(per.getLastName());
					yearField.setText(String.valueOf(per.getBirthDate().getYear()));
					monthField.setText(String.valueOf(per.getBirthDate().getMonth().getValue()));
					dayField.setText(String.valueOf(per.getBirthDate().getDayOfMonth()));

					refreshUsers();

					StringBuilder welcomeMessage = new StringBuilder();
					welcomeMessage.append("\nWelcome " + per.getFirstName() + " " + per.getLastName() + "!");
					double n = Math.random();
					if (n <= 0.25) {
						welcomeMessage.append("\nIt's nice to have you back.");
					} else if (n >= 0.75) {
						welcomeMessage.append("\nBack at it I see. Good luck with your workout.");
					} else if (n > 0.25 && Math.random() <= 0.50) {
						welcomeMessage.append("\nIt's been a while.");
					} else if (n > 0.50 && Math.random() < 0.75) {
						welcomeMessage.append("\nLets get to working out.");
					}

					JOptionPane.showMessageDialog(null, welcomeMessage);

				} catch (NumberFormatException e1) {
					if (userIDField3.getText().length() == 0) {
						userIDField3.setForeground(Color.RED);
						userIDField3.setText("*REQUIRED*");
						

					}

				}
				btnloadUser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			}

		});
		btnloadUser.setBounds(23, 474, 248, 44);
		panel_2.add(btnloadUser);

		JButton btnUserInfo = new JButton("<html><h3><u>U</u>SER INFO</h3></html>");
		btnUserInfo.setFocusTraversalKeysEnabled(false);
		btnUserInfo.setFocusable(false);

		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		btnUserInfo.setBounds(412, 89, 142, 33);
		panel_1.add(btnUserInfo);

		totalDistanceField = new JTextField();
		totalDistanceField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeAdd();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					executeRemove();
				}
			}
		});
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
				totalDistanceField.setForeground(Color.black);
			}
		});
		totalDistanceField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalDistanceField.setColumns(10);
		totalDistanceField.setBounds(23, 478, 230, 33);
		panel_1.add(totalDistanceField);

		btnLoad = new JButton("<html><h3><u>L</u>OAD USER</h3></html>");
		btnLoad.setFocusable(false);
		btnLoad.setFocusTraversalKeysEnabled(false);
		btnLoad.setMnemonic('L');
		btnLoad.setMnemonic(KeyEvent.VK_L);
		btnLoad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userIDField.setForeground(Color.BLACK);

			}
		});
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoad.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
				try {
					
					colorUserFields();
					clearUserFields();
					clear();
					colorFields();
					clearFields();

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

					refresh();

					StringBuilder welcomeMessage = new StringBuilder();
					welcomeMessage.append("\nWelcome " + per.getFirstName() + " " + per.getLastName() + "!");
					double n = Math.random();
					if (n <= 0.25) {
						welcomeMessage.append("\nIt's nice to have you back.");
					} else if (n >= 0.75) {
						welcomeMessage.append("\nBack at it I see. Good luck with your workout.");
					} else if (n > 0.25 && Math.random() <= 0.50) {
						welcomeMessage.append("\nIt's been a while.");
					} else if (n > 0.50 && Math.random() < 0.75) {
						welcomeMessage.append("\nLets get to working out.");
					}

					JOptionPane.showMessageDialog(null, welcomeMessage);

				} catch (NumberFormatException e1) {
					userIDField.setForeground(Color.RED);
					userIDField.setText("*REQUIRED*");

				}

				btnLoad.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnLoad.setBounds(264, 89, 142, 33);
		panel_1.add(btnLoad);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { userIDField, exerciseNameField,
				monthE, dayE, yearE, exerciseDurationField, maxRateField, averageRateField, totalDistanceField,
				rAerobic, rStrength, btnAdd, btnRemove, btnLoad, btnUserInfo, button }));

		userIDField3 = new JTextField();
		userIDField3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					btnDeleteUser.doClick();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnloadUser.doClick();
				}
			}
		});
		userIDField3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				userIDField3.setText(userIDField3.getText().replaceAll("[^\\d.]", ""));

			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		userIDField3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userIDField3.setText("");
				userIDField3.setForeground(Color.BLACK);

			}
		});
		userIDField3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userIDField3.setColumns(10);
		userIDField3.setBounds(23, 428, 248, 33);
		panel_2.add(userIDField3);
	}

	private void refresh() {
		modelExercise.clear();
		list.setModel(modelExercise);

		for (int k = 0; k < per.getExerciseA().size(); k++) {
			modelExercise.addElement(per.getExerciseA().get(k));

		}
		for (int i = 0; i < per.getExerciseS().size(); i++) {
			modelExercise.addElement(per.getExerciseS().get(i));
		}

	}

	private void refreshUsers() {
		modelUser.clear();
		userList.setModel(modelUser);

		for (int k = 0; k < per.getPeopleA().size(); k++) {
			modelUser.addElement(per.getPeople().get(k));

		}

	}

	private void clear() {
		per.getExerciseA().clear();
		per.getExerciseS().clear();
	}

	private void clearUsers() {
		per.getPeopleA().clear();
	}

	private void colorFields() {
		maxRateField.setForeground(Color.BLACK);
		averageRateField.setForeground(Color.BLACK);
		totalDistanceField.setForeground(Color.BLACK);
		exerciseNameField.setForeground(Color.BLACK);
		totalDistanceField.setForeground(Color.BLACK);
		yearE.setForeground(Color.BLACK);
		monthE.setForeground(Color.BLACK);
		dayE.setForeground(Color.BLACK);
		exerciseDurationField.setForeground(Color.BLACK);

	}

	private void colorUserFields() {
		userIDField2.setForeground(Color.BLACK);
		weightField.setForeground(Color.BLACK);
		heightField.setForeground(Color.BLACK);
		firstNameField.setForeground(Color.BLACK);
		lastNameField.setForeground(Color.BLACK);
		yearField.setForeground(Color.BLACK);
		monthField.setForeground(Color.BLACK);
		dayField.setForeground(Color.BLACK);
	}

	private void clearFields() {
		maxRateField.setText("");
		averageRateField.setText("");
		totalDistanceField.setText("");
		exerciseNameField.setText("");
		totalDistanceField.setText("");
		yearE.setText("");
		monthE.setText("");
		dayE.setText("");
		exerciseDurationField.setText("");
	}

	private void clearUserFields() {
		userIDField2.setText("");
		weightField.setText("");
		heightField.setText("");
		firstNameField.setText("");
		lastNameField.setText("");
		yearField.setText("");
		monthField.setText("");
		dayField.setText("");
	}

	private void executeAdd() {
		btnAdd.doClick();
	}

	private void executeRemove() {
		btnRemove.doClick();
	}

	private void executeNew() {
		btnnewUser.doClick();
	}
}
