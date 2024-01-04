package com.example.bootcampcharity.services.serviceCall;


import com.example.bootcampcharity.models.dtoes.serviceCall.TokenValidityResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "identityService", url = "http://localhost:8082")
public interface IdentityServiceFeignClient {

    @RequestMapping(value = "/tokenVerify", method = RequestMethod.POST)
    ResponseEntity<TokenValidityResponseDto> checkTokenValidity(@RequestHeader("Authorization") String token,
                                                                @RequestHeader("lang") String lang);



}
