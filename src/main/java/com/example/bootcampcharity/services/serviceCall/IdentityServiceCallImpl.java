package com.example.bootcampcharity.services.serviceCall;

import com.example.bootcampcharity.models.dtoes.serviceCall.TokenValidityDto;
import com.example.bootcampcharity.models.dtoes.serviceCall.WalletServiceDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@Service
public class IdentityServiceCallImpl implements IdentityServiceCall{
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
