package com.Courses.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Courses.entity.Course;
import com.Courses.entity.CourseInstance;
import com.Courses.repository.CourseInstanceRepository;
import com.Courses.repository.CourseRepository;

@Service
public class CourseInstanceService {
	
	  @Autowired
	    private CourseInstanceRepository instanceRepository;

	    @Autowired
	    private CourseRepository courseRepository;

	    public CourseInstance createInstance(int year, int semester, String courseId) {
	        Course course = courseRepository.findByCourseId(courseId)
	                .orElseThrow(() -> new NoSuchElementException("Course not found: " + courseId));

	        CourseInstance instance = new CourseInstance();
	        instance.setYear(year);
	        instance.setSemester(semester);
	        instance.setCourse(course);

	        return instanceRepository.save(instance);
	    }

	    public List<CourseInstance> getInstances(int year, int semester) {
	        return instanceRepository.findByYearAndSemester(year, semester);
	    }

	    public CourseInstance getInstance(int year, int semester, String courseId) {
	        return instanceRepository.findByYearAndSemesterAndCourse_CourseId(year, semester, courseId)
	                .orElseThrow(() -> new NoSuchElementException("Course instance not found"));
	    }

	    public void deleteInstance(int year, int semester, String courseId) {
	        CourseInstance instance = getInstance(year, semester, courseId);
	        instanceRepository.delete(instance);
	    }

}
