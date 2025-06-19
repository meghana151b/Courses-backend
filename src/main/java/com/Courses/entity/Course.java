package com.Courses.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String courseId;
	private String title;
	private String description;
	
	  @ManyToMany
	    @JoinTable(
	        name = "course_prerequisites",
	        joinColumns = @JoinColumn(name = "course_id"),
	        inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
	    )
	  private List<Course> prerequisites = new ArrayList<>();

	  public Course() {
		super();
		// TODO Auto-generated constructor stub
	  }

	  public Course(Long id, String courseId, String title, String description, List<Course> prerequisites) {
		super();
		Id = id;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.prerequisites = prerequisites;
	  }

	  public Long getId() {
		  return Id;
	  }

	  public void setId(Long id) {
		  Id = id;
	  }

	  public String getCourseId() {
		  return courseId;
	  }

	  public void setCourseId(String courseId) {
		  this.courseId = courseId;
	  }

	  public String getTitle() {
		  return title;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public List<Course> getPrerequisites() {
		  return prerequisites;
	  }

	  public void setPrerequisites(List<Course> prerequisites) {
		  this.prerequisites = prerequisites;
	  }

	  @Override
	  public String toString() {
		return "Course [Id=" + Id + ", courseId=" + courseId + ", title=" + title + ", description=" + description
				+ ", prerequisites=" + prerequisites + "]";
	  }
	  
	  

}
