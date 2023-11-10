import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorUI extends JFrame {
	/**
	 * Brendan LeGrand, CSCI 3300 - Term Project
	 * Caculator UI
	 */
	private static final long serialVersionUID = 5294493750822072072L;
	public JTextField resultField;
    public JButton[] numButtons;
    public JButton[] operationButtons;
    public JButton calculateButton;
    public JButton signToggleButton;
    public JButton sinButton, cosButton, tanButton;
    public JButton decimalButton;
    public JButton powerOfButton;
    public JButton backspaceButton;
    public JButton ceButton;
    public JButton eulerButton;
    public JButton PIButton;
    public JButton powerOfTenButton;
    public JButton sqrRootButton;
    public JButton logBaseTenButton;
    public JButton logBaseEButton;
    public JButton secondaryFunctionButton;
    public JButton xPowerOf2Button;
    public JButton secButton;
    public JButton cscButton;
    public JButton cotButton;
    public JButton moduloButton;
    
    private JPanel mainPanel;
	
    //Fonts
    private final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 20);
    private final Font PI_BUTTON_FONT = new Font("SansSerif", Font.BOLD, 30);
    
	// Convert HTML color string to a Color object
    // I stole these colors from the windows calculator lol
    Color bgColor = Color.decode("#f3f3f3");
    Color equalBgColor = Color.decode("#695b2e");
    Color buttonBgColor = Color.decode("#f9f9f9");
    Color darkBgColor = Color.decode("#202020");
    Color darkEqualBgColor = Color.decode("#cac585");
    Color darkNumberBgColor = Color.decode("#3b3b3b");
    Color darkButtonBgColor = Color.decode("#323232");
    Color darkTextColor = Color.decode("#e1e1e1");
        
	private Calculator calculator;

	//Initialize UI
    public void initializeUI(Calculator calc) {
        this.calculator = calc;
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);       

        initializeResultField();
        initializeNumberButtons();
        initializeOperationButtons();
        initializeFunctionButtons();
        initializeMenuBar();

        // Create the main panel to hold the result field and button panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(resultField, BorderLayout.NORTH);
        mainPanel.add(createButtonPanel(), BorderLayout.CENTER);
        mainPanel.setBackground(bgColor);
        
        // Add the main panel to the frame
        add(mainPanel);
        
        // Make the frame visible
        setVisible(true);
    }
    
    private void initializeMenuBar() {
    	// Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "Customization" menu
        JMenu customizationMenu = new JMenu("Customization");
        menuBar.add(customizationMenu);

        // Create radio button menu items
        JRadioButtonMenuItem lightMode = new JRadioButtonMenuItem("Light Mode");
        JRadioButtonMenuItem darkMode = new JRadioButtonMenuItem("Dark Mode");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(lightMode);
        group.add(darkMode);

        // Add radio buttons to the menu
        customizationMenu.add(lightMode);
        customizationMenu.add(darkMode);

        // Action listeners
        lightMode.addActionListener(e -> {
        	setLightMode();
        });
        
        darkMode.addActionListener(e -> {
            setDarkMode();
        });

        //Create the help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpItem = new JMenuItem("Help Center");
        menuBar.add(helpMenu);
        
        helpMenu.add(helpItem);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        
        // Add ActionListener to the helpItem
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display HelpCenterPanel
                HelpCenterPanel helpPanel = new HelpCenterPanel();
                JOptionPane.showMessageDialog(null, helpPanel, "Help Center: Calculator Functionality", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        //Create the about menu
        JMenu aboutMenu = new JMenu("About");
        JMenuItem aboutItem = new JMenuItem("About my Calculator");
        menuBar.add(aboutMenu);
        
        aboutMenu.add(aboutItem);
        menuBar.add(aboutMenu);
        this.setJMenuBar(menuBar);
        
        // Add ActionListener to the menuItem
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display AboutPanel
                aboutPanel aboutPanel = new aboutPanel();
                JOptionPane.showMessageDialog(null, aboutPanel, "Help Center: Calculator Functionality", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Add the menu bar to the frame
        setJMenuBar(menuBar);
		
	}

	private void initializeResultField() {
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultField.setFont(new Font("SansSerif", Font.BOLD, 40));
        resultField.setBackground(bgColor);   
        resultField.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void initializeNumberButtons() {
        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = calculator.createButton(String.valueOf(i), BUTTON_FONT);
            numButtons[i].setBackground(buttonBgColor);
        }
    }

    private void initializeOperationButtons() {
        operationButtons = new JButton[4];
        String[] operations = { "+", "-", "\u00d7", "\u00f7" };
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = calculator.createButton(operations[i], BUTTON_FONT);
            operationButtons[i].setBackground(buttonBgColor);
        }
    }

    private void initializeFunctionButtons() {
    	calculateButton = calculator.createButton("=", BUTTON_FONT);
    	calculateButton.setBackground(equalBgColor);
        signToggleButton = calculator.createButton("+/-", BUTTON_FONT);
        sinButton = calculator.createButton("sin", BUTTON_FONT);
        cosButton = calculator.createButton("cos", BUTTON_FONT);
        tanButton = calculator.createButton("tan", BUTTON_FONT);
        decimalButton = calculator.createButton(".", BUTTON_FONT);
        powerOfButton = calculator.createButton("xⁿ", BUTTON_FONT);
        backspaceButton = calculator.createButton("⌫", BUTTON_FONT);
        ceButton = calculator.createButton("CE", BUTTON_FONT);
        eulerButton = calculator.createButton("e", BUTTON_FONT);
        PIButton = calculator.createButton("𝜋", PI_BUTTON_FONT);
        powerOfTenButton = calculator.createButton("10ˣ", BUTTON_FONT);
        sqrRootButton = calculator.createButton("√x", BUTTON_FONT);
        logBaseTenButton = calculator.createButton("log" + "\u2081" + "\u2080", BUTTON_FONT);
        logBaseEButton = calculator.createButton("LN", BUTTON_FONT);
        secondaryFunctionButton = calculator.createButton("2nd", BUTTON_FONT);
        xPowerOf2Button = calculator.createButton("x²", BUTTON_FONT);
        secButton = calculator.createButton("sec", BUTTON_FONT);
        cscButton = calculator.createButton("csc", BUTTON_FONT);
        cotButton = calculator.createButton("cot", BUTTON_FONT);
        moduloButton = calculator.createButton("%", BUTTON_FONT);
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
    }
    
    private void setDarkMode() {
    	mainPanel.setBackground(darkBgColor);
        resultField.setBackground(darkBgColor);
        for (JButton button : numButtons) {
            button.setBackground(darkNumberBgColor);
            button.setForeground(darkTextColor);
        }
        for (JButton button : operationButtons) {
            button.setBackground(darkButtonBgColor);
            button.setForeground(darkTextColor);
        }
        sinButton.setBackground(darkButtonBgColor);
        cosButton.setBackground(darkButtonBgColor);
        tanButton.setBackground(darkButtonBgColor);
        decimalButton.setBackground(darkNumberBgColor);
        signToggleButton.setBackground(darkNumberBgColor);
        powerOfButton.setBackground(darkButtonBgColor);
        backspaceButton.setBackground(darkButtonBgColor);
        ceButton.setBackground(darkButtonBgColor);
        eulerButton.setBackground(darkButtonBgColor);
        PIButton.setBackground(darkButtonBgColor);
        powerOfTenButton.setBackground(darkButtonBgColor);
        sqrRootButton.setBackground(darkButtonBgColor);
        logBaseTenButton.setBackground(darkButtonBgColor);
        logBaseEButton.setBackground(darkButtonBgColor);
        secondaryFunctionButton.setBackground(darkButtonBgColor);
        xPowerOf2Button.setBackground(darkButtonBgColor);
        secButton.setBackground(darkButtonBgColor);
        cscButton.setBackground(darkButtonBgColor);
        cotButton.setBackground(darkButtonBgColor);
        moduloButton.setBackground(darkButtonBgColor);
        calculateButton.setBackground(darkEqualBgColor);
        
        //Change text color to white
        sinButton.setForeground(darkTextColor);
        cosButton.setForeground(darkTextColor);
        tanButton.setForeground(darkTextColor);
        decimalButton.setForeground(darkTextColor);
        signToggleButton.setForeground(darkTextColor);
        powerOfButton.setForeground(darkTextColor);
        backspaceButton.setForeground(darkTextColor);
        ceButton.setForeground(darkTextColor);
        eulerButton.setForeground(darkTextColor);
        PIButton.setForeground(darkTextColor);
        powerOfTenButton.setForeground(darkTextColor);
        sqrRootButton.setForeground(darkTextColor);
        logBaseTenButton.setForeground(darkTextColor);
        logBaseEButton.setForeground(darkTextColor);
        secondaryFunctionButton.setForeground(darkTextColor);
        xPowerOf2Button.setForeground(darkTextColor);
        secButton.setForeground(darkTextColor);
        cscButton.setForeground(darkTextColor);
        cotButton.setForeground(darkTextColor);
        moduloButton.setForeground(darkTextColor);
        resultField.setForeground(darkTextColor);
        calculateButton.setForeground(darkTextColor);
    }
    
    private void setLightMode() {
    	mainPanel.setBackground(bgColor);
        resultField.setBackground(bgColor);
        for (JButton button : numButtons) {
            button.setBackground(buttonBgColor);
            button.setForeground(null);
        }
        for (JButton button : operationButtons) {
            button.setBackground(buttonBgColor);
            button.setForeground(null);
        }
        sinButton.setBackground(buttonBgColor);
        cosButton.setBackground(buttonBgColor);
        tanButton.setBackground(buttonBgColor);
        decimalButton.setBackground(buttonBgColor);
        signToggleButton.setBackground(buttonBgColor);
        powerOfButton.setBackground(buttonBgColor);
        backspaceButton.setBackground(buttonBgColor);
        ceButton.setBackground(buttonBgColor);
        eulerButton.setBackground(buttonBgColor);
        PIButton.setBackground(buttonBgColor);
        powerOfTenButton.setBackground(buttonBgColor);
        sqrRootButton.setBackground(buttonBgColor);
        logBaseTenButton.setBackground(buttonBgColor);
        logBaseEButton.setBackground(buttonBgColor);
        secondaryFunctionButton.setBackground(buttonBgColor);
        xPowerOf2Button.setBackground(buttonBgColor);
        secButton.setBackground(buttonBgColor);
        cscButton.setBackground(buttonBgColor);
        cotButton.setBackground(buttonBgColor);
        moduloButton.setBackground(buttonBgColor);
        calculateButton.setBackground(equalBgColor);
        
        //Change text color to default
        sinButton.setForeground(null);
        cosButton.setForeground(null);
        tanButton.setForeground(null);
        decimalButton.setForeground(null);
        signToggleButton.setForeground(null);
        powerOfButton.setForeground(null);
        backspaceButton.setForeground(null);
        ceButton.setForeground(null);
        eulerButton.setForeground(null);
        PIButton.setForeground(null);
        powerOfTenButton.setForeground(null);
        sqrRootButton.setForeground(null);
        logBaseTenButton.setForeground(null);
        logBaseEButton.setForeground(null);
        secondaryFunctionButton.setForeground(null);
        xPowerOf2Button.setForeground(null);
        secButton.setForeground(null);
        cscButton.setForeground(null);
        cotButton.setForeground(null);
        moduloButton.setForeground(null);
        resultField.setForeground(null);
        calculateButton.setForeground(null);
    }
    
    //Getters
    public JTextField getResultField() {
		return resultField;
	}

	public JButton[] getNumButtons() {
		return numButtons;
	}

	public JButton[] getOperationButtons() {
		return operationButtons;
	}

	public JButton getCalculateButton() {
		return calculateButton;
	}

	public JButton getSignToggleButton() {
		return signToggleButton;
	}

	public JButton getSinButton() {
		return sinButton;
	}

	public JButton getCosButton() {
		return cosButton;
	}

	public JButton getTanButton() {
		return tanButton;
	}

	public JButton getDecimalButton() {
		return decimalButton;
	}

	public JButton getPowerOfButton() {
		return powerOfButton;
	}

	public JButton getBackspaceButton() {
		return backspaceButton;
	}

	public JButton getCeButton() {
		return ceButton;
	}

	public JButton getEulerButton() {
		return eulerButton;
	}

	public JButton getPIButton() {
		return PIButton;
	}

	public JButton getPowerOfTenButton() {
		return powerOfTenButton;
	}

	public JButton getSqrRootButton() {
		return sqrRootButton;
	}

	public JButton getLogBaseTenButton() {
		return logBaseTenButton;
	}

	public JButton getLogBaseEButton() {
		return logBaseEButton;
	}

	public JButton getSecondaryFunctionButton() {
		return secondaryFunctionButton;
	}

	public JButton getxPowerOf2Button() {
		return xPowerOf2Button;
	}

	public JButton getSecButton() {
		return secButton;
	}

	public JButton getCscButton() {
		return cscButton;
	}

	public JButton getCotButton() {
		return cotButton;
	}

	public JButton getModuloButton() {
		return moduloButton;
	}
}
