package com.example.bootcampcharity.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CATEGORYRATING")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryRating extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "CHARITY")
    private CharityEntity charity;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "CATEGORY")
    private CategoryEntity category;
}
