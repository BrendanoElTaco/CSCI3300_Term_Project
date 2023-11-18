import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
	/**
	 * Brendan LeGrand, CSCI 3300 - Term Project
	 * Main calculator method and logic
	 */
	private static final long serialVersionUID = 4519143440307608770L;
    
    private String currentInput = "";
    private double num1;
    private double num2;
    private String selectedOperation;
    private boolean isPositive = true;
    private boolean newInput = true;
    private boolean isSecondaryMode = false;    
    
    CalculatorUI UI = new CalculatorUI();
    
    public Calculator() {
        UI.initializeUI(this);
        JOptionPane.showMessageDialog(null, "Welcome to NumCruncher! \n" + "Please read the FAQ in the help center for operating instructions", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Convert HTML color string to a Color object
    Color bgColor = Color.decode("#f3f3f3");
    Color equalBgColor = Color.decode("#695b2e");
    Color buttonBgColor = Color.decode("#f9f9f9");
    
    public JButton createButton(String label, Font font) {
        // Create a JButton with the given label and font, and attach an ActionListener
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.setFont(font);
        button.setBackground(buttonBgColor);
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
				handleNumericButton(buttonText);			
			}

			// Handle actions for basic arithmetic operator buttons (+, -, ×, ÷)
			else if ("+-×÷".contains(buttonText)) {
				handleArithmeticOperator(buttonText);
			}

			// Handle the action for the equals button (=)
			else if ("=".equals(buttonText)) {
				handleEqualsButton(buttonText);
			}
			
			// Handle the action for the sign toggle button
			else if (source == UI.getSignToggleButton()) {
				handleToggleSignButton(buttonText);
			}

			// Handle the action for trigonometric function buttons (sin, cos, tan)
			else if (source == UI.getSinButton() || source == UI.getCosButton() || source == UI.getTanButton()) {
				handleTrigButtons(source);
			}

			// Handle the action for the decimal button
			else if (source == UI.getDecimalButton()) {
				handleDecimalButton(source);
			}

			// Handle the action for the backspace button
			else if (source == UI.getBackspaceButton()) {
				handleBackspaceButton(source);
			}

			// Handle the action for the power of button (xⁿ)
			else if (source == UI.getPowerOfButton()) {
				handlePowerOfButton(source);
			}

			// Handle the action for the clear button (CE)
			else if (source == UI.getCeButton()) {
				handleClearButton(source);
			}

			// Handle the action for Euler's button (e)
			else if (source == UI.getEulerButton()) {
				handleEulersButton(source);
			}

			// Handle the action for the PI button (π)
			else if (source == UI.getPIButton()) {
				handlePIButton(source);
			}

			// Handle the action for the power of ten button (10^x)
			else if (source == UI.getPowerOfTenButton()) {
				handlePowerOfTenButton(source);
			}
			
			//Handle the action for the square root button
			else if (source == UI.getSqrRootButton()) {
				handleSqrRootButton(source);
			}
			
			//Handle the action for the log base 10 button
			else if (source == UI.getLogBaseTenButton()) {
				handleLogBaseTenButton(source);			
			}
			
			//Handle the action for the log base e button
			else if (source == UI.getLogBaseEButton()) {
				handleLogBaseEButton(source);				
			}
			
			//Handle the action for the xPowerOf2Button button
			else if (source == UI.getxPowerOf2Button()) {
				handleXPowerOf2Button(source);
			}
			
			//Handle the action for the secant function button
			else if (source == UI.getSecButton()) {
				handleSecButton(source);
			}
			
			//Handle the action for the cosecant function button
			else if (source == UI.getCscButton()) {
				handleCscButton(source);
			}
			
			//Handle the action for the cotangent function button
			else if (source == UI.getCotButton()) {
				handleCotButton(source);
			}
			
			// Handle the action for the modulo button
			else if (source == UI.getModuloButton()) {
			    handleModuloButton(source);
			}
						
			//Handle the action for the secondary function button
			else if (source == UI.getSecondaryFunctionButton()) {
				handleSecondaryFunctionButton(source);
			}
		}		
	}
	
    private void handleNumericButton(String buttonText) {
        if (newInput) {
            currentInput = buttonText;
            newInput = false;
        } else {
            currentInput += buttonText;
        }
        UI.getResultField().setText(currentInput);
    }

    private void handleArithmeticOperator(String buttonText) {
    	if (!currentInput.isEmpty()) {
			if (num1 == 0) {
				num1 = Double.parseDouble(currentInput);
			} else {
				num2 = Double.parseDouble(currentInput);
				num1 = performOperation(num1, num2, selectedOperation);
				UI.getResultField().setText(String.valueOf(num1));
			}
			currentInput = "";
			selectedOperation = buttonText;
		}
    }
    
    private void handleEqualsButton(String buttonText) {
    	if (!currentInput.isEmpty()) {
			num2 = Double.parseDouble(currentInput);
			num1 = performOperation(num1, num2, selectedOperation);
			UI.getResultField().setText(String.valueOf(num1));
			currentInput = "";
			selectedOperation = "";
			newInput = true;
		}
    }
    
    private void handleToggleSignButton(String buttonText) {
    	// Toggle the sign (positive/negative) of the current input
		isPositive = !isPositive;
		if (!currentInput.isEmpty() && !currentInput.equals("0")) {
			double input = Double.parseDouble(currentInput);
			// Apply the sign change and update the current input and display
			input = isPositive ? Math.abs(input) : -Math.abs(input);
			currentInput = String.valueOf(input);
			UI.getResultField().setText(currentInput);
		}
    }
    
    private void handleTrigButtons(Object source) {
    	if (!currentInput.isEmpty()) {
			double angle = Double.parseDouble(currentInput);
			double result = 0.0;

			// Calculate the trigonometric result based on the clicked button
			if (source == UI.getSinButton()) {
				if (isSecondaryMode) {
					//arcsin
					result = Math.asin(angle);
				} else {
					result = Math.sin(Math.toRadians(angle));
				}
			} else if (source == UI.getCosButton()) {
				if (isSecondaryMode) {
					//arccos
					result = Math.acos(angle);
				} else {
					result = Math.cos(Math.toRadians(angle));
				}
			} else if (source == UI.getTanButton()) {
				if (isSecondaryMode) {
					//arctan
					result = Math.atan(angle);
				} else {
					result = Math.tan(Math.toRadians(angle));
				}
			}

			// Display the result, clear the current input for a new one
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		}
    }
    
    private void handleDecimalButton(Object source) {
    	// Add a decimal point to the current input if not already present
		if (!currentInput.contains(".")) {
			currentInput += ".";
			UI.getResultField().setText(currentInput);
		}
    }
    
    private void handleBackspaceButton(Object source) {
    	if (!currentInput.isEmpty()) {
			// Remove the last character from the current input
			currentInput = currentInput.substring(0, currentInput.length() - 1);
			UI.getResultField().setText(currentInput);
		}
    }
    
    private void handlePowerOfButton(Object source) {
    	if (!currentInput.isEmpty()) {
			num1 = Double.parseDouble(currentInput);
			//X root y
			if (isSecondaryMode) {
				selectedOperation = "n√x";
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
    
    private void handleClearButton(Object source) {
    	// Clear all calculator states and reset the display
		currentInput = "";
		num1 = 0;
		num2 = 0;
		selectedOperation = "";
		isPositive = true;
		newInput = true;
		UI.getResultField().setText("");
    }
    
    private void handleEulersButton(Object source) {
    	// Set the current input to Euler's number and display it
		currentInput = String.valueOf(Math.E); // Euler's number (approximately 2.71828)
		UI.getResultField().setText(currentInput);
		newInput = true;
    }
    
    private void handlePIButton(Object source) {
    	// Set the current input to π (pi) and display it
		currentInput = String.valueOf(Math.PI);
		UI.getResultField().setText(currentInput);
    }
    
    private void handlePowerOfTenButton(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		 if (isSecondaryMode) {
			// Calculate 2 raised to the power of the current input
			result = Math.pow(2, num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		 } else {
			// Calculate 10 raised to the power of the current input
			result = Math.pow(10, num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		 }
    }
    
    private void handleSqrRootButton(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		
		if (isSecondaryMode) {
			if (num < 0) {
                JOptionPane.showMessageDialog(this, "Error: Cannot Cube-root a negative number", "Error", JOptionPane.ERROR_MESSAGE);
                currentInput = "";
				newInput = true;
            } else {
				//Cube-root
				result = Math.cbrt(num);
				UI.getResultField().setText(String.valueOf(result));
				currentInput = "";
				newInput = true;
            }
		} else {
			// Don't sqrt negative
            if (num < 0) {
                JOptionPane.showMessageDialog(this, "Error: Cannot Square-root a negative number", "Error", JOptionPane.ERROR_MESSAGE);
                currentInput = "";
				newInput = true;
            } else {
				// Square-root
				result = Math.sqrt(num);
				UI.getResultField().setText(String.valueOf(result));
				currentInput = "";
				newInput = true;
            }
		}
    }
    
    private void handleLogBaseTenButton(Object source) {
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
	                UI.getResultField().setText(String.valueOf(result));
	                currentInput = "";
	                newInput = true;
	            }
	        }
		} else {
			result = Math.log10(num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;	
		}
    }
    
    private void handleLogBaseEButton(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		//E^x
		if (isSecondaryMode) {
			result = Math.pow(Math.E, num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		//LN
		} else {
			if (num < 0) {
                JOptionPane.showMessageDialog(this, "Invalid number for logarithm", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
			result = Math.log(num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
            }
		}
    }
    
    private void handleXPowerOf2Button(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		
		//X cubed
		if (isSecondaryMode) {
			result = Math.pow(num, 3);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		//X squared
		} else {
			result = Math.pow(num, 2);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		}
    }

	private void handleModuloButton(Object source) {
		if (!currentInput.isEmpty()) {
	        num1 = Double.parseDouble(currentInput);
	        selectedOperation = "%"; // Set the selected operation to modulo
	        currentInput = "";
	        newInput = true;
	    }		
	}

	private void handleSecButton(Object source) {
		double num = Double.parseDouble(currentInput);
		double result = 0.0;
		//Arc secant
		if (isSecondaryMode) {
			result = Math.acos(1.0 / num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		//Secant
		} else {
			result = 1 / Math.cos(Math.toRadians(num));
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		}		
	}

	private void handleCscButton(Object source) {
		double num = Double.parseDouble(currentInput);
		double result = 0.0;
		
		//Arc cosecant
		if (isSecondaryMode) {
			result = Math.asin(1.0 / num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		//cosecant
		} else {
			result = 1 / Math.sin(num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		}
		
	}

	private void handleCotButton(Object source) {
		double num = Double.parseDouble(currentInput);
		double result = 0.0;
		
		//Arc cotangent
		if (isSecondaryMode) {
			result = Math.atan(1.0 / num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		//cotangent
		} else {
			result = 1 / Math.tan(num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
		}		
	}
	
	private void handleSecondaryFunctionButton(Object source) {
		//Toggle between secondary functions
		isSecondaryMode = !isSecondaryMode;
		if (isSecondaryMode) {
			UI.getSqrRootButton().setText("\u221b" + "x");
			UI.getPowerOfTenButton().setText("2ˣ");
			UI.getPowerOfButton().setText("n√x");
			UI.getSinButton().setText("sin" + "\u207B" + "\u00B9" );
			UI.getCosButton().setText("cos" + "\u207B" + "\u00B9" );
			UI.getTanButton().setText("tan" + "\u207B" + "\u00B9" );
			UI.getxPowerOf2Button().setText("x³");
			UI.getSecButton().setText("sec" + "\u207B" + "\u00B9" );
			UI.getCscButton().setText("csc" + "\u207B" + "\u00B9" );
			UI.getCotButton().setText("cot" + "\u207B" + "\u00B9" );
			UI.getLogBaseTenButton().setText("log" + "\u2099" + "x");
			UI.logBaseEButton.setText("eˣ");
		} else {
			UI.getSqrRootButton().setText("√x");
			UI.getPowerOfButton().setText("xⁿ");
			UI.getPowerOfTenButton().setText("10ˣ");					
			UI.getSinButton().setText("sin");
			UI.getCosButton().setText("cos");
			UI.getTanButton().setText("tan");
			UI.getxPowerOf2Button().setText("x²");
			UI.getSecButton().setText("sec");
			UI.getCscButton().setText("csc");
			UI.getCotButton().setText("cot");
			UI.getLogBaseTenButton().setText("log" + "\u2081" + "\u2080");
			UI.getLogBaseEButton().setText("LN");
		}
	}
	
	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	//Method that preforms a operation with 2 input integers
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
	        case "n√x":
	            return Math.pow(num1, 1.0 / num2);
	        case "%":
	        	// Don't module by zero
	            if (num2 == 0) {
	                JOptionPane.showMessageDialog(this, "Error: Cannot use zero with a modulo operation", "Error", JOptionPane.ERROR_MESSAGE);
	                return 0.0;
	            }
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
