import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4519143440307608770L;
	//Buttons and result field
    /*private JTextField resultField;
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
    private JButton moduloButton;*/
    
    private String currentInput = "";
    private double num1;
    private double num2;
    private String selectedOperation;
    private boolean isPositive = true;
    private boolean newInput = true;
    private boolean isSecondaryMode = false;
    
    //private final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 20);
    //private final Font PI_BUTTON_FONT = new Font("SansSerif", Font.BOLD, 30);
    
    
    CalculatorUI UI = new CalculatorUI();
    
    public Calculator() {
        
        UI.initializeUI();
    }
    
    // Convert HTML color string to a Color object
    Color bgColor = Color.decode("#f3f3f3");
    Color equalBgColor = Color.decode("#695b2e");
    Color buttonBgColor = Color.decode("#f9f9f9");
    /*
    private void initializeUI() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);

        initializeResultField();
        initializeNumberButtons();
        initializeOperationButtons();
        initializeFunctionButtons();

        // Create the main panel to hold the result field and button panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(resultField, BorderLayout.NORTH);
        mainPanel.add(createButtonPanel(), BorderLayout.CENTER);
        mainPanel.setBackground(bgColor);
        
        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }
    
    private void initializeResultField() {
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultField.setFont(new Font("SansSerif", Font.BOLD, 40));
        resultField.setBackground(bgColor);
        
    }

    private void initializeNumberButtons() {
        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = createButton(String.valueOf(i), BUTTON_FONT);
            numButtons[i].setBackground(buttonBgColor);
        }
    }

    private void initializeOperationButtons() {
        operationButtons = new JButton[4];
        String[] operations = { "+", "-", "\u00d7", "\u00f7" };
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = createButton(operations[i], BUTTON_FONT);
            operationButtons[i].setBackground(buttonBgColor);
        }
    }

    private void initializeFunctionButtons() {
    	calculateButton = createButton("=", BUTTON_FONT);
    	calculateButton.setBackground(equalBgColor);
        signToggleButton = createButton("+/-", BUTTON_FONT);
        sinButton = createButton("sin", BUTTON_FONT);
        cosButton = createButton("cos", BUTTON_FONT);
        tanButton = createButton("tan", BUTTON_FONT);
        decimalButton = createButton(".", BUTTON_FONT);
        powerOfButton = createButton("xⁿ", BUTTON_FONT);
        backspaceButton = createButton("⌫", BUTTON_FONT);
        ceButton = createButton("CE", BUTTON_FONT);
        eulerButton = createButton("e", BUTTON_FONT);
        PIButton = createButton("𝜋", PI_BUTTON_FONT);
        powerOfTenButton = createButton("10ˣ", BUTTON_FONT);
        sqrRootButton = createButton("√x", BUTTON_FONT);
        logBaseTenButton = createButton("log" + "\u2081" + "\u2080", BUTTON_FONT);
        logBaseEButton = createButton("LN", BUTTON_FONT);
        secondaryFunctionButton = createButton("2nd", BUTTON_FONT);
        xPowerOf2Button = createButton("x²", BUTTON_FONT);
        secButton = createButton("sec", BUTTON_FONT);
        cscButton = createButton("csc", BUTTON_FONT);
        cotButton = createButton("cot", BUTTON_FONT);
        moduloButton = createButton("%", BUTTON_FONT);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 5));

        // Add buttons to the panel in the desired layout
        //Five buttons per row
        //row1
        buttonPanel.add(secondaryFunctionButton);
        buttonPanel.add(PIButton);
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

        return buttonPanel;
    }*/
    
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
				if (newInput) {
					currentInput = buttonText;
					newInput = false;
				} else {
					currentInput += buttonText;
				}
				UI.getResultField().setText(currentInput);
				
				
				
			}

			// Handle actions for basic arithmetic operator buttons (+, -, ×, ÷)
			else if ("+-×÷".contains(buttonText)) {
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

			// Handle the action for the equals button (=)
			else if ("=".equals(buttonText)) {
				if (!currentInput.isEmpty()) {
					num2 = Double.parseDouble(currentInput);
					num1 = performOperation(num1, num2, selectedOperation);
					UI.getResultField().setText(String.valueOf(num1));
					currentInput = "";
					selectedOperation = "";
					newInput = true;
				}
			}
			
			// Handle the action for the sign toggle button
			else if (source == UI.getSignToggleButton()) {
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

			// Handle the action for trigonometric function buttons (sin, cos, tan)
			else if (source == UI.getSinButton() || source == UI.getCosButton() || source == UI.getTanButton()) {
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

			// Handle the action for the decimal button
			else if (source == UI.getDecimalButton()) {
				// Add a decimal point to the current input if not already present
				if (!currentInput.contains(".")) {
					currentInput += ".";
					UI.getResultField().setText(currentInput);
				}
			}

			// Handle the action for the backspace button
			else if (source == UI.getBackspaceButton()) {
				if (!currentInput.isEmpty()) {
					// Remove the last character from the current input
					currentInput = currentInput.substring(0, currentInput.length() - 1);
					UI.getResultField().setText(currentInput);
				}
			}

			// Handle the action for the power of button (xⁿ)
			else if (source == UI.getPowerOfButton()) {
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

			// Handle the action for the clear button (CE)
			else if (source == UI.getCeButton()) {
				// Clear all calculator states and reset the display
				currentInput = "";
				num1 = 0;
				num2 = 0;
				selectedOperation = "";
				isPositive = true;
				newInput = true;
				UI.getResultField().setText("");
			}

			// Handle the action for Euler's button (e)
			else if (source == UI.getEulerButton()) {
				// Set the current input to Euler's number and display it
				currentInput = String.valueOf(Math.E); // Euler's number (approximately 2.71828)
				UI.getResultField().setText(currentInput);
				newInput = true;
			}

			// Handle the action for the PI button (π)
			else if (source == UI.getPIButton()) {
				// Set the current input to π (pi) and display it
				currentInput = String.valueOf(Math.PI);
				UI.getResultField().setText(currentInput);
			}

			// Handle the action for the power of ten button (10^x)
			else if (source == UI.getPowerOfTenButton()) {
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
			
			//Handle the action for the square root button
			else if (source == UI.getSqrRootButton()) {
				double num = Double.parseDouble(currentInput);
				double result = 0.0;
				
				if (isSecondaryMode) {
					//Cube-root
					result = Math.cbrt(num);
					UI.getResultField().setText(String.valueOf(result));
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
			
			//Handle the action for the log base 10 button
			else if (source == UI.getLogBaseTenButton()) {
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
			
			//Handle the action for the log base e button
			else if (source == UI.getLogBaseEButton()) {
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
					result = Math.log(num);
					UI.getResultField().setText(String.valueOf(result));
					currentInput = "";
					newInput = true;
				}				
			}
			
			//Handle the action for the xPowerOf2Button button
			else if (source == UI.getxPowerOf2Button()) {
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
			
			//Handle the action for the secant function button
			else if (source == UI.getSecButton()) {
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
			
			//Handle the action for the cosecant function button
			else if (source == UI.getCscButton()) {
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
			
			//Handle the action for the cotangent function button
			else if (source == UI.getCotButton()) {
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
			
			// Handle the action for the modulo button
			else if (source == UI.getModuloButton()) {
			    if (!currentInput.isEmpty()) {
			        num1 = Double.parseDouble(currentInput);
			        selectedOperation = "%"; // Set the selected operation to modulo
			        currentInput = "";
			        newInput = true;
			    }
			}
						
			//Handle the action for the secondary function button
			else if (source == UI.getSecondaryFunctionButton()) {
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
