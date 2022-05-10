package com.example.jpa_entity_test.repository;

import com.example.jpa_entity_test.entity.Ddabong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DdabongRepository extends JpaRepository<Ddabong, Long> {
    @Query("select dd from Ddabong dd join fetch dd.member")
    List<Ddabong> findAllIncludesMember();

    @Query("select dd from Ddabong dd join fetch dd.tag")
    List<Ddabong> findAllIncludesTag();
}