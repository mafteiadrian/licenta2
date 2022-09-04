package com.maftei.licenta.repository;

import com.maftei.licenta.domain.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long>, JpaSpecificationExecutor<Utilizator> {
}
