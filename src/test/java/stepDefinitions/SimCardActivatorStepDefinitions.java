package stepDefinitions;

import au.com.telstra.simcardactivator.Customer;
import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.SimCardActivatorRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {



    @Autowired
    private TestRestTemplate restTemplate;
    private SimCardActivatorRepository repo;
    private String iccid;
    Customer record;

    @Given("The iccid is {string}")
    public void The_iccid_is(String iccid) {
        this.iccid = iccid;
    }

    @When("I check if the sim card is activated")
    public void I_check_if_the_sim_card_is_activated() {
        this.record = repo.findById(1L).orElse(null);
    }

    @Then("It should fail or succeed")
    public void It_should() {

        if (record != null && record.getActive()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }


    }
}