package com.example.bootcampcharity.models.dtoes.serviceCall;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletResponseDto {
    private Long balance;
    private String walletCode;
    private WalletStatus status;
    private String phoneNumber; }
