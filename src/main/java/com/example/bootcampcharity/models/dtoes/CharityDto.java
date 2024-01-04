package com.example.bootcampcharity.models.dtoes;

import com.example.bootcampcharity.models.entities.CategoryEntity;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CharityDto extends BaseDto {
    private Long id;
    private String nameCharity;
    private String descriptionCharity;
    private Boolean status;
    private String iban;
    private String merchant;
    private Long walletId;
    private Long categoryId;
    private Integer versionCategory;
}
