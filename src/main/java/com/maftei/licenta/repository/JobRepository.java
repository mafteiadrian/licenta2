package com.maftei.licenta.repository;

import com.maftei.licenta.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaSpecificationExecutor<Job>, JpaRepository<Job, Long> {
}
