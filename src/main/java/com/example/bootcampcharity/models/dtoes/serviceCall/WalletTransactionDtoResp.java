package com.example.bootcampcharity.models.dtoes.serviceCall;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    public class WalletTransactionDtoResp {
        private Long amount;
        private LocalDateTime dateTime;
        private TransactionType transactionType;
        private TransactionStatus status;
        private DepositWithdraw depositWithdraw;

}
