package com.example.bootcampcharity.services.serviceCall;

import com.example.bootcampcharity.models.dtoes.serviceCall.WalletServiceDto;

public interface WalletServiceCall {
    WalletServiceDto getWalletMock(Long userId);

    WalletServiceDto depositWallet(Long WalletId, Long amount);

    WalletServiceDto withDrawWallet(Long walletId, Long amount);
}
