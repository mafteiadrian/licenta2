package com.maftei.licenta.repository;

import com.maftei.licenta.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaSpecificationExecutor<Material>, JpaRepository<Material, Long> {
}
