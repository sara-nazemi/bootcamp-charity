package com.example.bootcampcharity.models.dtoes;

import com.example.bootcampcharity.models.entities.CategoryEntity;
import com.example.bootcampcharity.models.entities.CharityStatus;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CharityDto extends BaseDto {
    private Long id;
    private String nameCharity;
    private String descriptionCharity;
    private CharityStatus status;
    private String iban;
    private String merchant;
    private Long walletId;

}
