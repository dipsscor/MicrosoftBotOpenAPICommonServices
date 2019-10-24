package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

@SerializedName("time")
@Expose
private String time;
@SerializedName("timezone")
@Expose
private String timezone;

public String getTime() {
return time;
}

public void setTime(String time) {
this.time = time;
}

public String getTimezone() {
return timezone;
}

public void setTimezone(String timezone) {
this.timezone = timezone;
}

}