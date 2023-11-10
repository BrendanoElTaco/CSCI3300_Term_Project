import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class CalculatorUI extends JFrame {
	/**
	 * 
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
    
    //Getters and Setters
    public JTextField getResultField() {
		return resultField;
	}

	public void setResultField(JTextField resultField) {
		this.resultField = resultField;
	}

	public JButton[] getNumButtons() {
		return numButtons;
	}

	public void setNumButtons(JButton[] numButtons) {
		this.numButtons = numButtons;
	}

	public JButton[] getOperationButtons() {
		return operationButtons;
	}

	public void setOperationButtons(JButton[] operationButtons) {
		this.operationButtons = operationButtons;
	}

	public JButton getCalculateButton() {
		return calculateButton;
	}

	public void setCalculateButton(JButton calculateButton) {
		this.calculateButton = calculateButton;
	}

	public JButton getSignToggleButton() {
		return signToggleButton;
	}

	public void setSignToggleButton(JButton signToggleButton) {
		this.signToggleButton = signToggleButton;
	}

	public JButton getSinButton() {
		return sinButton;
	}

	public void setSinButton(JButton sinButton) {
		this.sinButton = sinButton;
	}

	public JButton getCosButton() {
		return cosButton;
	}

	public void setCosButton(JButton cosButton) {
		this.cosButton = cosButton;
	}

	public JButton getTanButton() {
		return tanButton;
	}

	public void setTanButton(JButton tanButton) {
		this.tanButton = tanButton;
	}

	public JButton getDecimalButton() {
		return decimalButton;
	}

	public void setDecimalButton(JButton decimalButton) {
		this.decimalButton = decimalButton;
	}

	public JButton getPowerOfButton() {
		return powerOfButton;
	}

	public void setPowerOfButton(JButton powerOfButton) {
		this.powerOfButton = powerOfButton;
	}

	public JButton getBackspaceButton() {
		return backspaceButton;
	}

	public void setBackspaceButton(JButton backspaceButton) {
		this.backspaceButton = backspaceButton;
	}

	public JButton getCeButton() {
		return ceButton;
	}

	public void setCeButton(JButton ceButton) {
		this.ceButton = ceButton;
	}

	public JButton getEulerButton() {
		return eulerButton;
	}

	public void setEulerButton(JButton eulerButton) {
		this.eulerButton = eulerButton;
	}

	public JButton getPIButton() {
		return PIButton;
	}

	public void setPIButton(JButton pIButton) {
		PIButton = pIButton;
	}

	public JButton getPowerOfTenButton() {
		return powerOfTenButton;
	}

	public void setPowerOfTenButton(JButton powerOfTenButton) {
		this.powerOfTenButton = powerOfTenButton;
	}

	public JButton getSqrRootButton() {
		return sqrRootButton;
	}

	public void setSqrRootButton(JButton sqrRootButton) {
		this.sqrRootButton = sqrRootButton;
	}

	public JButton getLogBaseTenButton() {
		return logBaseTenButton;
	}

	public void setLogBaseTenButton(JButton logBaseTenButton) {
		this.logBaseTenButton = logBaseTenButton;
	}

	public JButton getLogBaseEButton() {
		return logBaseEButton;
	}

	public void setLogBaseEButton(JButton logBaseEButton) {
		this.logBaseEButton = logBaseEButton;
	}

	public JButton getSecondaryFunctionButton() {
		return secondaryFunctionButton;
	}

	public void setSecondaryFunctionButton(JButton secondaryFunctionButton) {
		this.secondaryFunctionButton = secondaryFunctionButton;
	}

	public JButton getxPowerOf2Button() {
		return xPowerOf2Button;
	}

	public void setxPowerOf2Button(JButton xPowerOf2Button) {
		this.xPowerOf2Button = xPowerOf2Button;
	}

	public JButton getSecButton() {
		return secButton;
	}

	public void setSecButton(JButton secButton) {
		this.secButton = secButton;
	}

	public JButton getCscButton() {
		return cscButton;
	}

	public void setCscButton(JButton cscButton) {
		this.cscButton = cscButton;
	}

	public JButton getCotButton() {
		return cotButton;
	}

	public void setCotButton(JButton cotButton) {
		this.cotButton = cotButton;
	}

	public JButton getModuloButton() {
		return moduloButton;
	}

	public void setModuloButton(JButton moduloButton) {
		this.moduloButton = moduloButton;
	}

	public Color getEqualBgColor() {
		return equalBgColor;
	}

	public void setEqualBgColor(Color equalBgColor) {
		this.equalBgColor = equalBgColor;
	}

	public Calculator getLogic() {
		return calculator;
	}

	public void setLogic(Calculator logic) {
		this.calculator = logic;
	}

	// Convert HTML color string to a Color object
    Color bgColor = Color.decode("#f3f3f3");
    Color equalBgColor = Color.decode("#695b2e");
    Color buttonBgColor = Color.decode("#f9f9f9");
    Color darkBgColor = Color.decode("#202020");
    Color darkEqualBgColor = Color.decode("#cac585");
    Color darkNumberBgColor = Color.decode("#3b3b3b");
    Color darkButtonBgColor = Color.decode("#323232");
        
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

        // Create the main panel to hold the result field and button panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(resultField, BorderLayout.NORTH);
        mainPanel.add(createButtonPanel(), BorderLayout.CENTER);
        mainPanel.setBackground(bgColor);
        
        // Add the main panel to the frame
        add(mainPanel);
        
        initializeMenuBar();

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
            // Action for Option 1
        });
        darkMode.addActionListener(e -> {
            mainPanel.setBackground(darkBgColor);
            resultField.setBackground(darkBgColor);
            
        });

        // Add the menu bar to the frame
        setJMenuBar(menuBar);
		
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
}
