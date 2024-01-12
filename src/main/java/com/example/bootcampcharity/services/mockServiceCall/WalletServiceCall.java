package com.example.bootcampcharity.services.mockServiceCall;

import com.example.bootcampcharity.models.dtoes.TransactionLogDto;
import com.example.bootcampcharity.models.dtoes.serviceCall.WalletServiceDto;

import java.time.LocalDate;
import java.util.List;

public interface WalletServiceCall {
    WalletServiceDto getWalletMock(String phoneNumber);

    //List<TransactionLogDto> showTransaction(String phoneNumber);
    //List<TransactionLogDto> showTransactionBetween(String phoneNumber, LocalDate startDate,LocalDate endtDate);
    //Long getBalance(WalletServiceDto dto);

    WalletServiceDto depositWallet(Long walletId, Long amount);

    WalletServiceDto withDrawWallet(Long walletId, Long amount);

    //WalletServiceDto walletToWallet(Long walletId);
}