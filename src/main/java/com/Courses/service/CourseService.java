package com.Courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Courses.dto.CourseRequestDTO;
import com.Courses.entity.Course;
import com.Courses.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // ✅ Updated to use DTO
    public Course createCourse(CourseRequestDTO requestDTO) {
        Course course = new Course();
        course.setCourseId(requestDTO.getCourseId());
        course.setTitle(requestDTO.getTitle());
        course.setDescription(requestDTO.getDescription());

        List<Course> prerequisites = new ArrayList<>();
        for (Long preId : requestDTO.getPrerequisites()) {
            Course prerequisite = courseRepository.findById(preId)
                    .orElseThrow(() -> new RuntimeException("Invalid prerequisite: " + preId));
            prerequisites.add(prerequisite);
        }

        course.setPrerequisites(prerequisites);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        List<Course> allCourses = courseRepository.findAll();
        for (Course c : allCourses) {
            if (c.getPrerequisites().contains(course)) {
                throw new IllegalStateException("Cannot delete course. It is a prerequisite for other courses.");
            }
        }

        courseRepository.delete(course);
    }
}
