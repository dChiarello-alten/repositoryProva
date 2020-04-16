package it.esempio.demoSpringBoot.controller;

import it.esempio.demoSpringBoot.application.DemoSpringBootApplication;
import it.esempio.demoSpringBoot.dto.HelloResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;


import static org.assertj.core.api.Assertions.assertThat;
@ContextConfiguration(classes={DemoSpringBootApplication.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getStatusOk() {
        HelloResponse actual = restTemplate.getForObject("/hello/status", HelloResponse.class);
        HelloResponse expected = buildExceptedOkResponse();
        assertThat(actual).isEqualTo(expected);
    }

    private HelloResponse buildExceptedOkResponse() {
        HelloResponse res = new HelloResponse();
        res.setStatus("OK");
        return res;
    }
}