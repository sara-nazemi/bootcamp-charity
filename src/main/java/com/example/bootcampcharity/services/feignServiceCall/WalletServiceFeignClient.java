package com.example.bootcampcharity.services.feignServiceCall;

import com.example.bootcampcharity.models.dtoes.serviceCall.*;
import org.hibernate.service.spi.ServiceException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "walletservice", url = "http://192.168.200.181:8082/wallet")
public interface WalletServiceFeignClient {
    @RequestMapping(value = "/getWallet", method = RequestMethod.GET, produces = "application/json")
    WalletResponseDto getWallet(@RequestBody WalletDto dto);

    @RequestMapping(value = "/walletToWallet", method = RequestMethod.POST, produces = "application/json")
    TransactionStatus walletToWallet(@RequestBody WalletTransactionDto dto) throws ServiceException;

    @RequestMapping(value = "/getBalance", method = RequestMethod.GET, produces = "application/json")
    Long getBalance(@RequestBody WalletDto dto) throws ServiceException;

    @RequestMapping(value = "/showTransaction/{phoneNumber}", method = RequestMethod.GET, produces = "application/json")
    List<WalletTransactionDtoResp> showTransaction(@PathVariable String phoneNumber) throws ServiceException;
}
