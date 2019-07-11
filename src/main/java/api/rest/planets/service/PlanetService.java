package api.rest.planets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import api.rest.planets.models.Planet;
import api.rest.planets.models.PlanetResponse;
import api.rest.planets.models.SwapiResponse;
import api.rest.planets.repository.PlanetRepository;

@Component
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Planet create(String nome, String clima, String terreno) throws Exception {
		Planet newPlanet = planetRepository.save(new Planet(nome,clima, terreno));
		
		newPlanet.setAparicoes(getPlanetFromSwapi(newPlanet.getNome()).getApparitionsCount());
		
		return newPlanet;
	} 
	
	public List<Planet> getAll() throws Exception{
		List<Planet> planets = planetRepository.findAll();
		for(Planet planet : planets) {
			PlanetResponse response = getPlanetFromSwapi(planet.getNome());
			planet.setAparicoes(response.getApparitionsCount());
		}
		return planets;
	}
	
	public Planet getByNome(String nome) throws Exception {
		Planet planet = planetRepository.findByNome(nome);
		
		planet.setAparicoes(getPlanetFromSwapi(planet.getNome()).getApparitionsCount());
		
		return planet;
	}
	
	public Planet getById(String id) throws Exception {
		Planet planet = planetRepository.findById(id).orElseThrow(() -> new Exception(id + " inválido ou inexistente"));
		planet.setAparicoes(getPlanetFromSwapi(planet.getNome()).getApparitionsCount());
		return planet;
	}
	
	
	public void delete(String id) {
		Planet p = planetRepository.findById(id).get();
		planetRepository.delete(p);
	}
	
	@Cacheable("PlanetsResponse")
	public PlanetResponse getPlanetFromSwapi(String nomePlaneta) throws Exception {
		
		String url = "https://swapi.co/api/planets?search=" + nomePlaneta;
		
		SwapiResponse response = restTemplate.getForObject(	url, SwapiResponse.class);
		
		if(response.getCount() == 0)
			throw new Exception(nomePlaneta + " inválido ou inexistente");
		
		for (PlanetResponse planetResponse: response.getResults()) {
			if (planetResponse.getName().equals(nomePlaneta)) {
				return planetResponse;
			}
		}
		
		throw new Exception(nomePlaneta + " inválido ou inexistente");
	}
}
