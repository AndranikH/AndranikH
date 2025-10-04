package au.com.telstra.simcardactivator;

public class SimActuator{
    private String iccid;
    public SimActuator(String iccid){
this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}
