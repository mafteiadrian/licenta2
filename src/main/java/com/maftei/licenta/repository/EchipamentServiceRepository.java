package com.maftei.licenta.repository;

import com.maftei.licenta.domain.EchipamentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EchipamentServiceRepository extends JpaSpecificationExecutor<EchipamentService>, JpaRepository<EchipamentService, Long> {
}
