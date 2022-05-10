package com.example.jpa_entity_test.repository;

import com.example.jpa_entity_test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select c from Card c join fetch c.folder")
    List<Card> findAllIncludesFolder();
}