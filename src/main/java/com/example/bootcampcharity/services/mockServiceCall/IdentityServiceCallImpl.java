package com.example.bootcampcharity.services.mockServiceCall;

import com.example.bootcampcharity.services.mockServiceCall.IdentityServiceCall;
import org.springframework.stereotype.Service;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@Service
public class IdentityServiceCallImpl implements IdentityServiceCall {
//    @Override
//    public TokenValidityDto checkValidityToken(String token) {
//        RestTemplate restTemplate = new RestTemplate();
//        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
//
//        mockServer
//                .expect(requestTo("/identityService/xxx"))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withSuccess("{ \"isValid\" : \"true\"}", MediaType.APPLICATION_JSON));
//
//        TokenValidityDto tokenValidityDto  = restTemplate.getForObject("/identityService/{token}", TokenValidityDto.class, token);
//
//        //mockServer.verify();
//        return tokenValidityDto;
//    }
}
