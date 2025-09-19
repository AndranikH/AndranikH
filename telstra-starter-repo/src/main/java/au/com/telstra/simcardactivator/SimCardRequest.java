package au.com.telstra.simcardactivator;



public class SimCardRequest{
   private String iccid;
   private String customerEmail;

    public SimCardRequest() {
    }
    public String getIccid(){
        return this.iccid;
    }
    public String getEmail(){
        return this.customerEmail;
    }
    public void setIccid(String iccid){
        this.iccid = iccid;
    }
    public void setEmail(String customeremail){
        this.customerEmail = customerEmail;
    }
}
