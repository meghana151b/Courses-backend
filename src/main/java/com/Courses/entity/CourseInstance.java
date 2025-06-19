package com.Courses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CourseInstance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int year;
	private int semester;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public CourseInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseInstance(Long id, int year, int semester, Course course) {
		super();
		this.id = id;
		this.year = year;
		this.semester = semester;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseInstance [id=" + id + ", year=" + year + ", semester=" + semester + ", course=" + course + "]";
	}
	
	

}
