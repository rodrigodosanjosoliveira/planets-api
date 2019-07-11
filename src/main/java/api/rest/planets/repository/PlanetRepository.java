package api.rest.planets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import api.rest.planets.models.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
	
	public Planet findByNome(String nome);
	
}
