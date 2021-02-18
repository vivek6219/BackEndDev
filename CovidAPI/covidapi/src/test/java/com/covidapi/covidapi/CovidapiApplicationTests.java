package com.covidapi.covidapi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CovidapiApplicationTests {

	@Autowired
	CovidRestClient covidRestClient;

	/*
	@Test
	void contextLoads() {
		CovidTotal totals = covidClient.getTotals();
		System.out.println("Confirmed: " + totals.getConfirmed());
		System.out.println("Deaths: " + totals.getDeaths());
		System.out.println("Recovered: " + totals.getRecovered());
		assertTrue(Integer.parseInt(totals.getConfirmed()) > 0);
	}*/

	

	//trying to get the state values instead of total country values
	@Test
	public void testGetCountryTotal(){
		CovidTotal covidTotal = covidRestClient.getCountryTotals("USA");
		System.out.println("URLITHINK "+covidRestClient.covidUrl);
		System.out.println("Country: "+ covidTotal.getCountry());
		System.out.println("State: "+ covidTotal.getProvinces());
		System.out.println("Confirmed: " + covidTotal.getConfirmed());
		System.out.println("Deaths: " + covidTotal.getDeaths());
		System.out.println("Recovered " + covidTotal.getRecovered());
		assertTrue(covidTotal.getConfirmed() >= 0);
	}
}
