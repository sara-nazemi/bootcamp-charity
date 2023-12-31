package com.example.bootcampcharity.mock;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WalletService {
    private Long id;
    private Long userId;
    private Long balance;
    private String code;
    private Boolean status;
}
