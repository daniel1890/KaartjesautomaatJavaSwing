import java.util.EventObject;

public class FilmKeuzeEvent extends EventObject {

	private String filmnaam;

	public FilmKeuzeEvent(Object source) {
		super(source);
	}
	
	public FilmKeuzeEvent(Object source, String text) {
		super(source);
		
		this.filmnaam = text;
	}
	
	public String getFilmNaam() {
		return this.filmnaam;
	}
}
