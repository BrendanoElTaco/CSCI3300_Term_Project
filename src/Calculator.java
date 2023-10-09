import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
	//I have not idea what this is lol
    private static final long serialVersionUID = 1L;
    //Buttons and result field
    private JTextField resultField;
    private JButton[] numButtons;
    private JButton[] operationButtons;
    private JButton calculateButton;
    private JButton signToggleButton;
    private JButton sinButton, cosButton, tanButton;
    private JButton decimalButton;
    private JButton powerOfButton;
    private JButton backspaceButton;
    private JButton ceButton;
    private JButton eulerButton;
    private JButton PIButton;
    private JButton powerOfTenButton;
    private JButton sqrRootButton;
    private JButton logBaseTenButton;
    private JButton logBaseEButton;
    private JButton secondaryFunctionButton;
    private JButton xPowerOf2Button;
    private JButton secButton;
    private JButton cscButton;
    private JButton cotButton;
    private JButton moduloButton;
    
    private String currentInput = "";
    private double num1;
    private double num2;
    private String selectedOperation;
    private boolean isPositive = true;
    private boolean newInput = true;
    private boolean isSecondaryMode = false;

    public Calculator() {
        initializeUI();
    }
    /*
     * Need to implement multiple operator functionality
     */
    private void initializeUI() {
        // Set up the main frame
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);

        // Define font for buttons and result field
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 30);

        // Create the result field and configure it
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultField.setFont(new Font("SansSerif", Font.BOLD, 40));

        // Create number buttons (0-9)
        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = createButton(String.valueOf(i), font1);
        }

        // Create operation buttons (+, -, *, /)
        operationButtons = new JButton[4];
        String[] operations = { "+", "-", "\u00d7", "\u00f7" };
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = createButton(operations[i], font1);
        }
        
        // Create other buttons (sin, cos, tan, etc.)
        calculateButton = createButton("=", font1);
        signToggleButton = createButton("+/-", font1);
        sinButton = createButton("sin", font1);
        cosButton = createButton("cos", font1);
        tanButton = createButton("tan", font1);
        decimalButton = createButton(".", font1);
        powerOfButton = createButton("xⁿ", font1);
        backspaceButton = createButton("⌫", font1);
        ceButton = createButton("CE", font1);
        eulerButton = createButton("e", font1);
        PIButton = createButton("𝜋", font2);
        powerOfTenButton = createButton("10ˣ", font1);
        sqrRootButton = createButton("√x", font1);
        logBaseTenButton = createButton("log" + "\u2081" + "\u2080", font1);
        logBaseEButton = createButton("LN", font1);
        secondaryFunctionButton = createButton("2nd", font1);
        xPowerOf2Button = createButton("x²", font1);
        secButton = createButton("sec", font1);
        cscButton = createButton("csc", font1);
        cotButton = createButton("cot", font1);
        moduloButton = createButton("%", font1);
        
        // Create a button for logarithm operation
        //logBaseYButton = createButton("log_y x", font1);


        // Create a panel to arrange buttons in a grid
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 5));

        // Add buttons to the panel in the desired layout
        //row1
        buttonPanel.add(secondaryFunctionButton);
        buttonPanel.add(PIButton);
        //buttonPanel.add(logBaseYButton);
        buttonPanel.add(eulerButton);
        buttonPanel.add(ceButton);
        buttonPanel.add(backspaceButton);
                
        //row2
        buttonPanel.add(xPowerOf2Button);
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(moduloButton);
     
        //row3
        buttonPanel.add(sqrRootButton);
        buttonPanel.add(secButton);
        buttonPanel.add(cscButton);
        buttonPanel.add(cotButton);
        buttonPanel.add(operationButtons[3]);
        
        //row4
        buttonPanel.add(powerOfButton);
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(operationButtons[2]);
        
        //row5
        buttonPanel.add(powerOfTenButton);
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(operationButtons[1]);
        
        //Row6
        buttonPanel.add(logBaseTenButton);
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(operationButtons[0]);
        
        //Row7
        buttonPanel.add(logBaseEButton);
        buttonPanel.add(signToggleButton);
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(calculateButton);

        // Create the main panel to hold the result field and button panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(resultField, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JButton createButton(String label, Font font) {
        // Create a JButton with the given label and font, and attach an ActionListener
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.setFont(font);
        return button;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); // Identify the source of the action event
		
		//BUTTON HANDLING
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			String buttonText = button.getText();
			
			// Handle actions for numeric buttons (0-9)
			if (isNumeric(buttonText)) {
				if (newInput) {
					currentInput = buttonText;
					newInput = false;
				} else {
					currentInput += buttonText;
				}
				resultField.setText(currentInput);
			}

			// Handle actions for basic arithmetic operator buttons (+, -, ×, ÷)
			else if ("+-×÷".contains(buttonText)) {
				if (!currentInput.isEmpty()) {
					if (num1 == 0) {
						num1 = Double.parseDouble(currentInput);
					} else {
						num2 = Double.parseDouble(currentInput);
						num1 = performOperation(num1, num2, selectedOperation);
						resultField.setText(String.valueOf(num1));
					}
					currentInput = "";
					selectedOperation = buttonText;
				}
			}

			// Handle the action for the equals button (=)
			else if ("=".equals(buttonText)) {
				if (!currentInput.isEmpty()) {
					num2 = Double.parseDouble(currentInput);
					num1 = performOperation(num1, num2, selectedOperation);
					resultField.setText(String.valueOf(num1));
					currentInput = "";
					selectedOperation = "";
					newInput = true;
				}
			}
			
			// Handle the action for the sign toggle button
			else if (source == signToggleButton) {
				// Toggle the sign (positive/negative) of the current input
				isPositive = !isPositive;
				if (!currentInput.isEmpty() && !currentInput.equals("0")) {
					double input = Double.parseDouble(currentInput);
					// Apply the sign change and update the current input and display
					input = isPositive ? Math.abs(input) : -Math.abs(input);
					currentInput = String.valueOf(input);
					resultField.setText(currentInput);
				}
			}

			// Handle the action for trigonometric function buttons (sin, cos, tan)
			else if (source == sinButton || source == cosButton || source == tanButton) {
				if (!currentInput.isEmpty()) {
					double angle = Double.parseDouble(currentInput);
					double result = 0.0;

					// Calculate the trigonometric result based on the clicked button
					if (source == sinButton) {
						if (isSecondaryMode) {
							//arcsin
							result = Math.asin(angle);
						} else {
							result = Math.sin(Math.toRadians(angle));
						}
					} else if (source == cosButton) {
						if (isSecondaryMode) {
							//arccos
							result = Math.acos(angle);
						} else {
							result = Math.cos(Math.toRadians(angle));
						}
					} else if (source == tanButton) {
						if (isSecondaryMode) {
							//arctan
							result = Math.atan(angle);
						} else {
							result = Math.tan(Math.toRadians(angle));
						}
					}

					// Display the result, clear the current input for a new one
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}

			// Handle the action for the decimal button
			else if (source == decimalButton) {
				// Add a decimal point to the current input if not already present
				if (!currentInput.contains(".")) {
					currentInput += ".";
					resultField.setText(currentInput);
				}
			}

			// Handle the action for the backspace button
			else if (source == backspaceButton) {
				if (!currentInput.isEmpty()) {
					// Remove the last character from the current input
					currentInput = currentInput.substring(0, currentInput.length() - 1);
					resultField.setText(currentInput);
				}
			}

			// Handle the action for the power of button (xⁿ)
			else if (source == powerOfButton) {
				if (!currentInput.isEmpty()) {
					num1 = Double.parseDouble(currentInput);
					//X root y
					if (isSecondaryMode) {
						selectedOperation = "y√x";
						currentInput = "";
						newInput = true;
					} else {
						//x power of n
						selectedOperation = "xⁿ";
						currentInput = "";
						newInput = true;
					}
				}
			}

			// Handle the action for the clear button (CE)
			else if (source == ceButton) {
				// Clear all calculator states and reset the display
				currentInput = "";
				num1 = 0;
				num2 = 0;
				selectedOperation = "";
				isPositive = true;
				newInput = true;
				resultField.setText("");
			}

			// Handle the action for Euler's button (e)
			else if (source == eulerButton) {
				// Set the current input to Euler's number and display it
				currentInput = String.valueOf(Math.E); // Euler's number (approximately 2.71828)
				resultField.setText(currentInput);
				newInput = true;
			}

			// Handle the action for the PI button (π)
			else if (source == PIButton) {
				// Set the current input to π (pi) and display it
				currentInput = String.valueOf(Math.PI);
				resultField.setText(currentInput);
			}

			// Handle the action for the power of ten button (10^x)
			else if (source == powerOfTenButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				 if (isSecondaryMode) {
					// Calculate 2 raised to the power of the current input
					result = Math.pow(2, num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				 } else {
					// Calculate 10 raised to the power of the current input
					result = Math.pow(10, num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				 }
			}
			
			//Handle the action for the square root button
			else if (source == sqrRootButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				
				if (isSecondaryMode) {
					//Cube-root
					result = Math.cbrt(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				} else {
					// Square-root
					result = Math.sqrt(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}
			
			//Handle the action for the log base 10 button
			else if (source == logBaseTenButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				//Secondary Mode log_y x
				if (isSecondaryMode) {
			        // Prompt the user for the base (y) using input dialog
			        String baseInput = JOptionPane.showInputDialog(this, "Enter the base (y) for the logarithm:");
			        
			        if (baseInput != null && !baseInput.isEmpty()) {
			            double base = Double.parseDouble(baseInput);
			            
			            if (base <= 0 || base == 1) {
			                JOptionPane.showMessageDialog(this, "Invalid base (y) for logarithm", "Error", JOptionPane.ERROR_MESSAGE);
			            } else {
			                // Calculate the logarithm (log base y of x)
			                result = Math.log(num) / Math.log(base);
			                resultField.setText(String.valueOf(result));
			                currentInput = "";
			                newInput = true;
			            }
			        }
				} else {
					result = Math.log10(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;	
				}			
			}
			
			//Handle the action for the log base e button
			else if (source == logBaseEButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				//E^x
				if (isSecondaryMode) {
					result = Math.pow(Math.E, num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				//LN
				} else {
					result = Math.log(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
				
				
			}
			
			//Handle the action for the xPowerOf2Button button
			else if (source == xPowerOf2Button) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				
				//X cubed
				if (isSecondaryMode) {
					result = Math.pow(num, 3);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				//X squared
				} else {
					result = Math.pow(num, 2);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}
			
			//Handle the action for the secant function button
			else if (source == secButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				//Arc secant
				if (isSecondaryMode) {
					result = Math.acos(1.0 / num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				//Secant
				} else {
					result = 1 / Math.cos(Math.toRadians(num));
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}
			
			//Handle the action for the cosecant function button
			else if (source == cscButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				
				//Arc cosecant
				if (isSecondaryMode) {
					result = Math.asin(1.0 / num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				//cosecant
				} else {
					result = 1 / Math.sin(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}
			
			//Handle the action for the cotangent function button
			else if (source == cotButton) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				
				//Arc cotangent
				if (isSecondaryMode) {
					result = Math.atan(1.0 / num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				//cotangent
				} else {
					result = 1 / Math.tan(num);
					resultField.setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}
			}
			
			// Handle the action for the modulo button
			else if (source == moduloButton) {
			    if (!currentInput.isEmpty()) {
			        num1 = Double.parseDouble(currentInput);
			        selectedOperation = "%"; // Set the selected operation to modulo
			        currentInput = "";
			        newInput = true;
			    }
			}
						
			//Handle the action for the secondary function button
			else if (source == secondaryFunctionButton) {
				//Toggle between secondary functions
				isSecondaryMode = !isSecondaryMode;
				if (isSecondaryMode) {
					sqrRootButton.setText("\u221b" + "x");
					powerOfTenButton.setText("2ˣ");
					powerOfButton.setText("y√x");
					sinButton.setText("sin" + "\u207B" + "\u00B9" );
					cosButton.setText("cos" + "\u207B" + "\u00B9" );
					tanButton.setText("tan" + "\u207B" + "\u00B9" );
					xPowerOf2Button.setText("x³");
					secButton.setText("sec" + "\u207B" + "\u00B9" );
					cscButton.setText("csc" + "\u207B" + "\u00B9" );
					cotButton.setText("cot" + "\u207B" + "\u00B9" );
					logBaseTenButton.setText("log" + "\u2099" + "x");
					logBaseEButton.setText("eˣ");
				} else {
					sqrRootButton.setText("√x");
					powerOfButton.setText("xⁿ");
					powerOfTenButton.setText("10ˣ");					
					sinButton.setText("sin");
					cosButton.setText("cos");
					tanButton.setText("tan");
					xPowerOf2Button.setText("x²");
					secButton.setText("sec");
					cscButton.setText("csc");
					cotButton.setText("cot");
					logBaseTenButton.setText("log" + "\u2081" + "\u2080");
					logBaseEButton.setText("LN");
				}
			}
		}		
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	 private double performOperation(double num1, double num2, String operation) {
	        switch (operation) {
	            case "+":
	                return num1 + num2;
	            case "-":
	                return num1 - num2;
	            case "×":
	                return num1 * num2;
	            case "÷":
	                // Don't divide by zero
	                if (num2 == 0) {
	                    JOptionPane.showMessageDialog(this, "Error: Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
	                    return 0.0;
	                }
	                return num1 / num2;
	            case "xⁿ":
	                return Math.pow(num1, num2);
	            case "y√x":
	                return Math.pow(num1, 1.0 / num2);
	            case "%":
	                return num1 % num2;
	            default:
	                JOptionPane.showMessageDialog(this, "Error: Something broke - No operator selected", "Error", JOptionPane.ERROR_MESSAGE);
	                return 0.0;
	        }
	    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Calculator();
		});
	}
}
