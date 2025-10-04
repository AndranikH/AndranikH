package au.com.telstra.simcardactivator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String iccid;
    private Boolean active;

    protected  Customer(){

    }

    public Customer(String customerEmail, String iccid, Boolean active){
        this.customerEmail = customerEmail;
        this.iccid = iccid;
        this.active = active;

    }


    public Long getId() {
        return this.id;
    }

    public String getcustomerEmail() {
        return customerEmail;
    }

    public String getIccid() {
        return iccid;
    }

    public Boolean getActive() {
        return active;
    }
}
