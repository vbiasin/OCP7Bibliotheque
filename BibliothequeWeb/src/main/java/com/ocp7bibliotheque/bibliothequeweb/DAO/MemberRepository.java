package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
