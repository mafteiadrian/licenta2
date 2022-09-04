package com.maftei.licenta.service;

import com.maftei.licenta.domain.Job;
import com.maftei.licenta.repository.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	public long countAllJobs() {
		return jobRepository.count();
	}

	public void deleteJob(Job job) {
		jobRepository.delete(job);
	}

	public Job findJob(Long id) {
		return jobRepository.getReferenceById(id);
	}

	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	public List<Job> findJobEntries(int firstResult, int maxResults) {
		return jobRepository.findAll(
				PageRequest.of(firstResult
						/ maxResults, maxResults)).getContent();
	}

	public void saveJob(Job job) throws NotEnoughMaterialInStockException {
		updateMaterial(job);
		jobRepository.save(job);

	}

	private void updateMaterial(Job job, double... oldCantity)
			throws NotEnoughMaterialInStockException {

		Double cantitateMp = job.getMaterial().getCantitateMp();
		if (oldCantity.length > 0) {
			cantitateMp += oldCantity[0];
		}
		
		if (cantitateMp >= job.getDimensiuni().getLatime()
				* job.getDimensiuni().getLungime()) {
			cantitateMp -= job.getDimensiuni().getLatime()
					* job.getDimensiuni().getLungime();
			job.getMaterial().setCantitateMp(cantitateMp);
		} else {
			throw new NotEnoughMaterialInStockException();
		}
	}

	@Override
	public Job updateJob(Job job, double oldCantity) throws NotEnoughMaterialInStockException {
		updateMaterial(job, oldCantity);
		 return jobRepository.save(job);
	}
}
