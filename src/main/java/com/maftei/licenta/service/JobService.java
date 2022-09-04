package com.maftei.licenta.service;

import com.maftei.licenta.domain.Job;
import java.util.List;

public interface JobService {

	public abstract long countAllJobs();


	public abstract void deleteJob(Job job);


	public abstract Job findJob(Long id);


	public abstract List<Job> findAllJobs();


	public abstract List<Job> findJobEntries(int firstResult, int maxResults);


	public abstract void saveJob(Job job) throws NotEnoughMaterialInStockException;


	public abstract Job updateJob(Job job, double d) throws NotEnoughMaterialInStockException;

}
