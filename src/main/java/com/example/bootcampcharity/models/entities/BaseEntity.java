package com.example.bootcampcharity.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    private static final long serialVersionUID = 1234567L;

    @CreatedDate
    @Column(updatable = false)
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Version
    private Integer version;

    @PrePersist
    protected void onCreate() {
        this.insertDate = this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }
}
