import javax.swing.*;
import javax.swing.text.*;

public class aboutPanel extends JPanel {
    /**
	 * Brendan LeGrand, CSCI 3300 - Term Project
	 * About Panel
	 */
	private static final long serialVersionUID = -6578036529732131603L;

	public aboutPanel() {
        JTextPane helpTextPane = new JTextPane();
        helpTextPane.setEditable(false);
        StyledDocument doc = helpTextPane.getStyledDocument();

        // Define a bold style
        Style style = helpTextPane.addStyle("BoldStyle", null);
        StyleConstants.setBold(style, true);

        try {
            // Add text with different styles
            doc.insertString(doc.getLength(), "Welcome to the Calculator Help Center!\n\n", style);
            
            doc.insertString(doc.getLength(), "This calculator offers a variety of functions to assist with your mathematical calculations. Here's a guide to its features:\n\n", null);
            
            doc.insertString(doc.getLength(), "1. Basic Operations: ", style);
            doc.insertString(doc.getLength(), "Perform addition, subtraction, multiplication, and division using the respective buttons on the calculator.\n\n", null);
            
            doc.insertString(doc.getLength(), "2. Number Entry: ", style);
            doc.insertString(doc.getLength(), "Input numbers by clicking on the digit buttons. The display field will show your current entry.\n\n", null);
            
            doc.insertString(doc.getLength(), "3. Decimal Point: ", style);
            doc.insertString(doc.getLength(), "Use the decimal button to add a decimal point to your number.\n\n", null);
            
            doc.insertString(doc.getLength(), "4. Changing Sign: ", style);
            doc.insertString(doc.getLength(), "Toggle the sign of your current entry (positive/negative) using the sign toggle button.\n\n", null);
            
            doc.insertString(doc.getLength(), "5. Trigonometric Functions: ", style);
            doc.insertString(doc.getLength(), "Compute sine, cosine, and tangent values using the sin, cos, and tan buttons.\n\n", null);
            
            doc.insertString(doc.getLength(), "6. Calculation and Clearing: ", style);
            doc.insertString(doc.getLength(), "Press the equals button to perform the operation. Use the clear button to reset the calculator and start a new calculation.\nPlease note that once you press the equals sign you must clear and start a new calculation.\n\n", null);
            
            doc.insertString(doc.getLength(), "7. Error Handling: ", style);
            doc.insertString(doc.getLength(), "In case of an invalid operation, such as division by zero, the calculator will display an error message.\n\n", null);
                    
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(helpTextPane);
        this.add(scrollPane);
    }
}
