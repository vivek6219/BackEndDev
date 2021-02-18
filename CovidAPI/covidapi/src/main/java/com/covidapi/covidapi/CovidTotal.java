package com.covidapi.covidapi;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "country", 
  "confirmed",
  "recovered",
  "critical",
  "deaths", 
  "latitude",
  "longitude",
  "provinces" 
})


public class CovidTotal {

  @JsonProperty("country")
  private String country;

  @JsonProperty("provinces")
  private Map<String,String> provinces;

  @JsonProperty("provinces")
  private String province;

  @JsonProperty("confirmed")
  private Integer confirmed;
  @JsonProperty("recovered")
  private Integer recovered;
  @JsonProperty("critical")
  private Integer critical;
  @JsonProperty("deaths")
  private Integer deaths;
  @JsonProperty("latitude")
  private Double latitude;
  @JsonProperty("longitude")
  private Double longitude;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  @JsonProperty("country")
  public void setCountry(String country) {
    this.country = country;
  }

  @JsonProperty("confirmed")
  public Integer getConfirmed() {
    return confirmed;
  }

  @JsonProperty("confirmed")
  public void setConfirmed(Integer confirmed) {
    this.confirmed = confirmed;
  }

  @JsonProperty("recovered")
  public Integer getRecovered() {
    return recovered;
  }

  @JsonProperty("recovered")
  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }

  @JsonProperty("critical")
  public Integer getCritical() {
    return critical;
  }

  @JsonProperty("critical")
  public void setCritical(Integer critical) {
    this.critical = critical;
  }

  @JsonProperty("deaths")
  public Integer getDeaths() {
    return deaths;
  }

  @JsonProperty("deaths")
  public void setDeaths(Integer deaths) {
    this.deaths = deaths;
  }

  @JsonProperty("latitude")
  public Double getLatitude() {
    return latitude;
  }

  @JsonProperty("latitude")
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  @JsonProperty("longitude")
  public Double getLongitude() {
    return longitude;
  }

  @JsonProperty("longitude")
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @JsonProperty("provinces")
   public void setProvinces(Map<String, String> provinces) {
     this.province = provinces.get("province");
    this.provinces = provinces;
  }
  public Map<String, String> getProvinces() {
    return provinces;
  }
 
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}