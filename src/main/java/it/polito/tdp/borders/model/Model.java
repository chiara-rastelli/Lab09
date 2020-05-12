package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	SimpleGraph<Country, DefaultEdge> grafo;
	BordersDAO db;
	Map<Integer, Country> mappaCountries;
	
	public Model() {
		db = new BordersDAO();
		mappaCountries = new HashMap<Integer, Country>();
		
		for (Country c : this.db.loadAllCountries()){
			this.mappaCountries.put(c.getCode(),c);
		}
	}
	
	public void creaGrafo(int anno) {
		
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
		
		for (Country c : this.mappaCountries.values())
			this.grafo.addVertex(c);
		
		for (Border b : this.db.getCountryPairs(anno, mappaCountries)) {
			DefaultEdge e = this.grafo.getEdge(b.getC1(), b.getC2());
			
			if (e == null) 
				this.grafo.addEdge(b.getC1(), b.getC2());
		}	
	}
}
