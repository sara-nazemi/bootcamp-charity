package com.example.bootcampcharity.models.dtoes.serviceCall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WalletTransactionDto {
    private String receiverWalletCode;
    private String senderWalletCode;
    private String phoneNumber;
    private Long amount;
    private TransactionType transactionType;
}
