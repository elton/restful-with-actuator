/*
 * @Author: Elton Zheng 
 * @Date: 2022-06-10 14:54:09 
 * @Last Modified by: Elton Zheng
 * @Last Modified time: 2022-06-10 15:52:03
 */
package ink.pwr.restfulwithactuator.controller;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ink.pwr.restfulwithactuator.domain.Greeting;

@Controller
public class HelloWorldController {
  private static final String TEMPLATE = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/hello-world")
  // The @ResponseBody annotation tells Spring MVC not to render a model into a
  // view but, rather, to write the returned object into the response body.
  // Jackson 2 is in the classpath, MappingJackson2HttpMessageConverter will
  // handle the conversion of a Greeting object to JSON
  @ResponseBody
  // curl localhost:9000/hello-world\?name=elton
  // `public Greeting sayHello(@RequestParam(name="name", required=false,
  // defaultValue="Stranger") String name) {`

  public Greeting sayHello(@RequestParam Optional<String> name) {
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name.orElseGet(() -> "Stranger")));
  }
}