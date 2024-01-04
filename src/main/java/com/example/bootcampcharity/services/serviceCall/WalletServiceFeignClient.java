package com.example.bootcampcharity.services.serviceCall;

import com.example.bootcampcharity.models.dtoes.serviceCall.*;
import org.hibernate.service.spi.ServiceException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "walletservice", url = "http://localhost:8083")
public interface WalletServiceFeignClient {

    @GetMapping("/getWallet")
    WalletResponseDto getWallet(@RequestBody WalletDto dto);

    @PostMapping("/walletToWallet")
    public TransactionStatus walletToWallet(@RequestBody WalletTransactionDto dto) throws ServiceException;

    @GetMapping("/getBalance")
    public Long getBalance(@RequestBody WalletDto dto) throws ServiceException;

    @GetMapping("/showTransaction/{phoneNumber}")
    public List<WalletTransactionDtoResp> showTransaction(@PathVariable String phoneNumber) throws ServiceException;
}
