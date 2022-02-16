package com.ocp7bibliotheque.bibliothequeweb.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
