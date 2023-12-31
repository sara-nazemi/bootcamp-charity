package com.example.bootcampcharity.models.dtoes;

import com.example.bootcampcharity.models.entities.CharityEntity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionLogDto extends BaseDto {
    private Long id;
    private Long amount;
    private Long charityId;
    private Integer versionCharity;
}
