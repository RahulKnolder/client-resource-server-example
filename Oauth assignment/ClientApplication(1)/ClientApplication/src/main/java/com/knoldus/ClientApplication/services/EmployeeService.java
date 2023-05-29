package com.knoldus.ClientApplication.services;

import com.knoldus.ClientApplication.controller.EmployeClientConroller;
import com.knoldus.ClientApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;



//
//    public List<Employee> getAllEmployes( @RegisteredOAuth2AuthorizedClient("spring.security.oauth2.client.registration.google.client-id")OAuth2AuthorizedClient auth2AuthorizedClient){
//        String accessToken= auth2AuthorizedClient.getAccessToken().getTokenValue();
//         String url = "http://localhost:9090/getemployees";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization" ,"Brearer" + accessToken);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
//        return restTemplate.exchange(url, HttpMethod.GET, entity, List.class).getBody();
//
//    }

//
//    public List<Employee> getAllEmployes(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
//        return restTemplate.exchange("http://localhost:9090/getemployees", HttpMethod.GET, entity, List.class).getBody();
//    }

        public List<Employee> getAllEmployees(String accessToken) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.setBearerAuth(accessToken); // Include the access token in the request headers
            headers.set("Authorization", "Bearer "+accessToken);
            HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
            System.out.println("header ---------------   "+headers);
            ResponseEntity<List<Employee>> response = restTemplate.exchange(
                    "http://localhost:9090/getemployees",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<Employee>>() {}
            );
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                // Handle error case
                return Collections.emptyList();
            }
        }


//    public List<Employee> getAllEmployees(String accessToken) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setBearerAuth(accessToken); // Include the access token in the request headers
//        HttpEntity<Employee> entity = new HttpEntity<>(headers);
//        return restTemplate.exchange("http://localhost:9090/getemployees", HttpMethod.GET, entity, List.class).getBody();
//    }




    public Employee addEmployee(Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
        return restTemplate.exchange("http://localhost:9090/getemployees", HttpMethod.POST, entity, Employee.class).getBody();
    }

}
