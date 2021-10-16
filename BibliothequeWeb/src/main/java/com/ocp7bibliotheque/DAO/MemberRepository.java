package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
