import javax.swing.JOptionPane;

public class CalculatorLogic {
	/**
	 * CalculatorLogic Class - Core Logic for NumCruncher Application
	 * Developed by Brendan LeGrand for CSCI 3300 - Term Project.
	 *
	 * This class is responsible for implementing the core logic behind the NumCruncher calculator application.
	 * It handles arithmetic operations, manages state and data related to calculations, and interacts with the CalculatorUI
	 * class to reflect updates in the user interface.
	 *
	 * Key Features:
	 * - Basic arithmetic operations like addition, subtraction, multiplication, and division.
	 * - Support for handling decimal inputs and arithmetic.
	 * - Maintains the state of current calculations and updates the UI accordingly.
	 * - Works in tandem with CalculatorUI for an interactive user experience.
	 *
	 * Usage:
	 * - This class is instantiated within the Calculator class.
	 * - It receives input from the UI and processes the logic of the calculator.
	 * 
	 * Dependencies:
	 * - Relies on CalculatorUI for displaying results and Calculator for overall orchestration.
	 */

    private String currentInput = "";
    private double num1;
    private double num2;
    private String selectedOperation;
    private boolean isPositive = true;
    private boolean newInput = true;
    private boolean isSecondaryMode = false;
    
    private CalculatorUI UI;
    private Calculator calculator;
    
    public CalculatorLogic(CalculatorUI UI, Calculator calculator) {
        this.UI = UI;
        this.calculator = calculator;
    }
	
    public void handleNumericButton(String buttonText) {
        if (newInput) {
            currentInput = buttonText;
            newInput = false;
        } else {
            currentInput += buttonText;
        }
        UI.getResultField().setText(currentInput);
    }

    public void handleArithmeticOperator(String buttonText) {
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
    
    public void handleEqualsButton(String buttonText) {
    	if (!currentInput.isEmpty()) {
			num2 = Double.parseDouble(currentInput);
			num1 = performOperation(num1, num2, selectedOperation);
			UI.getResultField().setText(String.valueOf(num1));
			currentInput = "";
			selectedOperation = "";
			newInput = true;
		}
    }
    
    public void handleToggleSignButton(String buttonText) {
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
    
    public void handleTrigButtons(Object source) {
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
    
    public void handleDecimalButton(Object source) {
    	// Add a decimal point to the current input if not already present
		if (!currentInput.contains(".")) {
			currentInput += ".";
			UI.getResultField().setText(currentInput);
		}
    }
    
    public void handleBackspaceButton(Object source) {
    	if (!currentInput.isEmpty()) {
			// Remove the last character from the current input
			currentInput = currentInput.substring(0, currentInput.length() - 1);
			UI.getResultField().setText(currentInput);
		}
    }
    
    public void handlePowerOfButton(Object source) {
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
    
    public void handleClearButton(Object source) {
    	// Clear all calculator states and reset the display
		currentInput = "";
		num1 = 0;
		num2 = 0;
		selectedOperation = "";
		isPositive = true;
		newInput = true;
		UI.getResultField().setText("");
    }
    
    public void handleEulersButton(Object source) {
    	// Set the current input to Euler's number and display it
		currentInput = String.valueOf(Math.E); // Euler's number (approximately 2.71828)
		UI.getResultField().setText(currentInput);
		newInput = true;
    }
    
    public void handlePIButton(Object source) {
    	// Set the current input to π (pi) and display it
		currentInput = String.valueOf(Math.PI);
		UI.getResultField().setText(currentInput);
    }
    
    public void handlePowerOfTenButton(Object source) {
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
    
    public void handleSqrRootButton(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		
		if (isSecondaryMode) {
			if (num < 0) {
                JOptionPane.showMessageDialog(calculator, "Error: Cannot Cube-root a negative number", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(calculator, "Error: Cannot Square-root a negative number", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public void handleLogBaseTenButton(Object source) {
    	double num = Double.parseDouble(currentInput);
		double result = 0.0;
		//Secondary Mode log_y x
		if (isSecondaryMode) {
	        // Prompt the user for the base (y) using input dialog
	        String baseInput = JOptionPane.showInputDialog(this, "Enter the base (y) for the logarithm:");
	        
	        if (baseInput != null && !baseInput.isEmpty()) {
	            double base = Double.parseDouble(baseInput);
	            
	            if (base <= 0 || base == 1) {
	                JOptionPane.showMessageDialog(calculator, "Invalid base (y) for logarithm", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public void handleLogBaseEButton(Object source) {
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
                JOptionPane.showMessageDialog(calculator, "Invalid number for logarithm", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
			result = Math.log(num);
			UI.getResultField().setText(String.valueOf(result));
			currentInput = "";
			newInput = true;
            }
		}
    }
    
    public void handleXPowerOf2Button(Object source) {
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

	public void handleModuloButton(Object source) {
		if (!currentInput.isEmpty()) {
	        num1 = Double.parseDouble(currentInput);
	        selectedOperation = "%"; // Set the selected operation to modulo
	        currentInput = "";
	        newInput = true;
	    }		
	}

	public void handleSecButton(Object source) {
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

	public void handleCscButton(Object source) {
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

	public void handleCotButton(Object source) {
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
	
	public void handleSecondaryFunctionButton(Object source) {
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
	
	//Method that preforms a operation with 2 input integers
	public double performOperation(double num1, double num2, String operation) {
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
	                JOptionPane.showMessageDialog(calculator, "Error: Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
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
	                JOptionPane.showMessageDialog(calculator, "Error: Cannot use zero with a modulo operation", "Error", JOptionPane.ERROR_MESSAGE);
	                return 0.0;
	            }
	            return num1 % num2;
	        default:
	            JOptionPane.showMessageDialog(calculator, "Error: Something broke - No operator selected", "Error", JOptionPane.ERROR_MESSAGE);
	            return 0.0;
		}
	}
}
