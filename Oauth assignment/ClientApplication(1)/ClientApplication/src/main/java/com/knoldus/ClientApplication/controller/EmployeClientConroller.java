package com.knoldus.ClientApplication.controller;

import com.knoldus.ClientApplication.model.Employee;
import com.knoldus.ClientApplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeClientConroller {


    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Autowired
    EmployeeService employeeService;


//    @GetMapping("/getallemployee")
//    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token) {
//        var t = service.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
//            String s= t.getAccessToken().getTokenValue();
//
//        return ResponseEntity.ok(employeeService.getAllEmployees(s));
//    }

    /*public String extractTokenValue(OAuth2AuthenticationToken token) {
        OAuth2AuthenticatedPrincipal principal = token.getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();

        // Access specific attributes from the map
        String accessToken = (String) attributes.get("access_token");
        String userId = (String) attributes.get("sub");

        // Use the attribute values as needed
        return "Access Token: " + accessToken + ", User ID: " + userId;
    }*/

      /*  @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token) {
            // Use the attribute values as needed
            String clientRegistrationId = token.getAuthorizedClientRegistrationId();
            String userName = token.getName();
            System.out.println(token.getPrincipal().getAttributes());
            OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, userName);
           String accessTokenValue = authorizedClient.getAccessToken().getTokenValue();
            System.out.println("Access Token Value: " + token);
        return ResponseEntity.ok(employeeService.getAllEmployees(accessTokenValue));
    }*/

   /* @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token) {
        String clientRegistrationId = token.getAuthorizedClientRegistrationId();
        String userName = token.getName();

        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, userName);
        String accessTokenValue = authorizedClient.getAccessToken().getTokenValue();

        System.out.println("Access Token Value: " + accessTokenValue);

        return ResponseEntity.ok(employeeService.getAllEmployees(accessTokenValue));
    }
*/

    /*@GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token) {
        String clientRegistrationId = token.getAuthorizedClientRegistrationId();
        String userName = token.getName();

        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, userName);
      //  String accessTokenValue = authorizedClient.getAccessToken().getTokenValue();

        String tokenValue = (String) token.getPrincipal().getAuthorities().

     //   System.out.println("Access Token Value (OAuth2AuthorizedClient): " + accessTokenValue);
        System.out.println("Access Token Value (OAuth2AuthenticationToken): " + tokenValue);

        return ResponseEntity.ok(employeeService.getAllEmployees(tokenValue));
    }*/

  /*  @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token) {
        String clientRegistrationId = token.getAuthorizedClientRegistrationId();
        String userName = token.getName();

        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, userName);
        String accessTokenValue = authorizedClient.getAccessToken().getTokenValue();

        String tokenValue = null;
        Collection<? extends GrantedAuthority> authorities = token.getPrincipal().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority instanceof OAuth2AccessToken) {
                OAuth2AccessToken oauth2AccessToken = (OAuth2AccessToken) authority;
                tokenValue = oauth2AccessToken.getTokenValue();
                break;
            }
        }

        System.out.println("Access Token Value (OAuth2AuthorizedClient): " + accessTokenValue);
        System.out.println("Access Token Value (OAuth2AuthenticationToken): " + tokenValue);

        return ResponseEntity.ok(employeeService.getAllEmployees(accessTokenValue));
    }*/

    @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token, @AuthenticationPrincipal(expression = "idToken")OidcIdToken idToken) {
        System.out.println(idToken.getTokenValue());
        String tokenNew = (String) idToken.getTokenValue();
        System.out.println(tokenNew);
        return ResponseEntity.ok(employeeService.getAllEmployees(tokenNew));
    }





    @PostMapping("/addemployees")
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    /*@GetMapping("/test")
    public OAuth2AuthenticationToken testToken(OAuth2AuthenticationToken token) {
      //  var t = authorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
        return token;
    }
    @GetMapping("/token")
    public String Token(OAuth2AuthenticationToken token) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                token.getAuthorizedClientRegistrationId(),
                token.getName()
        );
        System.out.println(authorizedClient);
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        String jwtToken = accessToken.getTokenValue();

        return jwtToken;
    }*/

    @GetMapping("/test")
    public void getToken(OAuth2AuthenticationToken token, @AuthenticationPrincipal(expression = "idToken")OidcIdToken idToken) {
        System.out.println(idToken.getTokenValue());
        String tokenNew = (String) idToken.getTokenValue();
        System.out.println(tokenNew);
    }

//    @GetMapping("/test")
//    public OAuth2AuthenticationToken testToken(OAuth2AuthenticationToken token) {
//        String clientRegistrationId = token.getAuthorizedClientRegistrationId();
//        String userName = token.getName();
//        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, userName);
//        String accessTokenValue = authorizedClient.getAccessToken().getTokenValue();
//        System.out.println("Access Token Value: " + accessTokenValue);
//        return token;
//    }

}
