package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import bp.Circuit;
import bp.Toy;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Window {

	Toy myToy = new Toy();

	Circuit cir = new Circuit();
	Circuit cir2 = new Circuit();
	private JFrame frmToyInspectionSystem;
	private JFrame frame2;
	private JTextField voltText;
	private JTextField resText;
	private JTextField inspectorText;
	private JTextField toyText;
	private JTextField dateText;
	private JLabel lblToyId;
	private JLabel lblDatetime;
	private JLabel lblVoltage;
	private JLabel lblResistance;
	private JLabel lblMfgLocation;
	private JLabel lblToyInspection;
	private JTextField voltText2;
	private JTextField resText2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmToyInspectionSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmToyInspectionSystem = new JFrame();
		frmToyInspectionSystem.setTitle("Toy Inspection System");
		frmToyInspectionSystem.setResizable(false);
		frmToyInspectionSystem.setBounds(100, 100, 816, 564);
		frmToyInspectionSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmToyInspectionSystem.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(59, 257, 289, 2);
		frmToyInspectionSystem.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(445, 257, 289, 2);
		frmToyInspectionSystem.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(59, 412, 289, 2);
		frmToyInspectionSystem.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(445, 412, 289, 2);
		frmToyInspectionSystem.getContentPane().add(separator_4);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 106, 820, 2);
		frmToyInspectionSystem.getContentPane().add(separator);

		voltText = new JTextField();
		voltText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_DECIMAL) {
					voltText.setText(voltText.getText().replaceAll("\\p{P}", ""));
				}
			}
		});
		voltText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				voltText.setText("");
				voltText.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				voltText.setText(voltText.getText().replaceAll("[^\\d.]", ""));
			}
		});
		voltText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		voltText.setColumns(10);
		voltText.setBounds(178, 272, 170, 22);
		frmToyInspectionSystem.getContentPane().add(voltText);

		resText = new JTextField();
		resText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_DECIMAL) {
					resText.setText(resText.getText().replaceAll("\\p{P}", ""));
				}
			}
		});
		resText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				resText.setText("");
				resText.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				resText.setText(resText.getText().replaceAll("[^\\d.]", ""));
			}
		});
		resText.setColumns(10);
		resText.setBounds(209, 325, 139, 22);
		frmToyInspectionSystem.getContentPane().add(resText);

		inspectorText = new JTextField();
		inspectorText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				inspectorText.setText("");
				inspectorText.setForeground(Color.black);
			}
		});
		inspectorText.setColumns(10);
		inspectorText.setBounds(286, 135, 262, 22);
		frmToyInspectionSystem.getContentPane().add(inspectorText);

		toyText = new JTextField();
		toyText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				toyText.setText(toyText.getText().replaceAll("[^\\d.]", ""));
			}

			@Override
			public void focusGained(FocusEvent e) {
				toyText.setText("");
				toyText.setForeground(Color.black);
			}
		});
		toyText.setColumns(10);
		toyText.setBounds(286, 166, 262, 22);
		frmToyInspectionSystem.getContentPane().add(toyText);

		dateText = new JTextField();
		dateText.setBackground(Color.WHITE);
		dateText.setEditable(false);
		dateText.setForeground(Color.GRAY);
		dateText.setText("<calculated>");
		dateText.setColumns(10);
		dateText.setBounds(286, 201, 262, 22);
		frmToyInspectionSystem.getContentPane().add(dateText);

		JLabel lblNewLabel = new JLabel("Inspector");
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblNewLabel.setBounds(151, 134, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblNewLabel);

		lblToyId = new JLabel("Toy I.D.");
		lblToyId.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblToyId.setBounds(151, 169, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblToyId);

		lblDatetime = new JLabel("Date/Time");
		lblDatetime.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblDatetime.setBounds(151, 204, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblDatetime);

		lblVoltage = new JLabel("Voltage:");
		lblVoltage.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblVoltage.setBounds(59, 275, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblVoltage);

		lblResistance = new JLabel("Resistance:");
		lblResistance.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblResistance.setBounds(59, 328, 139, 19);
		frmToyInspectionSystem.getContentPane().add(lblResistance);

		lblMfgLocation = new JLabel("Mfg. Location");
		lblMfgLocation.setFont(new Font("DialogInput", Font.PLAIN, 18));
		lblMfgLocation.setBounds(59, 380, 148, 19);
		frmToyInspectionSystem.getContentPane().add(lblMfgLocation);

		lblToyInspection = new JLabel("Toy Inspection");
		lblToyInspection.setHorizontalAlignment(SwingConstants.CENTER);
		lblToyInspection.setFont(new Font("DialogInput", Font.BOLD, 30));
		lblToyInspection.setBounds(59, 13, 675, 95);
		frmToyInspectionSystem.getContentPane().add(lblToyInspection);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(595, 377, 139, 22);
		frmToyInspectionSystem.getContentPane().add(comboBox_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "United States", "Germany", "China" }));
		comboBox.setBounds(209, 377, 139, 22);
		frmToyInspectionSystem.getContentPane().add(comboBox);

		comboBox_1.addItem("United States");
		comboBox_1.addItem("Germany");
		comboBox_1.addItem("China");

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int n = 1;
					resText2.setForeground(Color.BLACK);
					voltText2.setForeground(Color.BLACK);
					voltText.setForeground(Color.BLACK);
					resText.setForeground(Color.BLACK);
					toyText.setForeground(Color.BLACK);
					inspectorText.setForeground(Color.BLACK);
				
					btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					myToy.setInspector(inspectorText.getText());
					myToy.setToyID(Integer.parseInt(toyText.getText()));
					myToy.getCircuit1().setVoltage(Double.parseDouble(voltText.getText()));
					myToy.getCircuit1().setResistance(Double.parseDouble(resText.getText()));
					myToy.getCircuit1().setToyID(Integer.parseInt(toyText.getText()));
					myToy.getCircuit1().calculateAmperage();
					myToy.getCircuit1().setCircuitID(n);
					myToy.getCircuit1().setManufactureLocation((String.valueOf(comboBox.getSelectedItem())));
					myToy.getCircuit2().setVoltage(Double.parseDouble(voltText2.getText()));
					myToy.getCircuit2().setToyID(Integer.parseInt(toyText.getText()));
					myToy.getCircuit2().setResistance(Double.parseDouble(resText2.getText()));
					myToy.getCircuit2().setManufactureLocation((String.valueOf(comboBox_1.getSelectedItem())));
					myToy.getCircuit2().calculateAmperage();
					myToy.setInspectionDateTime(null);
					myToy.getCircuit2().setCircuitID(n + 1);

					cir.setToyID(Integer.parseInt(toyText.getText()));
					cir.calculateAmperage();
					cir.setCircuitID(n);
					cir.setManufactureLocation((String.valueOf(comboBox.getSelectedItem())));
					cir.setVoltage(Double.parseDouble(voltText2.getText()));
					cir.setResistance(Double.parseDouble(resText2.getText()));
					cir.setManufactureLocation((String.valueOf(comboBox_1.getSelectedItem())));
					cir.calculateAmperage();
					cir.setCircuitID(n + 1);

					myToy.save();
				
				} catch (NumberFormatException n) {
					btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					StringBuilder error = new StringBuilder();
					error.append("\nError:");
					error.append("\nSome required fields are \nstill empty.");

					if (voltText2.getText().replaceAll("[^\\d.]", "").length() == 0) {
						voltText2.setForeground(Color.RED);
						voltText2.setText("//REQUIRED");
					}
					if (voltText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						voltText.setForeground(Color.RED);
						voltText.setText("//REQUIRED");
					}
					if (resText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						resText.setForeground(Color.RED);
						resText.setText("//REQUIRED");
					}
					if (resText2.getText().replaceAll("[^\\d.]", "").length() == 0) {
						resText2.setForeground(Color.RED);
						resText2.setText("//REQUIRED");
					}
					if (toyText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						toyText.setForeground(Color.RED);
						toyText.setText("//REQUIRED");
					}
					if (inspectorText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						inspectorText.setForeground(Color.RED);
						inspectorText.setText("//REQUIRED");
					}
					
					JOptionPane.showMessageDialog(null, error);

				}
				btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnSave.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnSave.setBounds(59, 461, 139, 38);
		frmToyInspectionSystem.getContentPane().add(btnSave);

		JLabel lblCircuit = new JLabel("Circuit 1");
		lblCircuit.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblCircuit.setBounds(59, 415, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblCircuit);

		JLabel lblCircuit_1 = new JLabel("Circuit 2");
		lblCircuit_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCircuit_1.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblCircuit_1.setBounds(611, 419, 123, 19);
		frmToyInspectionSystem.getContentPane().add(lblCircuit_1);

		voltText2 = new JTextField();
		voltText2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_DECIMAL) {
					voltText2.setText(voltText2.getText().replaceAll("\\p{P}", ""));
				}
			}
		});
		voltText2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				voltText2.setForeground(Color.BLACK);
				voltText2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				voltText2.setText(voltText2.getText().replaceAll("[^\\d.]", ""));
			}
		});
		voltText2.setColumns(10);
		voltText2.setBounds(564, 272, 170, 22);
		frmToyInspectionSystem.getContentPane().add(voltText2);

		resText2 = new JTextField();
		resText2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_PERIOD || key == KeyEvent.VK_DECIMAL) {
					resText2.setText(resText2.getText().replaceAll("\\p{P}", ""));
				}
			}
		});
		resText2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				resText2.setForeground(Color.BLACK);
				resText2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				resText2.setText(resText2.getText().replaceAll("[^\\d.]", ""));
			}
		});
		resText2.setColumns(10);
		resText2.setBounds(595, 325, 139, 22);
		frmToyInspectionSystem.getContentPane().add(resText2);

		JLabel label_2 = new JLabel("Voltage:");
		label_2.setFont(new Font("DialogInput", Font.PLAIN, 20));
		label_2.setBounds(445, 275, 123, 19);
		frmToyInspectionSystem.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Resistance:");
		label_3.setFont(new Font("DialogInput", Font.PLAIN, 20));
		label_3.setBounds(445, 328, 139, 19);
		frmToyInspectionSystem.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Mfg. Location");
		label_4.setFont(new Font("DialogInput", Font.PLAIN, 18));
		label_4.setBounds(445, 380, 148, 19);
		frmToyInspectionSystem.getContentPane().add(label_4);

		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnLoad.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					voltText2.setText("");
					resText2.setText("");
					voltText.setText("");
					resText.setText("");
	
					resText2.setForeground(Color.BLACK);
					voltText2.setForeground(Color.BLACK);
					voltText.setForeground(Color.BLACK);
					resText.setForeground(Color.BLACK);
					toyText.setForeground(Color.BLACK);
					inspectorText.setForeground(Color.BLACK);
				
					myToy.load(Integer.parseInt(toyText.getText()));

					inspectorText.setText(myToy.getInspector());
					dateText.setText(myToy.getInspectionDateTime().toString());
					voltText.setText(String.valueOf(myToy.getCircuit1().getVoltage()));
					resText.setText(String.valueOf(myToy.getCircuit1().getResistance()));
					comboBox.setSelectedItem(myToy.getCircuit1().getManufactureLocation());
					comboBox_1.setSelectedItem(myToy.getCircuit2().getManufactureLocation());
					voltText2.setText(String.valueOf(myToy.getCircuit2().getVoltage()));
					resText2.setText(String.valueOf(myToy.getCircuit2().getResistance()));

				} catch (NullPointerException n) {
					StringBuilder error = new StringBuilder();
					error.append("\nError:");
					error.append("\nToy #" + toyText.getText() + " does not exist.");

					JOptionPane.showMessageDialog(null, error);
				} catch (NumberFormatException n) {

					StringBuilder error = new StringBuilder();
					error.append("\nError:");
					error.append("\nSome required fields are \nstill empty.");

					if (toyText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						toyText.setForeground(Color.RED);
						toyText.setText("//REQUIRED");
					}
					
					JOptionPane.showMessageDialog(null, error);

				}
				btnLoad.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnLoad.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnLoad.setBounds(238, 461, 139, 38);
		frmToyInspectionSystem.getContentPane().add(btnLoad);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					int n = 1;
					myToy.delete();
					myToy.setToyID(0);
					myToy.setInspector("");
					myToy.setInspectionDateTime(null);
					myToy.getCircuit1().setVoltage(0);
					myToy.getCircuit1().setResistance(0);
					myToy.getCircuit1().setToyID(0);
					myToy.getCircuit1().calculateAmperage();
					myToy.getCircuit1().setCircuitID(n);
					myToy.getCircuit2().setVoltage(0);
					myToy.getCircuit2().setToyID(0);
					myToy.getCircuit2().setResistance(0);
					myToy.getCircuit2().calculateAmperage();
					myToy.setInspectionDateTime(null);
					myToy.getCircuit2().setCircuitID(0);
					cir.setToyID(0);
					cir.calculateAmperage();
					cir.setCircuitID(n);
					cir.setVoltage(0);
					cir.setResistance(0);
					comboBox.setSelectedItem("United States");
					comboBox_1.setSelectedItem("United States");
					
					voltText2.setText("");
					resText2.setText("");
					voltText.setText("");
					resText.setText("");
					toyText.setText("");
					dateText.setText("<calculated>");
					resText2.setForeground(Color.BLACK);
					voltText2.setForeground(Color.BLACK);
					voltText.setForeground(Color.BLACK);
					resText.setForeground(Color.BLACK);
					toyText.setForeground(Color.BLACK);
					inspectorText.setForeground(Color.BLACK);
				
				} catch (NumberFormatException n) {

					StringBuilder error = new StringBuilder();
					error.append("\nError:");
					error.append("\nSome required fields are \nstill empty.");


					if (voltText2.getText().replaceAll("[^\\d.]", "").length() == 0) {
						voltText2.setForeground(Color.RED);
						voltText2.setText("//REQUIRED");
					}
					if (voltText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						voltText.setForeground(Color.RED);
						voltText.setText("//REQUIRED");
					}
					if (resText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						resText.setForeground(Color.RED);
						resText.setText("//REQUIRED");
					}
					if (resText2.getText().replaceAll("[^\\d.]", "").length() == 0) {
						resText2.setForeground(Color.RED);
						resText2.setText("//REQUIRED");
					}
					if (toyText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						toyText.setForeground(Color.RED);
						toyText.setText("//REQUIRED");
					}
					if (inspectorText.getText().replaceAll("[^\\d.]", "").length() == 0) {
						inspectorText.setForeground(Color.RED);
						inspectorText.setText("//REQUIRED");
					}
					JOptionPane.showMessageDialog(null, error);

				}
				btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

		});
		btnDelete.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnDelete.setBounds(420, 461, 139, 38);
		frmToyInspectionSystem.getContentPane().add(btnDelete);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				int n = 1;
				myToy.setToyID(0);
				myToy.setInspector("");
				myToy.setInspectionDateTime(null);
				myToy.getCircuit1().setVoltage(0);
				myToy.getCircuit1().setResistance(0);
				myToy.getCircuit1().setToyID(0);
				myToy.getCircuit1().setCircuitID(n);
				myToy.getCircuit2().setVoltage(0);
				myToy.getCircuit2().setToyID(0);
				myToy.getCircuit2().setResistance(0);
				myToy.getCircuit2().calculateAmperage();
				myToy.setInspectionDateTime(null);
				myToy.getCircuit2().setCircuitID(0);
				cir.setToyID(0);
				cir.calculateAmperage();
				cir.setCircuitID(n);
				cir.setVoltage(0);
				cir.setResistance(0);
				comboBox.setSelectedItem("United States");
				comboBox_1.setSelectedItem("United States");
				
				voltText2.setText("");
				resText2.setText("");
				voltText.setText("");
				resText.setText("");
				toyText.setText("");
				
				resText2.setForeground(Color.BLACK);
				voltText2.setForeground(Color.BLACK);
				voltText.setForeground(Color.BLACK);
				resText.setForeground(Color.BLACK);
				toyText.setForeground(Color.BLACK);
				inspectorText.setForeground(Color.BLACK);
			
				btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnClear.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnClear.setBounds(595, 461, 139, 38);
		frmToyInspectionSystem.getContentPane().add(btnClear);
		
		JButton btnInfo = new JButton("");
		btnInfo.setFocusable(false);
		btnInfo.setBackground(Color.LIGHT_GRAY);
		btnInfo.setBorderPainted(false);
		btnInfo.setOpaque(false);
		btnInfo.setBorder(null);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder info = new StringBuilder();
				info.append("<html><h1>Program Information</h1> "
						+ "<p>This program allows data entry on the Talking Salesman toy for quality control purposes. "
						+ "<br> (All information is the property of Buchan Berkstresser Enterprises. "
						+ "Only authorized <br> employees may use this form.)</p></html>");
				
				JOptionPane.showMessageDialog(null, info);
			}
		});
		btnInfo.setPreferredSize(new Dimension(50, 50));
		btnInfo.setSize(new Dimension(50, 50));
		btnInfo.setIcon(new ImageIcon(Window.class.getResource("/bp/settings.png")));
		btnInfo.setBounds(746, 13, 50, 50);
		frmToyInspectionSystem.getContentPane().add(btnInfo);

	}
}
