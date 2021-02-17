import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FilmKeuzeButtonPanel extends JPanel implements ActionListener {
	
	private ArrayList<JButton> filmKnoppen;
	private FilmKeuzeListener filmKeuzeListener;


    public FilmKeuzeButtonPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        filmKnoppen = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
        	JButton filmKnop = new JButton("Button n" + i);
        	filmKnop.addActionListener(this);
        	filmKnoppen.add(filmKnop);
        }

        for (JButton btn : filmKnoppen) {
            add(btn);
            add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
    
	public void actionPerformed(ActionEvent e) {
		System.out.println("A button has been clicked");
		JButton clicked = (JButton) e.getSource();

		String text = clicked.getText();
		System.out.println(text);
		
		FilmKeuzeEvent ev = new FilmKeuzeEvent(this, text);
		
		if (filmKeuzeListener != null) {
			filmKeuzeListener.filmKeuzeEventOccurred(ev);
		}
	}
	
	public void setFilmKeuzeListener(FilmKeuzeListener listener) {
		this.filmKeuzeListener = listener;
	}
}