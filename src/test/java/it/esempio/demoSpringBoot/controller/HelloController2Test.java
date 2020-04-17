package it.esempio.demoSpringBoot.controller;

import it.esempio.demoSpringBoot.application.DemoSpringBootApplication;
import it.esempio.demoSpringBoot.dto.HelloResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {DemoSpringBootApplication.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloController2Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testStatusOk() {
        HelloResponse actual = this.restTemplate.getForObject("/hello2/status", HelloResponse.class);
        HelloResponse expected = buildExpectedOkResponse();
        assertThat(actual).isEqualTo(expected);
    }

    private HelloResponse buildExpectedOkResponse() {
        HelloResponse res = new HelloResponse();
        res.setStatus("OK");
        return res;
    }
}

