package com.example.jpa_entity_test.repository;

import com.example.jpa_entity_test.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}