package ink.pwr.restfulwithactuator;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class HelloWorldApplicatonTest {

  @LocalServerPort
  private int port;

  @Value("${local.management.port}")
  private int mgt;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void shouldReturn200WhenSendingRequestToController() throws Exception {

    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/hello-world",
        Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.restTemplate.getForEntity("http://localhost:" + this.mgt + "/actuator", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}