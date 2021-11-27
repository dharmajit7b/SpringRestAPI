package com.course.Course.services;

import com.course.Course.entities.Course;

import java.util.List;

public interface CourseSevises {
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);

	public Course addCourse(Course course);
	public void deleteCourse (long courseId);

	public void updateCourse(Course course, int courseId);
}
