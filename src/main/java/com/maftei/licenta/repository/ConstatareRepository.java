package com.maftei.licenta.repository;

import com.maftei.licenta.domain.Constatare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstatareRepository extends JpaSpecificationExecutor<Constatare>, JpaRepository<Constatare, Long> {
}
