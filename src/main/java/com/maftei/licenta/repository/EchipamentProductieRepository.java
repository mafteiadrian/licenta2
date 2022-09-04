package com.maftei.licenta.repository;

import com.maftei.licenta.domain.EchipamentProductie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EchipamentProductieRepository extends JpaSpecificationExecutor<EchipamentProductie>, JpaRepository<EchipamentProductie, Long> {
}
