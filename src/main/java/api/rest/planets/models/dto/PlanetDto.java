package api.rest.planets.models.dto;

import java.util.List;
import java.util.stream.Collectors;

import api.rest.planets.models.Planet;

public class PlanetDto {
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int aparicoes;
	
	public PlanetDto(Planet planet)
	{
		this.id = planet.getId();
		this.nome = planet.getNome();
		this.clima = planet.getClima();
		this.terreno = planet.getTerreno();
		this.aparicoes = planet.getAparicoes();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getClima() {
		return clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public int getAparicoes() {
		return aparicoes;
	}
	
	public static List<PlanetDto> converter(List<Planet> planets){
		return planets.stream().map(PlanetDto::new).collect(Collectors.toList());
	}

}
