package com.dipsscor.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {

@SerializedName("is_crawler")
@Expose
private Boolean isCrawler;
@SerializedName("is_proxy")
@Expose
private Boolean isProxy;
@SerializedName("is_thread")
@Expose
private Boolean isThread;
@SerializedName("is_tor")
@Expose
private Boolean isTor;

public Boolean getIsCrawler() {
return isCrawler;
}

public void setIsCrawler(Boolean isCrawler) {
this.isCrawler = isCrawler;
}

public Boolean getIsProxy() {
return isProxy;
}

public void setIsProxy(Boolean isProxy) {
this.isProxy = isProxy;
}

public Boolean getIsThread() {
return isThread;
}

public void setIsThread(Boolean isThread) {
this.isThread = isThread;
}

public Boolean getIsTor() {
return isTor;
}

public void setIsTor(Boolean isTor) {
this.isTor = isTor;
}

}