package api.rest.planets.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planet {
	
	@Id
	String 	id;
	
	@Indexed(unique=true)
	String 	nome;
	
	String 	clima;
	String 	terreno;
	
	@Transient
	private int aparicoes;
	
	

	public Planet(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public String getId() {
		return id;
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
		return aparicoes;
	}

	public void setAparicoes(int aparicoes) {
		this.aparicoes = aparicoes;
	}

}
