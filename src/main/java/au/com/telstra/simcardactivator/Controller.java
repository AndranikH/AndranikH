package au.com.telstra.simcardactivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api")

public class Controller {

   private SimCardActivatorRepository repo;

    private final RestTemplate restTemplate;
@Autowired
    public Controller(RestTemplate restTemplate, SimCardActivatorRepository repo) {
this.restTemplate = restTemplate;
this.repo = repo;

    }

    //add bean for RestTemplate next time u open this program
    //Controller almost done
    //Controller get iccid and email, takes out iccid, sends request to actuator, gets back boolean

    @PostMapping("/activate")
    public String activate(@RequestBody SimCardRequest request){
    String iccid = request.getIccid();
    SimActuator actuatorRequest = new SimActuator(request.getIccid());
    ActuatorResponse response = restTemplate.postForObject(
            "http://localhost:8444/actuate",
            actuatorRequest,
            ActuatorResponse.class);
    boolean access = response != null && response.status();
    Customer record = new Customer(request.getcustomerEmail(),iccid,access);
    repo.save(record);
    if(access){
        return "Success!";
    } else {
        return "failure!";
    }

    }

    @GetMapping("/activation")
    public Customer getActivation(@RequestParam long simCardId){
        Optional<Customer> GETrecord = repo.findById((simCardId));
        return GETrecord.orElse(null);
    }




}
