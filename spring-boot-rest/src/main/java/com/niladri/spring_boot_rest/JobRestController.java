	package com.niladri.spring_boot_rest;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;
	
	import com.niladri.spring_boot_rest.Model.JobPost;
	import com.niladri.spring_boot_rest.service.JobService;
	
	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
	public class JobRestController {
	
	    @Autowired
	    private JobService service;
	
	    @GetMapping("jobPosts")
	    public List<JobPost> getAllJobs() {
	        return service.getAllJobs();
	    }
	
	    @GetMapping("jobPost/{postId}")
	    public JobPost getJob(@PathVariable int postId) {
	        return service.getJob(postId);
	    }
	    
	    @GetMapping("jobPost/keyword/{keyword}")
	    public List<JobPost>searchByKeyword(@PathVariable ("keyword") String keyword){
	    return service.search(keyword);
	    }
	
	    @PostMapping("jobPost")
	    public JobPost addJob(@RequestBody JobPost jobpost) {
	        service.addJob(jobpost);
	        return service.getJob(jobpost.getPostId());
	    }
	
	    @PutMapping("jobPost")
	    public JobPost updateJob(@RequestBody JobPost jobpost) {
	        service.updateJob(jobpost);
	        return service.getJob(jobpost.getPostId());
	    }
	    @DeleteMapping("jobPost/{postId}")
	    public String deleteJob(@PathVariable int postId)
	    {
	    	service.deleteJob(postId);
	    	return "deleted";
	    }
	    @GetMapping("load")
	    public String loadData()
	    {	
	    	service.load();
	    	return "success";
	    }
	}
