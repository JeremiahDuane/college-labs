package gui.controller;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import bp.Circuit;
import bp.Toy;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 *Class Control controls the methods of the gui. The transition between bp and gui. 
 */
public class Controller {
	/**
	 *Creates new instance of toy class.
	 */
	private Toy myToy = new Toy();
	/**
	 *Creates new instance of circuit class. 
	 */
	private Circuit cir = new Circuit();
	/**
	 *Creates new instance of circuit class.
	 */
	private Circuit cir2 = new Circuit();
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtIns;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtToyID;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtDate;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtVolt1;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtVolt2;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtRes1;
	/**
	 *Creates text field. 
	 */
	@FXML
	private TextField txtRes2;
	/**
	 *Creates combo box. 
	 */
	@FXML
	private ComboBox<String> cmbMf1;
	/**
	 *Creates combo box. 
	 */
	@FXML
	private ComboBox<String> cmbMf2;
	/**
	 * Handles the focus-gained action. 
	 */
	@FXML
	void focusGained() {
		txtVolt2.setStyle("-fx-text-inner-color: black;"); 
		txtVolt2.setText("");
	}
	
	/**
	 * Handles the save action. 
	 */
	@FXML
	void handleSave() {
	
		try {
			myToy.setInspector(txtIns.getText());
			myToy.setToyID(Integer.parseInt(txtToyID.getText()));
			myToy.getCircuit1().setVoltage(Double.parseDouble(txtVolt1.getText()));
			myToy.getCircuit1().setResistance(Double.parseDouble(txtRes1.getText()));
			myToy.getCircuit1().setToyID(Integer.parseInt(txtToyID.getText()));
			myToy.getCircuit1().calculateAmperage();
			myToy.getCircuit1().setCircuitID(1);
			myToy.getCircuit1().setManufactureLocation((cmbMf1.getValue()));
			myToy.getCircuit2().setVoltage(Double.parseDouble(txtVolt2.getText()));
			myToy.getCircuit2().setToyID(Integer.parseInt(txtToyID.getText()));
			myToy.getCircuit2().setResistance(Double.parseDouble(txtRes2.getText()));
			myToy.getCircuit2().setManufactureLocation(cmbMf2.getValue());
			myToy.getCircuit2().calculateAmperage();
			myToy.setInspectionDateTime(LocalDateTime.now());
			myToy.getCircuit2().setCircuitID(2);

			cir.setToyID(Integer.parseInt(txtToyID.getText()));
			cir.calculateAmperage();
			cir.setCircuitID(1);
			cir.setManufactureLocation(cmbMf2.getValue());
			cir.setVoltage(Double.parseDouble(txtVolt2.getText()));
			cir.setResistance(Double.parseDouble(txtRes2.getText()));
			cir.setManufactureLocation(cmbMf1.getValue());
			cir.calculateAmperage();
			cir.setCircuitID(2);

 			myToy.save();
		
		} catch (NumberFormatException n) {
			StringBuilder error = new StringBuilder();
			error.append("\nError:");
			error.append("\nSome required fields are still empty.\n All Fields are required to save.");

//			if (txtVolt2.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtVolt2.setStyle("-fx-text-inner-color: red;"); 
//				txtVolt2.setText("//REQUIRED");
//			}
//			if (txtVolt1.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtVolt1.setStyle("-fx-text-inner-color: red;");
//				txtVolt1.setText("//REQUIRED");
//			}
//			if (txtRes1.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtRes1.setStyle("-fx-text-inner-color: red;");
//				txtRes1.setText("//REQUIRED");
//			}
//			if (txtRes2.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtRes2.setStyle("-fx-text-inner-color: red;");
//				txtRes2.setText("//REQUIRED");
//			}
//			if (txtToyID.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtToyID.setStyle("-fx-text-inner-color: red;");
//				txtToyID.setText("//REQUIRED");
//			}
//			if (txtIns.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtIns.setStyle("-fx-text-inner-color: red;");
//				txtIns.setText("//REQUIRED");
//			}
//			
			JOptionPane.showMessageDialog(null, error);
		}
	}
	/**
	 * Handles the load action. 
	 */
	@FXML
	void handleLoad() {
		try {
			
			txtVolt2.setText("");
			txtRes2.setText("");
			txtVolt1.setText("");
			txtRes1.setText("");

			txtRes2.setStyle("-fx-text-inner-color: black;");
			txtVolt2.setStyle("-fx-text-inner-color: black;");
			txtVolt1.setStyle("-fx-text-inner-color: black;");
			txtRes1.setStyle("-fx-text-inner-color: black;");
			txtToyID.setStyle("-fx-text-inner-color: black;");
			txtIns.setStyle("-fx-text-inner-color: black;");
		
			myToy.load(Integer.parseInt(txtToyID.getText()));

			txtIns.setText(myToy.getInspector());
			txtDate.setText(myToy.getInspectionDateTime().toString());
			txtVolt1.setText(String.valueOf(myToy.getCircuit1().getVoltage()));
			txtRes1.setText(String.valueOf(myToy.getCircuit1().getResistance()));
			cmbMf1.setValue(myToy.getCircuit1().getManufactureLocation());
			cmbMf2.setValue(myToy.getCircuit2().getManufactureLocation());
			txtVolt2.setText(String.valueOf(myToy.getCircuit2().getVoltage()));
			txtRes2.setText(String.valueOf(myToy.getCircuit2().getResistance()));

		} catch (NullPointerException n) {
			StringBuilder error = new StringBuilder();
			error.append("\nError:");
			error.append("\nToy #" + txtToyID.getText() + " does not exist.");

			JOptionPane.showMessageDialog(null, error);
		} catch (NumberFormatException n) {

			StringBuilder error = new StringBuilder();
			error.append("\nError:");
			error.append("\nThe 'Toy ID' field must not be empty.");

//			if (txtToyID.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtToyID.setStyle("-fx-text-inner-color: red;");
//				txtToyID.setText("//REQUIRED");
//			}
			
			JOptionPane.showMessageDialog(null, error);

		}
	}
	/**
	 * Handles the clear action. 
	 */
	@FXML
	void handleClear() {
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
		cmbMf1.setValue("United States");
		cmbMf2.setValue("United States");
		
		txtVolt2.setText("");
		txtRes2.setText("");
		txtVolt1.setText("");
		txtRes1.setText("");
		txtToyID.setText("");
		txtDate.setText("<calculated>");
		txtRes2.setStyle("-fx-text-inner-color: black;");
		txtVolt2.setStyle("-fx-text-inner-color: black;");
		txtVolt1.setStyle("-fx-text-inner-color: black;");
		txtRes1.setStyle("-fx-text-inner-color: black;");
		txtToyID.setStyle("-fx-text-inner-color: black;");
		txtIns.setStyle("-fx-text-inner-color: black;");
	}
	/**
	 * Handles the delete action. 
	 */
	@FXML
	void handleDelete() {
		try {
			myToy.setToyID(Integer.parseInt(txtToyID.getText()));
			int n = 1;
			txtDate.setText("<calculated>");
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
			cmbMf1.setValue("United States");
			cmbMf2.setValue("United States");
			
			txtVolt2.setText("");
			txtRes2.setText("");
			txtVolt1.setText("");
			txtRes1.setText("");
			txtToyID.setText("");
			txtDate.setText("<calculated>");
			txtRes2.setStyle("-fx-text-inner-color: black;");
			txtVolt2.setStyle("-fx-text-inner-color: black;");
			txtVolt1.setStyle("-fx-text-inner-color: black;");
			txtRes1.setStyle("-fx-text-inner-color: black;");
			txtToyID.setStyle("-fx-text-inner-color: black;");
			txtIns.setStyle("-fx-text-inner-color: black;");
		
		} catch (NumberFormatException n) {

			StringBuilder error = new StringBuilder();
			error.append("\nError:");
			error.append("\nThe 'Toy ID' field must not be empty.");

//
//			if (txtVolt2.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtVolt2.setStyle("-fx-text-inner-color: red;");
//				txtVolt2.setText("//REQUIRED");
//			}
//			if (txtVolt1.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtVolt1.setStyle("-fx-text-inner-color: red;");
//				txtVolt1.setText("//REQUIRED");
//			}
//			if (txtRes1.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtRes1.setStyle("-fx-text-inner-color: red;");
//				txtRes1.setText("//REQUIRED");
//			}
//			if (txtRes2.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtRes2.setStyle("-fx-text-inner-color: red;");
//				txtRes2.setText("//REQUIRED");
//			}
//			if (txtToyID.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtToyID.setStyle("-fx-text-inner-color: red;");
//				txtToyID.setText("//REQUIRED");
//			}
//			if (txtIns.getText().replaceAll("[^\\d.]", "").length() == 0) {
//				txtIns.setStyle("-fx-text-inner-color: red;");
//				txtIns.setText("//REQUIRED");
//			}
			JOptionPane.showMessageDialog(null, error);

		}
	}
}
