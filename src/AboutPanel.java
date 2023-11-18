import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.Desktop;
import java.net.URI;

public class AboutPanel extends JPanel {
	/**
	 * AboutPanel Class - Information Panel for NumCruncher Application
	 * Developed by Brendan LeGrand for CSCI 3300 - Term Project.
	 *
	 * This class represents an informational panel that is part of the NumCruncher calculator application.
	 * It provides details about the application, such as version information, developer credits, and other relevant
	 * acknowledgements. The panel uses a JTextPane to display formatted text and hyperlinks.
	 *
	 * Features:
	 * - Displays information about the NumCruncher application.
	 * - Contains hyperlinks to relevant resources or external websites.
	 * - Utilizes Swing components for a consistent look and feel with the rest of the application.
	 *
	 * Usage:
	 * - This panel can be accessed from the main application window to provide users with additional information.
	 */

	private static final long serialVersionUID = -6578036529732131603L;

	public AboutPanel() {
        JTextPane aboutTextPane = new JTextPane();
        aboutTextPane.setEditable(false);
        
        aboutTextPane.setContentType("text/html"); // Enable HTML content

        // Define the HTML with the hyperlink
        String htmlString = "<html><body><style>" 
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><strong><span style=\"font-size:12px;\">Version</span></strong><span style=\"font-size:12px;\">: 1.0.1</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">Developed by Brendan LeGrand</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">For more information, visit my <a href=\"https://github.com/BrendanoElTaco/CSCI3300_Term_Project\">GitHub</a></span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">NumCruncher is a user-friendly calculator designed to perform basic arithmetic operations, trigonometric calculations, and more.</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">It was developed as a part of a term project for my software development class.</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">If you find any bugs, please submit a bug report on <a href=\\\"https://github.com/BrendanoElTaco/CSCI3300_Term_Project\\\">GitHub</a>.</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">&nbsp;</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><strong><span style=\"font-size:12px;\">Credits</span></strong><span style=\"font-size:12px;\">:</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">- Special thanks to Michael McLeod, MBT for teaching this class, and StackOverflow for saving my sanity.</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">&nbsp;</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><strong><span style=\"font-size:12px;\">Disclaimer</span></strong><span style=\"font-size:12px;\">:</span></p>\r\n"
        					+ "<p style='font-family:\"Calibri\",sans-serif;'><span style=\"font-size:12px;\">- NumCruncher is provided &quot;as is&quot; for educational purposes and is not intended for professional use.</span></p>\r\n"
                            + "</body></html>";
        aboutTextPane.setText(htmlString);

        // Add a hyperlink listener
        aboutTextPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(e.getURL().toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(aboutTextPane);
        this.add(scrollPane);
    }
}
