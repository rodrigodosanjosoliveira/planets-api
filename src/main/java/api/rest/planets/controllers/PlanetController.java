package api.rest.planets.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.rest.planets.models.Planet;
import api.rest.planets.models.dto.DetailPlanetDto;
import api.rest.planets.models.dto.PlanetDto;
import api.rest.planets.models.form.PlanetForm;
import api.rest.planets.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@GetMapping
	public List<PlanetDto> findAll() throws Exception {
		List<Planet> planets = planetService.getAll();
		return PlanetDto.converter(planets);
	}

	@PostMapping
	public ResponseEntity<PlanetDto> create(@RequestBody @Valid PlanetForm form, UriComponentsBuilder uriBuilder) throws Exception {
		
		Planet newPlanet = planetService.create(form.getNome(), form.getClima(), form.getTerreno());

		URI uri = uriBuilder.path("/planets/{id}").buildAndExpand(newPlanet.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlanetDto(newPlanet));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailPlanetDto> details(@PathVariable String id) throws Exception {
		Planet planet = planetService.getById(id);
		if(planet != null)
			return ResponseEntity.ok(new DetailPlanetDto(planet));
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteById(@PathVariable String id) throws Exception {
		Planet planet = planetService.getById(id);
		if(planet != null) {
			planetService.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
