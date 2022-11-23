<!DOCTYPE html>
<html lang="en">
<head>
<title>Ohm's Law</title>
<meta charset="utf-8">
<link rel="stylesheet" href="swag.css">
</head>

<body>
	<div style="opacity: .95;">
		<main>
		<h1>Ohm's Law</h1>

		<%
			bp.Circuit myCircuit = new bp.Circuit();
			double amps = myCircuit.getAmperage();
			double res = myCircuit.getResistance();
			double volts = myCircuit.getVoltage();
			
			try {
			if (request.getParameter("txtAmp") != null && request.getParameter("txtAmp").length() == 0) {
				myCircuit.setVoltage(Double.parseDouble(request.getParameter("txtVolt")));
				myCircuit.setResistance(Double.parseDouble(request.getParameter("txtRes")));
				myCircuit.calculateAmperage();
				amps = myCircuit.getAmperage();
			} else if (request.getParameter("txtRes") != null && request.getParameter("txtRes").length() == 0) {
				myCircuit.setVoltage(Double.parseDouble(request.getParameter("txtVolt")));
				myCircuit.setAmperage(Double.parseDouble(request.getParameter("txtAmp")));
				myCircuit.calculateResistance();
				res = myCircuit.getResistance();
			} else if (request.getParameter("txtVolt") != null && request.getParameter("txtVolt").length() == 0) {
				myCircuit.setResistance(Double.parseDouble(request.getParameter("txtRes")));
				myCircuit.setAmperage(Double.parseDouble(request.getParameter("txtAmp")));
				myCircuit.calculateVoltage();
				volts = myCircuit.getVoltage();
			}	else {
				out.println("You need to leave a field blank... So we know what to calculate.");
			}
			} catch (NullPointerException e) {
				out.println("Hmmm... It looks like you left two many fields blank. In order to calculate a value, you must fill in two of the boxes below.");
			} catch (NumberFormatException e) {
			}
		%> 
		<h3>
		This is a voltage, amperage and resistance calculator. Add two
		values, the remaining field will be auto-generated upon button press.
		</h3>
		<br>
		<br>
		<form method=get>

<%
String stringVolts;
if (volts==0) {
	stringVolts = null;
} else {
	stringVolts = String.valueOf(volts);
	
}
String stringAmps;
if (amps==0) {
	stringAmps = null;
} else {
	stringAmps = String.valueOf(amps);
	
}
String stringRes;
if (res==0) {
	stringRes = null;
} else {
	stringRes = String.valueOf(res);
	
}
%>
			<input type=number name=txtVolt id=voltID placeholder="Voltage"
				step=".01" min=".01" value="<%=stringVolts%>"> &nbsp; &nbsp; <input type=number
				name=txtRes id=resID placeholder="Resistance" step=".01" min=".01" value="<%=stringRes%>">
			&nbsp; &nbsp; <input type=number name=txtAmp id=ampID
				placeholder="Amperage" step=".01" min=".01"  value="<%=stringAmps%>"> &nbsp; &nbsp; <input
				type=submit name=cmdSubmit value=Calculate> &nbsp; &nbsp;

		</form>
		</main>
	</div>

</body>
</html>