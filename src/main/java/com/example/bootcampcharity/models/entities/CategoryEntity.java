package com.example.bootcampcharity.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String nameCategory;
    @Column(name = "DESCRIPTION")
    private String descriptionCategory;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<CategoryRating> categoryRatings;
}
