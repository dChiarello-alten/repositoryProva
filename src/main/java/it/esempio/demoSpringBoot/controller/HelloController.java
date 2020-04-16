package it.esempio.demoSpringBoot.controller;

import it.esempio.demoSpringBoot.HelloResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloResponse getStatus() {
        HelloResponse res = new HelloResponse();
        res.setStatus("OK");
        return res;
    }


}
