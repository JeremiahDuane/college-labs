package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bp.Database;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class ManualThreadingGUI {
	private JLabel lblDatabaseQueryTool = new JLabel("Database Query Tool");
	private Database db = new Database();
	private Thread myThread = new Thread(db);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManualThreadingGUI window = new ManualThreadingGUI();
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
	public ManualThreadingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea txtSql = new JTextArea();
		txtSql.setText("SELECT *\r\nFROM Toy\r\n");
		frame.getContentPane().add(txtSql, BorderLayout.CENTER);

		
		frame.getContentPane().add(lblDatabaseQueryTool, BorderLayout.NORTH);

		JButton btnPushMe = new JButton("PUSH ME");
		btnPushMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				lblDatabaseQueryTool.setText("I am thinking");
				db.setSqlToExecute(txtSql.getText());
				myThread.start();
				Hound myHound = new Hound();
				Thread threadHound = new Thread(myHound);
				threadHound.start();
			}
		});
		frame.getContentPane().add(btnPushMe, BorderLayout.SOUTH);
	}

	private class Hound implements Runnable {

		@Override
		public void run() {
			try {
				myThread.join();
				lblDatabaseQueryTool.setText("Database Query Tool");
				JOptionPane.showMessageDialog(null, db.getResult());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
