package com.niladri.spring_boot_rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niladri.spring_boot_rest.Model.JobPost;
import com.niladri.spring_boot_rest.repo.JobRepo;
//import com.niladri.spring_boot_rest.service.*;


@Service
public class JobService
{
	
	@Autowired
	private JobRepo repo;
	public void addJob(JobPost jobpost)
	{
		repo.save(jobpost);
		
	}
	public List<JobPost>getAllJobs()
	{
		return repo.findAll();
		
	}
	public JobPost getJob(int postId) {
		
		return repo.findById(postId).orElse(new JobPost());
	}
	public void updateJob(JobPost jobpost) {
		repo.save(jobpost);
		
	}
	public void deleteJob(int postId) {
		repo.deleteById(postId);
		
	}
	public void load() {
		List<JobPost> jobs = new ArrayList<>(Arrays.asList(
				  new JobPost(1, "Java Developer", "Must have good experience in Core Java", 2, Arrays.asList("Java", "Spring Boot")),
				 new JobPost(2, "Frontend Developer", "Must have good experience in HTML, CSS, JS", 1, Arrays.asList("HTML", "CSS", "JavaScript")),
				  new JobPost(3, "React Developer", "Must have good experience in ReactJS", 1, Arrays.asList("ReactJS", "Redux"))
				));
		repo.saveAll(jobs);
		
	}
	public List<JobPost> search(String keyword) {
	
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}

	
}
