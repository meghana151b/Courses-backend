package com.Courses.dto;

import java.util.List;

public class CourseRequestDTO {
	 private String courseId;
	    private String title;
	    private String description;
	    private List<Long> prerequisites;

	    // Getters and Setters
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
	    public List<Long> getPrerequisites() {
	        return prerequisites;
	    }
	    public void setPrerequisites(List<Long> prerequisites) {
	        this.prerequisites = prerequisites;
	    }

}
