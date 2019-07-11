package api.rest.planets.models.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import api.rest.planets.models.Planet;

public class PlanetForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	private String clima;
	private String terreno;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	public Planet converter() {
		return new Planet(getNome(),getClima(),getTerreno());
	}
}
