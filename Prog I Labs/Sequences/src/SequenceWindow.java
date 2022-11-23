import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class SequenceWindow {

	private JFrame frmPadovianSequence;
	public String i, j, x, y, boundsA, boundsB, boundsCa, boundsCb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField var1Text;
	private JTextField var2Text;
	private JTextField varN;
	private JTextField resultText;
	private JTextField var3Text;
	private JTextField var5Text;
	private JTextField var4Text;
	private JTextField var6Text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SequenceWindow window = new SequenceWindow();
					window.frmPadovianSequence.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SequenceWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Proc proc = new Proc();

		frmPadovianSequence = new JFrame();
		frmPadovianSequence.setTitle("Sequence Calculator");
		frmPadovianSequence.setBounds(100, 100, 534, 429);
		frmPadovianSequence.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPadovianSequence.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frmPadovianSequence.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel2 = new JPanel();
		frmPadovianSequence.getContentPane().add(panel2, "name_269056309252693");
		panel.setLayout(null);

		JLabel label = new JLabel("<html> P<sub>n</sub> = P<sub>n-1</sub> + P<sub>n-2</sub> </html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.ITALIC, 30));
		label.setBounds(12, 58, 493, 75);
		panel.add(label);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fibonacci Sequence");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i = "-1";
				j = "-2";
				label.setText("<html> P<sub>n</sub> = P<sub>n" + i + "</sub> + P<sub>n" + j + "</sub> </html>");
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(55, 142, 203, 33);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnPadovianSequence = new JRadioButton("Padovian Sequence");
		rdbtnPadovianSequence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = "-2";
				j = "-3";
				label.setText("<html> P<sub>n</sub> = P<sub>n" + i + "</sub> + P<sub>n" + j + "</sub> </html>");
			}
		});
		buttonGroup.add(rdbtnPadovianSequence);
		rdbtnPadovianSequence.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPadovianSequence.setBounds(262, 142, 201, 33);
		panel.add(rdbtnPadovianSequence);

		var1Text = new JTextField();
		var1Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var1Text.setForeground(Color.BLACK);
				var1Text.setText(null);
			}
		});
		panel2.setLayout(null);
		var1Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var1Text.setBounds(60, 131, 176, 31);
		panel2.add(var1Text);
		var1Text.setColumns(10);

		var2Text = new JTextField();
		var2Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var2Text.setForeground(Color.BLACK);
				var2Text.setText(null);
			}
		});
		var2Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var2Text.setColumns(10);
		var2Text.setBounds(299, 131, 176, 31);
		panel2.add(var2Text);

		JLabel label_1 = new JLabel("<html> P<sub>n</sub> = P<sub>n+x</sub> + P<sub>n+y</sub> </html>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		label_1.setBounds(12, 23, 493, 75);
		panel2.add(label_1);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 111, 445, 4);
		panel2.add(separator_4);

		JLabel lblX = new JLabel("x:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setBounds(40, 132, 17, 28);
		panel2.add(lblX);

		JLabel lblY = new JLabel("y:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblY.setBounds(281, 131, 17, 28);
		panel2.add(lblY);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(30, 187, 445, 4);
		panel2.add(separator_5);

		JLabel lblPaC = new JLabel("<html> P<sub>a</sub> = C </html>");
		lblPaC.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaC.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblPaC.setBounds(12, 190, 256, 75);
		panel2.add(lblPaC);

		JLabel lblPbC = new JLabel("<html> P<sub>b</sub> = C </html>");
		lblPbC.setHorizontalAlignment(SwingConstants.CENTER);
		lblPbC.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblPbC.setBounds(249, 190, 256, 75);
		panel2.add(lblPbC);

		var3Text = new JTextField();
		var3Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var3Text.setForeground(Color.BLACK);
				var3Text.setText(null);
			}
		});
		var3Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var3Text.setColumns(10);
		var3Text.setBounds(60, 255, 176, 31);
		panel2.add(var3Text);

		var5Text = new JTextField();
		var5Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var5Text.setForeground(Color.BLACK);
				var5Text.setText(null);
			}
		});
		var5Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var5Text.setColumns(10);
		var5Text.setBounds(299, 255, 176, 31);
		panel2.add(var5Text);

		JLabel lblA = new JLabel("a:");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(12, 256, 45, 28);
		panel2.add(lblA);

		JLabel lblB = new JLabel("b:");
		lblB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB.setBounds(280, 255, 18, 28);
		panel2.add(lblB);

		var4Text = new JTextField();
		var4Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var4Text.setForeground(Color.BLACK);
				var4Text.setText(null);
			}
		});
		var4Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var4Text.setColumns(10);
		var4Text.setBounds(60, 306, 176, 31);
		panel2.add(var4Text);

		var6Text = new JTextField();
		var6Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				var6Text.setForeground(Color.BLACK);
				var6Text.setText(null);
			}
		});
		var6Text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		var6Text.setColumns(10);
		var6Text.setBounds(299, 306, 176, 31);
		panel2.add(var6Text);

		JLabel lblC = new JLabel("C:");
		lblC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setBounds(30, 307, 27, 28);
		panel2.add(lblC);

		JLabel lblC_1 = new JLabel("C:");
		lblC_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblC_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC_1.setBounds(264, 306, 34, 28);
		panel2.add(lblC_1);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(40, 350, 445, 4);
		panel2.add(separator_7);

		JButton btnSaveValues = new JButton("Save Values\r\n");
		btnSaveValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel2.setVisible(false);
			}
		});
		btnSaveValues.setForeground(Color.BLACK);
		btnSaveValues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaveValues.setBounds(50, 367, 425, 45);
		panel2.add(btnSaveValues);

		JSeparator separator = new JSeparator();
		separator.setBounds(228, 112, 0, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(233, 112, 0, 2);
		panel.add(separator_1);

		JLabel lblSequenceCalculator = new JLabel("Sequence Calculator");
		lblSequenceCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblSequenceCalculator.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSequenceCalculator.setBounds(12, 13, 493, 32);
		panel.add(lblSequenceCalculator);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(249, 149, 0, 2);
		panel.add(separator_2);

		varN = new JTextField();
		varN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				varN.setForeground(Color.BLACK);
				varN.setText(null);
			}
		});
		varN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		varN.setColumns(10);
		varN.setBounds(55, 237, 176, 31);
		panel.add(varN);

		JLabel lblNthTerm = new JLabel("<html>N<sup>th</sup> Term (0-based)</html>");
		lblNthTerm.setHorizontalAlignment(SwingConstants.CENTER);
		lblNthTerm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNthTerm.setBounds(55, 199, 173, 30);
		panel.add(lblNthTerm);

		JButton btnNewButton = new JButton("COMPUTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (rdbtnPadovianSequence.isSelected()) {
						resultText.setText(String.valueOf(proc.getP(Double.parseDouble(varN.getText()))));
					}
					if (rdbtnNewRadioButton.isSelected()) {
						resultText.setText(String.valueOf(proc.getF(Double.parseDouble(varN.getText()))));
					}
				} catch (NumberFormatException Err) {
					varN.setForeground(Color.RED);
					varN.setText("REQUIRED");
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(55, 305, 408, 62);
		panel.add(btnNewButton);

		resultText = new JTextField();
		resultText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultText.setColumns(10);
		resultText.setBounds(287, 237, 176, 31);
		panel.add(resultText);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResult.setBounds(343, 207, 54, 22);
		panel.add(lblResult);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(55, 184, 408, 10);
		panel.add(separator_3);

	}
}
