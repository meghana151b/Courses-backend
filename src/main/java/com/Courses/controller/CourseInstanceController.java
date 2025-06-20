package com.Courses.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Courses.entity.CourseInstance;
import com.Courses.service.CourseInstanceService;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {
	 @Autowired
	    private CourseInstanceService instanceService;

	    @PostMapping
	    public CourseInstance createInstance(@RequestBody Map<String, Object> payload) {
	        int year = (int) payload.get("year");
	        int semester = (int) payload.get("semester");
	        String courseId = (String) payload.get("courseId");

	        return instanceService.createInstance(year, semester, courseId);
	    }

	    @GetMapping("/{year}/{semester}")
	    public List<CourseInstance> getInstances(@PathVariable int year, @PathVariable int semester) {
	        return instanceService.getInstances(year, semester);
	    }

	    @GetMapping("/{year}/{semester}/{courseId}")
	    public CourseInstance getInstance(
	            @PathVariable int year,
	            @PathVariable int semester,
	            @PathVariable String courseId) {
	        return instanceService.getInstance(year, semester, courseId);
	    }

	    @DeleteMapping("/{year}/{semester}/{courseId}")
	    public void deleteInstance(
	            @PathVariable int year,
	            @PathVariable int semester,
	            @PathVariable String courseId) {
	        instanceService.deleteInstance(year, semester, courseId);
	    }

}
