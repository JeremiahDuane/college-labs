import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class WindowExp extends JPanel {

	private JFrame frame;
	private JTextField resultText;
	private JTextField timeText;
	private JTextField popText;
	private JTextField rateText;

	public static double t;
	public static double k;
	public static double p;
	public boolean boolean1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowExp window = new WindowExp();
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
	public WindowExp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		ExponentialGrowth_P proc = new ExponentialGrowth_P();

		JFrame frame2 = new JFrame();
		frame2.setSize(900, 700);
		frame2.setTitle("Graph");
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setResizable(false);
		frame2.getContentPane().add(new ExponentialGrowth_P());
		frame2.setVisible(false);

		frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 620);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_3874572689487816");
		panel_1.setLayout(null);

		JLabel lblExponentialGrowthCalculator = new JLabel("Exponential Growth Calculator");
		lblExponentialGrowthCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblExponentialGrowthCalculator.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblExponentialGrowthCalculator.setBounds(12, 13, 656, 29);
		panel_1.add(lblExponentialGrowthCalculator);

		JLabel label_1 = new JLabel("Differential Equation");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(12, 74, 333, 25);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Standard Equation");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(335, 74, 333, 25);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("<html> P(t) = P<sub>0 </sub>e<sup>kt</sup> </html>");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 26));
		label_3.setBounds(12, 92, 323, 82);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("<html>X<sub>0 </sub>(1+r)<sup> t</sup> </html>");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 26));
		label_4.setBounds(335, 92, 333, 82);
		panel_1.add(label_4);

		JButton btnFull = new JButton("GRAPH DIFFERENTIAL");
		btnFull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				notMain();
			}
		});
		btnFull.setToolTipText("");
		btnFull.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFull.setBounds(30, 474, 272, 63);
		panel_1.add(btnFull);

		JButton button_1 = new JButton("COMPUTE DIFFERENTIAL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					double inputValue1 = Double.parseDouble(timeText.getText());
					proc.setTime(inputValue1);

					t = inputValue1;

					resultText.setText(String.valueOf(proc.getGrowth()));
				} catch (NumberFormatException e1) {

					timeText.setText("Required Field");
					timeText.setForeground(Color.RED);

				}

				try {

					double inputValue = Double.parseDouble(rateText.getText());
					proc.setRate(inputValue);
					k = inputValue;

					resultText.setText(String.valueOf(proc.getGrowth()));
				} catch (NumberFormatException e1) {

					rateText.setText("Required Field");
					rateText.setForeground(Color.RED);

				}
				try {

					double inputValue2 = Double.parseDouble(popText.getText());
					proc.setStart(inputValue2);
					p = inputValue2;

					resultText.setText(String.valueOf(proc.getGrowth()));
				} catch (NumberFormatException e1) {

					popText.setText("Required Field");
					popText.setForeground(Color.RED);
				}

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(30, 314, 272, 63);
		panel_1.add(button_1);

		JButton button_2 = new JButton("COMPUTE STANDARD");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double inputValue1 = Double.parseDouble(timeText.getText());
					proc.setTime(inputValue1);

					t = inputValue1;

					resultText.setText(String.valueOf(proc.getStandardGrowth()));
				} catch (NumberFormatException e1) {

					timeText.setText("Required Field");
					timeText.setForeground(Color.RED);

				}

				try {

					double inputValue = Double.parseDouble(rateText.getText());
					proc.setRate(inputValue);
					k = inputValue;

					resultText.setText(String.valueOf(proc.getStandardGrowth()));
				} catch (NumberFormatException e1) {

					rateText.setText("Required Field");
					rateText.setForeground(Color.RED);

				}
				try {

					double inputValue2 = Double.parseDouble(popText.getText());
					proc.setStart(inputValue2);
					p = inputValue2;

					resultText.setText(String.valueOf(proc.getStandardGrowth()));
				} catch (NumberFormatException e1) {

					popText.setText("Required Field");
					popText.setForeground(Color.RED);
				}

			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(368, 314, 272, 63);
		panel_1.add(button_2);

		JLabel label_5 = new JLabel("Result:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(86, 418, 62, 25);
		panel_1.add(label_5);

		resultText = new JTextField();
		resultText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultText.setColumns(10);
		resultText.setBounds(160, 415, 348, 31);
		panel_1.add(resultText);

		JLabel label_6 = new JLabel("Starting Population");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(464, 213, 176, 25);
		panel_1.add(label_6);

		JLabel lblGrowthRate = new JLabel("Growth Rate (%)");
		lblGrowthRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrowthRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrowthRate.setBounds(250, 213, 176, 25);
		panel_1.add(lblGrowthRate);

		JLabel label_8 = new JLabel("Time Units");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(30, 213, 176, 25);
		panel_1.add(label_8);

		timeText = new JTextField();
		timeText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				timeText.setText(null);
				timeText.setForeground(Color.BLACK);
			}
		});
		timeText.setForeground(Color.BLACK);
		timeText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeText.setColumns(10);
		timeText.setBounds(30, 252, 176, 31);
		panel_1.add(timeText);

		popText = new JTextField();
		popText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				popText.setText(null);
				popText.setForeground(Color.BLACK);
			}
		});
		popText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popText.setColumns(10);
		popText.setBounds(464, 251, 176, 31);
		panel_1.add(popText);

		rateText = new JTextField();
		rateText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				rateText.setText(null);
				rateText.setForeground(Color.BLACK);
			}
		});
		rateText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rateText.setColumns(10);
		rateText.setBounds(250, 252, 176, 31);
		panel_1.add(rateText);

		JSeparator separator = new JSeparator();
		separator.setBounds(55, 182, 247, 2);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(375, 182, 247, 2);
		panel_1.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(375, 55, 247, 2);
		panel_1.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(55, 55, 247, 2);
		panel_1.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(61, 55, -7, 100);
		panel_1.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(301, 55, 1, 125);
		panel_1.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.DARK_GRAY);
		separator_6.setBounds(22, 92, 1, 125);
		panel_1.add(separator_6);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("t");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean1 = true;
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(436, 504, 50, 33);
		panel_1.add(rdbtnNewRadioButton);

		JRadioButton rdbtnK = new JRadioButton("k");
		buttonGroup.add(rdbtnK);
		rdbtnK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		rdbtnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k = t;
			}
		});
		rdbtnK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnK.setBounds(517, 503, 50, 34);
		panel_1.add(rdbtnK);

		JLabel lblInRespectTo = new JLabel("In respect to variable:");
		lblInRespectTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInRespectTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInRespectTo.setBounds(368, 474, 272, 31);
		panel_1.add(lblInRespectTo);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_3874572710248162");
		panel.setLayout(null);

		JLabel lblGraph = new JLabel("Graph");
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGraph.setBounds(12, 0, 656, 57);
		panel.add(lblGraph);

	}

	private static final int PREF_W = 800;
	private static final int PREF_H = 650;
	private static final Color GRAPH_COLOR = Color.black;
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private final ButtonGroup buttonGroup = new ButtonGroup();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		g2.drawLine(0, 350, 1900, 350); // x-axis
		g2.drawLine(400, 0, 400, 1900); // y-axis

		g2.setColor(Color.red);

		for (double x = -2000; x <= 2000; x = x + 0.001) {
			double y = p * Math.pow(Math.E, (0.01) * k * x);
			int Y = (int) y;
			int X = (int) x;
			g.drawLine(400 + X, 350 - Y, 400 + X, 350 - Y);
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	private static void createAndShowGui() {

		WindowExp mainPanel = new WindowExp();

		JFrame frame = new JFrame("DrawGraph");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void notMain() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}
