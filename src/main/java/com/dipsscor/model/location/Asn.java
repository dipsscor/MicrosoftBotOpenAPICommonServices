package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asn {

@SerializedName("number")
@Expose
private Integer number;
@SerializedName("organisation")
@Expose
private String organisation;

public Integer getNumber() {
return number;
}

public void setNumber(Integer number) {
this.number = number;
}

public String getOrganisation() {
return organisation;
}

public void setOrganisation(String organisation) {
this.organisation = organisation;
}

}