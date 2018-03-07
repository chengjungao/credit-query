package com.tsfa.credit.cq.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tsfa.credit.cq.app.entity.Credit;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
	
	@Query("select o from Credit o where o.pname = ?1 and o.idCard = ?2 and o.bizCode = ?3")
	public List<Credit> findAllByIdCard(String name,String idCard,int code);
}
