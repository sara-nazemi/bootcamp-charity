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
@Table(name = "CHARITY")
public class CharityEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME_CHARITY")
    private String nameCharity;
    @Column(name = "DESCRIPTION_CHARITY")
    private String descriptionCharity;
    @Column(name = "STATUS")
    private Boolean status;
    @Column(name = "IBAN")
    private String iban;
    @Column(name = "MERCHANT")
    private String merchant;
    @Column(name = "WALLET_ID")
    private Long walletId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "charity", cascade = CascadeType.PERSIST)
    private List<TransactionLogEntity> transactionLogs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity category;
}
