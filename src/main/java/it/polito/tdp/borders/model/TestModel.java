package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
//		System.out.println("Creo il grafo relativo al 2000");
//		model.createGraph(2000);
		
//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
		
		model.creaGrafo(1920);
		Set<DefaultEdge> listaEdge = model.grafo.edgeSet();
		
		/*for (DefaultEdge e : listaEdge) {
			System.out.println("Country c1 "+ model.grafo.getEdgeSource(e).getName()+", Country c2: "+model.grafo.getEdgeTarget(e).getName());
		}*/
		
		for (Country c : model.grafo.vertexSet()) {
			if(model.grafo.degreeOf(c)>0)
				System.out.println(c.getName()+": "+model.grafo.degreeOf(c)+" paesi adiacenti via terra");
		}
		
	}
	
}