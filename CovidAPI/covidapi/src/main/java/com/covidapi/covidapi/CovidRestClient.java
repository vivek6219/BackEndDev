package com.covidapi.covidapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CovidRestClient {
    @Value("${rapidapi.covid.url}")
    String covidUrl;

    @Value("${rapidapi.key.name}")
    String apiKeyName;

    @Value("${rapidapi.key.value}")
    String apiKeyValue;

    @Value("${rapidapi.host.name}")
    String hostName;

    @Value("${rapidapi.host.covid.value}")
    String hostValue;

    RestTemplate restTemplate;

    public CovidRestClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }
 

    public CovidTotal getTotals(){
        CovidTotal total = null;
        try{
            URI uri = new URI(covidUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.set(apiKeyName,apiKeyValue);
            headers.set(hostName,hostValue);
            headers.setContentType(MediaType.APPLICATION_JSON);

            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<CovidTotal[]> totalEntity = restTemplate.exchange(uri, HttpMethod.GET, request, CovidTotal[].class);
            total = totalEntity.getBody()[0];
        }catch(URISyntaxException e){
            e.printStackTrace();
        }

        return total;
    }


    public CovidTotal getCountryTotals(String country) {
        CovidTotal total =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        String date = sdf.format(new Date());
        try {
          HttpHeaders headers = new HttpHeaders();
          headers.set(apiKeyName, apiKeyValue);
          headers.set(hostName, hostValue);
          headers.setContentType(MediaType.APPLICATION_JSON);
          headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      
          Map<String, String> params = new HashMap<String, String>();
          params.put("format", "json");
          params.put("name", country);  //puts in USA into name WORKS
          params.put("date", date);    //puts in current date into name WORKS
          //=2020-04-01&name=USA
          String name = params.get("name");
          System.out.println("NAMEITHINK"+ name);
          System.out.println("DATEITHINK"+ params.get("date"));
          HttpEntity<String> request = new HttpEntity<String>(headers);
          //"?format={format}&name={name}&date={date}"

          //https://covid-19-data.p.rapidapi.com/report/country/name?date=2020-04-01&name=USA
          //https://covid-19-data.p.rapidapi.com/report/country/name?date=2021-59-14&name=USA

          covidUrl = covidUrl + "=" +date +"&" +"name"+"="+name;
          System.out.println("1" +"covidUrl:" +covidUrl );
          System.out.println("DATEITHINK: "+ date);
          ResponseEntity<CovidTotal[]> totalEntity = restTemplate.exchange(covidUrl, HttpMethod.GET,
              request, CovidTotal[].class, params);
      
          total = totalEntity.getBody()[0];

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
      }

}
