package api.rest.planets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetResponse {
	private String name;
	
	private String[] films;
	
	
	public String[] getFilms() {
		return films;
	}
	
	public void setFilms(String[] films) {
		this.films = films;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getApparitionsCount() {
		if (films == null) {
			return 0;
		} 
		return films.length;
	}
}
