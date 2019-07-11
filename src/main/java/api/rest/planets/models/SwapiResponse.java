package api.rest.planets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResponse {

	private Integer count;

	private PlanetResponse[] results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public PlanetResponse[] getResults() {
		return results;
	}

	public void setResults(PlanetResponse[] planetsResponse) {
		this.results = planetsResponse;
	}
}
