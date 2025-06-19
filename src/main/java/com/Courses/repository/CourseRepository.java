package com.Courses.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Courses.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findByCourseId(String courseId);

}
