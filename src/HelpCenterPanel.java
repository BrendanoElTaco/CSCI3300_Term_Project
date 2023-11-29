import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
        
        this.setLayout(new BorderLayout());
        this.add(helpTextPane, BorderLayout.CENTER);
        
        helpTextPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustTextSize(helpTextPane);
            }
        });
        
        helpTextPane.setContentType("text/html");
        
        JScrollPane scrollPane = new JScrollPane(helpTextPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER); // Add JScrollPane to the center
        
        
        
        String htmlContent = """
        		<html>
					<head>
					    <style>
					        body {
					            font-family: 'Calibri', sans-serif;
					            line-height: 1.0;
					        }
					
					        b {
					            /* Styles for bold text */
					        }
					
					        p {
					            /* Additional styles for paragraphs */
					        }
					    </style>
					</head>
					
					<body>
					    <p><b>Welcome to the Calculator Help Center!</b></p>
					    <p>This calculator offers a variety of functions to assist with your mathematical calculations. Here's a guide to its features:</p>
					    <p><b>1. Basic Operations: </b></p>
					    <p>Perform addition, subtraction, multiplication, and division using the respective buttons on the calculator.</p>
					    <p><b>2. Number Entry: </b></p>
					    <p>Input numbers by clicking on the digit buttons. The display field will show your current entry.</p>
					    <p><b>3. Decimal Point: </b></p>
					    <p>Use the decimal button to add a decimal point to your number.</p>
					    <p><b>4. Changing Sign: </b></p>
					    <p>Toggle the sign of your current entry (positive/negative) using the sign toggle button.</p>
					    <p><b>5. Trigonometric Functions: </b></p>
					    <p>Compute sine, cosine, and tangent values using the sin, cos, and tan buttons.</p>
					    <p><b>6. Calculation and Clearing: </b></p>
					    <p>Press the equals button to perform the operation. Use the clear button to reset the calculator and start a new calculation. <br>Please note that once you press the equals sign you must clear and start a new calculation.</p>
					    <p><b>7. Error Handling: </b></p>
					    <p>In case of an invalid operation, such as division by zero, the calculator will display an error message.</p>
					    <p><b>8. Key Bindings: </b></p>
					    <p>This calculator has basic key bindings for certain tasks:</p>
					    <ul>
					        <li>Number keys on your keyboard are mapped to their matching number buttons on the calculator.</li>
					        <li>Operator keys on your numpad align with the equivalent operator buttons on the calculator.</li>
					        <li>The backspace key is linked to the calculator's back button, indicated by the ⌫ symbol.</li>
					        <li>The delete key is associated with the calculator's clear button, marked by the CE symbol.</li>
					    </ul>
					</body>
        		</html>
        		""";
  
        helpTextPane.setText(htmlContent);
    }
	
	//Dynamically change text size
	private void adjustTextSize(JTextPane textPane) {
        // Get the current size of the JTextPane
        Dimension size = textPane.getSize();
        // Calculate the new font size based on the JTextPane size
        int newSize = (int) (size.width / 20); // Calculation
        newSize = Math.max(newSize, 12); // Set a minimum size
        newSize = Math.min(newSize, 24); // Set a maximum size

        Font currentFont = textPane.getFont();
        textPane.setFont(new Font(currentFont.getName(), currentFont.getStyle(), newSize));
    }
}
