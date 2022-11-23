package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import bp.Circuit;
import bp.ICircuit;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

public class Main {

	private JFrame frmRbgetstringcircuitcalc;
	private JTextField textVolt;
	private JTextField textAmp;
	ResourceBundle rb = ResourceBundle.getBundle("Bundle");
	private JTextField textField;
	private JButton btnNewButton;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JToggleButton o2;
	private JToggleButton o3;
	private JToggleButton button2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton o1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmRbgetstringcircuitcalc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmRbgetstringcircuitcalc = new JFrame();
		frmRbgetstringcircuitcalc.setTitle(rb.getString("CircuitCalc"));
		frmRbgetstringcircuitcalc.setResizable(false);
		frmRbgetstringcircuitcalc.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmRbgetstringcircuitcalc.setBounds(100, 100, 391, 511);
		frmRbgetstringcircuitcalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRbgetstringcircuitcalc.getContentPane().setLayout(null);
		ICircuit proc = new Circuit();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 385, 476);
		frmRbgetstringcircuitcalc.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JToggleButton button1 = new JToggleButton();
		button1.setSelected(true);
		buttonGroup.add(button1);
		button1.setBounds(10, 110, 21, 47);
		panel_1.add(button1);

		button2 = new JToggleButton();
		buttonGroup.add(button2);
		button2.setBounds(352, 110, 21, 47);
		panel_1.add(button2);
		frmRbgetstringcircuitcalc.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				button1.grabFocus();
				button1.requestFocus();
			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});

		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setFont(new Font("DialogInput", Font.PLAIN, 28));
		textField.setColumns(10);
		textField.setBounds(32, 26, 341, 75);
		panel_1.add(textField);

		JButton button = new JButton(rb.getString("CalcButton"));
		button.setBounds(164, 399, 209, 62);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((Double.parseDouble((textVolt.getText())) == 0 && o2.isSelected())
							|| (Double.parseDouble((textAmp.getText())) == 0) && o3.isSelected()) {
						textField.setText("Undefined");

					} else if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {

					} else if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
					} else {

						if (o1.isSelected()) {
							proc.setResistance(Double.parseDouble((textVolt.getText().replaceAll("[^\\d.]", ""))));
							proc.setAmperage(Double.parseDouble((textAmp.getText().replaceAll("[^\\d.]", ""))));
							proc.calculateVoltage();
							textField.setText(String.valueOf(proc.getVoltage()));

						} else if (o2.isSelected()) {
							proc.setVoltage(Double.parseDouble((textVolt.getText().replaceAll("[^\\d.]", ""))));
							proc.setResistance(Double.parseDouble((textAmp.getText().replaceAll("[^\\d.]", ""))));
							proc.calculateAmperage();
							textField.setText(String.valueOf(proc.getAmperage()));
							System.out.println("2");

						} else if (o3.isSelected()) {
							proc.setAmperage(Double.parseDouble((textAmp.getText().replaceAll("[^\\d.]", ""))));
							proc.setVoltage(Double.parseDouble((textVolt.getText().replaceAll("[^\\d.]", ""))));
							proc.calculateResistance();
							textField.setText(String.valueOf(proc.getResistance()));
							System.out.println("3");
						} else {

						}
						textAmp.setText(textAmp.getText().replaceAll("[^\\d.]", ""));
						textVolt.setText(textVolt.getText().replaceAll("[^\\d.]", ""));
					}
				} catch (NumberFormatException error) {

				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));

		btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "0");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "0");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 35));
		btnNewButton.setBounds(88, 399, 64, 62);
		panel_1.add(btnNewButton);

		button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "2");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "2");
				}
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 35));
		button_1.setBounds(88, 324, 64, 62);
		panel_1.add(button_1);

		button_2 = new JButton("5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "5");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "5");
				}
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 35));
		button_2.setBounds(88, 249, 64, 62);
		panel_1.add(button_2);

		button_3 = new JButton("8");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "8");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "8");
				}
			}
		});
		button_3.setFont(new Font("Arial", Font.BOLD, 35));
		button_3.setBounds(88, 174, 64, 62);
		panel_1.add(button_3);

		button_4 = new JButton("1");
		button_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "1");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "1");
				}
			}
		});
		button_4.setFont(new Font("Arial", Font.BOLD, 35));
		button_4.setBounds(10, 324, 64, 62);
		panel_1.add(button_4);

		button_5 = new JButton("4");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "4");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "4");
				}
			}
		});
		button_5.setFont(new Font("Arial", Font.BOLD, 35));
		button_5.setBounds(12, 249, 64, 62);
		panel_1.add(button_5);

		button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "7");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "7");
				}
			}
		});
		button_6.setFont(new Font("Arial", Font.BOLD, 35));
		button_6.setBounds(12, 174, 64, 62);
		panel_1.add(button_6);

		button_7 = new JButton("3");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "3");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "3");
				}
			}
		});
		button_7.setFont(new Font("Arial", Font.BOLD, 35));
		button_7.setBounds(164, 324, 64, 62);
		panel_1.add(button_7);

		button_8 = new JButton("6");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "6");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "6");
				}
			}

		});
		button_8.setFont(new Font("Arial", Font.BOLD, 35));
		button_8.setBounds(164, 249, 64, 62);
		panel_1.add(button_8);

		button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText() + "9");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText() + "9");
				}
			}
		});
		button_9.setFont(new Font("Arial", Font.BOLD, 35));
		button_9.setBounds(164, 174, 64, 62);
		panel_1.add(button_9);

		button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
					if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
						textAmp.setText("");
					}

					textAmp.setText(textAmp.getText().replaceAll("\\p{P}", "") + ".");
				} else if (button2.isSelected()) {
					if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
						textVolt.setText("");
					}

					textVolt.setText(textVolt.getText().replaceAll("\\p{P}", "") + ".");
				}

			}
		});
		button_10.setFont(new Font("Arial", Font.BOLD, 35));
		button_10.setBounds(12, 399, 64, 62);
		panel_1.add(button_10);

		o2 = new JToggleButton(rb.getString("VoltageLabel"));
		o2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		buttonGroup_1.add(o2);
		o2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVolt.setText((rb.getString("ResistanceLabel")));
				textAmp.setText((rb.getString("AmperageLabel")));
			}
		});
		o2.setFont(new Font("Arial", Font.BOLD, 20));
		o2.setBounds(240, 249, 133, 62);
		panel_1.add(o2);

		o3 = new JToggleButton(rb.getString("AmperageLabel"));
		buttonGroup_1.add(o3);
		o3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAmp.setText((rb.getString("ResistanceLabel")));
				textVolt.setText((rb.getString("VoltageLabel")));
			}
		});
		o3.setFont(new Font("Arial", Font.BOLD, 20));
		o3.setBounds(240, 324, 133, 62);
		panel_1.add(o3);

		o1 = new JToggleButton(rb.getString("ResistanceLabel"));
		o1.setSelected(true);
		buttonGroup_1.add(o1);
		o1.setFont(new Font("Arial", Font.BOLD, 18));
		o1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVolt.setText((rb.getString("VoltageLabel")));
				textAmp.setText((rb.getString("AmperageLabel")));
			}
		});
		o1.setBounds(240, 174, 133, 62);
		panel_1.add(o1);

		JButton Clear = new JButton("");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAmp.setText("");
				textVolt.setText("");
			}
		});
		Clear.setBounds(10, 26, 21, 75);
		panel_1.add(Clear);

		textAmp = new JTextField();
		textAmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
				if (key == KeyEvent.VK_ESCAPE) {
					Clear.doClick();
					textAmp.grabFocus();
					textAmp.requestFocus();
				}

				if (key == KeyEvent.VK_UP) {
					o2.doClick();
				}
				if (key == KeyEvent.VK_RIGHT) {
					o3.doClick();
				}
				if (key == KeyEvent.VK_LEFT) {
					o1.doClick();
				}
			}
		});
		textAmp.setFont(new Font("DialogInput", Font.PLAIN, 20));
		textAmp.setBackground(SystemColor.inactiveCaptionBorder);
		textAmp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				button1.setSelected(true);
				if (textAmp.getText().equals("Amperage") || textAmp.getText().equals("Resistance")) {
					textAmp.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textAmp.getText().length() == 0) {
					textAmp.setText((rb.getString("AmperageLabel")));
				} else {
					textAmp.setText(textAmp.getText().replaceAll("[^\\d.]", ""));
				}
			}
		});
		textAmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textAmp.setColumns(10);
		textAmp.setBounds(32, 110, 154, 47);
		panel_1.add(textAmp);

		textAmp.setText((rb.getString("AmperageLabel")));

		textVolt = new JTextField();
		textVolt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
				if (key == KeyEvent.VK_ESCAPE) {
					Clear.doClick();
					textAmp.grabFocus();
					textAmp.requestFocus();
				}

				if (key == KeyEvent.VK_UP) {
					o2.doClick();
				}
				if (key == KeyEvent.VK_RIGHT) {
					o3.doClick();
				}
				if (key == KeyEvent.VK_LEFT) {
					o1.doClick();
				}

			}
		});
		textVolt.setFont(new Font("DialogInput", Font.PLAIN, 20));
		textVolt.setBackground(SystemColor.inactiveCaptionBorder);
		textVolt.setFocusable(true);
		textVolt.requestFocusInWindow();
		textVolt.requestFocus(true);
		textVolt.requestFocus();
		textVolt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				button2.setSelected(true);
				if (textVolt.getText().equals("Voltage") || textVolt.getText().equals("Resistance")) {
					textVolt.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textVolt.getText().length() == 0) {
					textVolt.setText((rb.getString("VoltageLabel")));
				} else {
					textVolt.setText(textVolt.getText().replaceAll("[^\\d.]", ""));
				}
			}
		});
		textVolt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textVolt.setBounds(196, 110, 154, 47);
		panel_1.add(textVolt);
		textVolt.setColumns(10);

		textVolt.setText((rb.getString("VoltageLabel")));
		
		comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 385, 22);
		panel_1.add(comboBox);
		comboBox.addItem("Program Info");
		comboBox.addItem((rb.getString("ProgramInfo")));
		comboBox.addItem((rb.getString("ProgramInfo2")));
		comboBox.addItem(" ");
		comboBox.addItem((rb.getString("ProgramInfo_1")));
		comboBox.addItem((rb.getString("ProgramInfo3")));
		comboBox.addItem((rb.getString("ProgramInfo4")));
		comboBox.addItem((rb.getString("ProgramInfo5")));
		comboBox.addItem((rb.getString("ProgramInfo6")));
	}

}
