package com.example.bootcampcharity.models.dtoes;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDto extends BaseDto {
    private Long id;
    private String nameCategory;
    private String descriptionCategory;
}
