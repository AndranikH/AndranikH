package au.com.telstra.simcardactivator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")

public class Controller {


    private final RestTemplate restTemplate;

    public Controller(RestTemplate restTemplate) {
this.restTemplate = restTemplate;
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
    if(response != null && response.status()){
        return "Success!";
    } else {
        return "failure!";
    }

    }


}
