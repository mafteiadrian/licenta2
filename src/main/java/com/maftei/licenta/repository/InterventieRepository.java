package com.maftei.licenta.repository;

import com.maftei.licenta.domain.Interventie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventieRepository extends JpaSpecificationExecutor<Interventie>, JpaRepository<Interventie, Long> {
}
