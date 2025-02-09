package com.example.crudmember.repository;

import com.example.crudmember.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> id(Long id);
}
