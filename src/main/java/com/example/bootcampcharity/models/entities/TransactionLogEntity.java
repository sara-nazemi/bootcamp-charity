package com.example.bootcampcharity.models.entities;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TRANSACTION_LOG")
public class TransactionLogEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "AMOUNT")
    private Long amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHARITY_ID", nullable = false)
    private CharityEntity charity;


}
