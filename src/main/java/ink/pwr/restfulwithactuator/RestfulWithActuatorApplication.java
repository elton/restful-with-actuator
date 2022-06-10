package ink.pwr.restfulwithactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation also brings in a @ComponentScan annotation, which tells Spring to scan the ink.pwr.restfulwithactuator package for those controllers
@SpringBootApplication
public class RestfulWithActuatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestfulWithActuatorApplication.class, args);
  }
}
