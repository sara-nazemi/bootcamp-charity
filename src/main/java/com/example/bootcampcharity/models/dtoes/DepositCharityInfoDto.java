package com.example.bootcampcharity.models.dtoes;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepositCharityInfoDto {
    private Long userId;
    private Long charityId;
    private Long amount;
}
