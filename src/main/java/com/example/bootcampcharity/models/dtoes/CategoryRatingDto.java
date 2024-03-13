package com.example.bootcampcharity.models.dtoes;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryRatingDto extends BaseDto {
    private Long id;
    private Long categoryId;
    private Long charityId;
    private Integer categoryVersion;
    private Integer charityVersion;
}
