package com.example.bootcampcharity.services.serviceCall;

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
public class WalletServiceCallImpl implements WalletServiceCall{

    //https://docs.spring.io/spring-framework/docs/3.2.x/javadoc-api/org/springframework/test/web/client/MockRestServiceServer.html

    @Override
    public WalletServiceDto getWalletMock(String userName) {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        mockServer
                .expect(requestTo("/wallet/42"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"123\", \"code\" : \"xxx\"}", MediaType.APPLICATION_JSON));

        WalletServiceDto walletServiceDto = restTemplate.getForObject("/wallet/{userId}", WalletServiceDto.class, userName);

        mockServer.verify();
        return walletServiceDto;
    }

    @Override
    public WalletServiceDto depositWallet(Long walletId, Long amount) {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        mockServer
                .expect(requestTo("/wallet/deposit/123/1000"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"123\", \"code\" : \"xxx\"}", MediaType.APPLICATION_JSON));

        WalletServiceDto walletServiceDto = restTemplate.getForObject("/wallet/deposit/{id}/{amount}", WalletServiceDto.class, walletId,amount);

        mockServer.verify();
        return walletServiceDto;
    }

    @Override
    public WalletServiceDto withDrawWallet(Long walletId, Long amount) {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        mockServer
                .expect(requestTo("/wallet/withdraw/123/1000"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"123\", \"code\" : \"xxx\"}", MediaType.APPLICATION_JSON));

        WalletServiceDto walletServiceDto = restTemplate.getForObject("/wallet/withdraw/{id}/{amount}", WalletServiceDto.class, walletId,amount);

        mockServer.verify();
        return walletServiceDto;
    }
}
