package com.example.bootcampcharity.models.dtoes;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DepositCharityInfoDto {
    private String userName;
    private Long charityId;
    private Long amount;
}
