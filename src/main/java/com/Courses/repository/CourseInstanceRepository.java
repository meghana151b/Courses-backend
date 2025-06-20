package com.Courses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Courses.entity.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    Optional<CourseInstance> findByYearAndSemesterAndCourse_CourseId(int year, int semester, String courseId);
} 