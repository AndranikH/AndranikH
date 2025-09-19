package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActuatorResponse {
    @JsonProperty("success")
private boolean status;
public ActuatorResponse(){

}
public boolean status(){
    return status;
}
public void setStatus(boolean status){
    this.status = status;
}
}
