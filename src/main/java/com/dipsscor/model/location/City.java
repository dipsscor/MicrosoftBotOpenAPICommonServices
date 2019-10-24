package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

@SerializedName("name")
@Expose
private String name;
@SerializedName("population")
@Expose
private Integer population;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getPopulation() {
return population;
}

public void setPopulation(Integer population) {
this.population = population;
}

}