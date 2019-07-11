package api.rest.planets.models.dto;

import api.rest.planets.models.Planet;

public class DetailPlanetDto {
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int aparicoes;
	
	public DetailPlanetDto(Planet planet) {
		this.id = planet.getId();
		this.nome = planet.getNome();
		this.clima = planet.getClima();
		this.terreno = planet.getTerreno();
		this.aparicoes = planet.getAparicoes();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	
	public int getAparicoes() {
		return this.aparicoes;
	}

}
