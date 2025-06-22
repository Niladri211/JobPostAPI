package com.niladri.spring_boot_rest.repo;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niladri.spring_boot_rest.Model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
	List<JobPost>findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}


//
//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//   new JobPost(1, "Java Developer", "Must have good experience in Core Java", 2, Arrays.asList("Java", "Spring Boot")),
//  new JobPost(2, "Frontend Developer", "Must have good experience in HTML, CSS, JS", 1, Arrays.asList("HTML", "CSS", "JavaScript")),
//  new JobPost(3, "React Developer", "Must have good experience in ReactJS", 1, Arrays.asList("ReactJS", "Redux"))
//));
//public JobPost getJob(int postId)
//{
//	for(JobPost job:jobs) {
//		if(job.getPostId() ==postId)
//			return job;
//	}
//	return null;
//}
//
//public List<JobPost> getAllJobs() {
//  return jobs;
//}
//
//public void addJob(JobPost job) {
//  jobs.add(job);
//  System.out.println(jobs);
//}
//
//public void updateJob(JobPost jobpost) {
//	for(JobPost jobPost1:jobs) {
//		if(jobPost1.getPostId()==jobpost.getPostId())
//		{
//			jobPost1.setPostProfile(jobpost.getPostProfile());
//			jobPost1.setPostDesc(jobpost.getPostDesc());
//			jobPost1.setReqExperience(jobPost1.getReqExperience());
//			jobPost1.setPostTechStack(jobPost1.getPostTechStack());
//			
//		}
//	}
//	
//
//	
//}
//
//public void deleteJob(int postId) {
//	for(JobPost jobPost:jobs)
//	{
//		if(jobPost.getPostId()==postId)
//			jobs.remove(jobPost);
//	}
//	
//}

