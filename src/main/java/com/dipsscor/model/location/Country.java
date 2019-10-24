package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

@SerializedName("area_size")
@Expose
private String areaSize;
@SerializedName("capital")
@Expose
private String capital;
@SerializedName("code")
@Expose
private String code;
@SerializedName("is_in_eu")
@Expose
private Boolean isInEu;
@SerializedName("name")
@Expose
private String name;
@SerializedName("phone_code")
@Expose
private Long phoneCode;
@SerializedName("population")
@Expose
private Integer population;

public String getAreaSize() {
return areaSize;
}

public void setAreaSize(String areaSize) {
this.areaSize = areaSize;
}

public String getCapital() {
return capital;
}

public void setCapital(String capital) {
this.capital = capital;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public Boolean getIsInEu() {
return isInEu;
}

public void setIsInEu(Boolean isInEu) {
this.isInEu = isInEu;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Long getPhoneCode() {
return phoneCode;
}

public void setPhoneCode(Long phoneCode) {
this.phoneCode = phoneCode;
}

public Integer getPopulation() {
return population;
}

public void setPopulation(Integer population) {
this.population = population;
}

}