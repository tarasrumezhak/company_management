package com.kindgeek.company_management;

import com.kindgeek.company_management.entity.Person;
import com.kindgeek.company_management.entity.Position;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testSimplePersonCreation() {
        Person person = new Person();
        person.setFirstName("Taras");
        person.setLastName("Rumezhak");
        assertThat(person.getFirstName() == "Taras" && person.getLastName() == "Rumezhak");
    }

    @Test
    public void testPersonCreation(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/person",
                HttpMethod.GET, entity, String.class);
        assertThat(Objects.equals(response.getBody(), "[]"));
        Person person = new Person();
        person.setFirstName("Taras");
        person.setLastName("Rumezhak");
        ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/person/add", person, Person.class);
        ResponseEntity<String> response2 = restTemplate.exchange(getRootUrl() + "/api/person",
                HttpMethod.GET, entity, String.class);
        assertThat(Objects.equals(response2.getBody(), "[{\"firstName\":\"Taras\",\"lastName\":\"Rumezhak\",\"id\":1,\"departmentInfo\":null,\"projectInfo\":null,\"positionInfo\":null}]"));
    }

}