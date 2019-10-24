package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

@SerializedName("area")
@Expose
private Area area;
@SerializedName("asn")
@Expose
private Asn asn;
@SerializedName("city")
@Expose
private City city;
@SerializedName("continent")
@Expose
private Continent continent;
@SerializedName("country")
@Expose
private Country country;
@SerializedName("currency")
@Expose
private Currency currency;
@SerializedName("ip")
@Expose
private String ip;
@SerializedName("location")
@Expose
private Location_ location;
@SerializedName("postcode")
@Expose
private String postcode;
@SerializedName("security")
@Expose
private Security security;
@SerializedName("status")
@Expose
private String status;
@SerializedName("time")
@Expose
private Time time;
@SerializedName("type")
@Expose
private String type;

public Area getArea() {
return area;
}

public void setArea(Area area) {
this.area = area;
}

public Asn getAsn() {
return asn;
}

public void setAsn(Asn asn) {
this.asn = asn;
}

public City getCity() {
return city;
}

public void setCity(City city) {
this.city = city;
}

public Continent getContinent() {
return continent;
}

public void setContinent(Continent continent) {
this.continent = continent;
}

public Country getCountry() {
return country;
}

public void setCountry(Country country) {
this.country = country;
}

public Currency getCurrency() {
return currency;
}

public void setCurrency(Currency currency) {
this.currency = currency;
}

public String getIp() {
return ip;
}

public void setIp(String ip) {
this.ip = ip;
}

public Location_ getLocation() {
return location;
}

public void setLocation(Location_ location) {
this.location = location;
}

public String getPostcode() {
return postcode;
}

public void setPostcode(String postcode) {
this.postcode = postcode;
}

public Security getSecurity() {
return security;
}

public void setSecurity(Security security) {
this.security = security;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Time getTime() {
return time;
}

public void setTime(Time time) {
this.time = time;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

}