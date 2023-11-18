import javax.swing.*;

public class HelpCenterPanel extends JPanel {
	/**
	 * HelpCenterPanel Class - Help and FAQ Panel for NumCruncher Application
	 * Developed by Brendan LeGrand for CSCI 3300 - Term Project.
	 *
	 * This class provides a help and FAQ panel for the NumCruncher calculator application. It is designed to offer users
	 * guidance on how to use the application, with a focus on accessibility and ease of understanding. The panel uses a
	 * JTextPane to display formatted text, including HTML content for structured presentation.
	 *
	 * Features:
	 * - Detailed FAQ and help guidelines for users of the NumCruncher application.
	 * - Uses HTML content for structured and formatted text presentation.
	 * - Easy to navigate and user-friendly interface.
	 *
	 * Usage:
	 * - This panel is accessible from the main application window and provides users with helpful information
	 *   about using the application effectively.
	 */

	private static final long serialVersionUID = -6578036529732131603L;

	public HelpCenterPanel() {
        JTextPane helpTextPane = new JTextPane();
        helpTextPane.setEditable(false);
        
        helpTextPane.setContentType("text/html");
                
        String htmlContent = "<html><body>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>Welcome to the Calculator Help Center!<br><br></b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">This calculator offers a variety of functions to assist with your mathematical calculations. Here's a guide to its features:<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>1. Basic Operations: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Perform addition, subtraction, multiplication, and division using the respective buttons on the calculator.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>2. Number Entry: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Input numbers by clicking on the digit buttons. The display field will show your current entry.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>3. Decimal Point: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Use the decimal button to add a decimal point to your number.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>4. Changing Sign: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Toggle the sign of your current entry (positive/negative) using the sign toggle button.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>5. Trigonometric Functions: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Compute sine, cosine, and tangent values using the sin, cos, and tan buttons.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>6. Calculation and Clearing: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Press the equals button to perform the operation. Use the clear button to reset the calculator and start a new calculation.<br>Please note that once you press the equals sign you must clear and start a new calculation.<br><br></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\"><b>7. Error Handling: </b></p>\r\n"
        		+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">In case of an invalid operation, such as division by zero, the calculator will display an error message.<br><br></p>\r\n"
        		+ "</body></html>\r\n";
  
        helpTextPane.setText(htmlContent);
        
        JScrollPane scrollPane = new JScrollPane(helpTextPane);
        this.add(scrollPane);
    }
}
