package it.polito.tdp.borders.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

		System.out.println("Lista di tutte le nazioni:");
		List<Country> countries = dao.loadAllCountries();
		Map<Integer, Country> mappaCountries = new HashMap<Integer, Country>();
		
		for (Country c : countries) {
			mappaCountries.put(c.getCode(), c);
	//		System.out.println(c.getName());
		}
		
		List<Border> bordi = dao.getCountryPairs(1920, mappaCountries);
		for (Border b : bordi)
			System.out.println(b.getC1().getName()+" - "+b.getC2().getName());
		
	}
}
