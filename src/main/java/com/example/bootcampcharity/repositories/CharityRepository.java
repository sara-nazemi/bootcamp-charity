package com.example.bootcampcharity.repositories;

import com.example.bootcampcharity.models.entities.CharityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<CharityEntity,Long> {
}
