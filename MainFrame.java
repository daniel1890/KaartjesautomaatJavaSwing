import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	FilmKeuzeButtonPanel filmKeuzeButtonPanel;

    public MainFrame() {
    	
    	// Voeg het filmkeuze paneel toe aan de frame en voeg aan dit paneel een listener toe.
    	this.filmKeuzeButtonPanel = new FilmKeuzeButtonPanel();
    	
		filmKeuzeButtonPanel.setFilmKeuzeListener(new FilmKeuzeListener() {
			public void filmKeuzeEventOccurred(FilmKeuzeEvent e) {
				System.out.println(e.getFilmNaam());
			}
		});
        
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		add(filmKeuzeButtonPanel, gc);
		
		// Set size of window and make sure it closes when close is pressed by the user.
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Get the dimensions of the monitor of the user and split the width and height in half; afterwards, split the dimensions of the window in half and remove those of the previous amounts, this way
		 * this way the window get nicely centered.
		 */
		Dimension screenDim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width / 2) - (this.getWidth() / 2), (screenDim.height / 2) - (this.getHeight() / 2));
		setVisible(true);
    }
}