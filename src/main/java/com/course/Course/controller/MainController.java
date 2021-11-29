package com.course.Course.controller;

import com.course.Course.entities.Course;
import com.course.Course.services.CourseSevises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
	
	//create veriable of service interface 
	@Autowired 
	private CourseSevises courseSevice;
	
//	this is for test 
	@GetMapping("/home")
	public String home() {
		return "this page ";
	}
	
	
//	get the course 
	@GetMapping("/courses")
	public List<Course>getCourses(){
//		called service panel 
		return this.courseSevice.getCourses();
	}

//	get course by ID
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId ) {
		return this.courseSevice.getCourse (Long.parseLong(courseId));
	}

//	Add new   Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course){
		return this.courseSevice.addCourse(course);
	}

	//Update
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course,@PathVariable ("courseId") int courseId){
		this.courseSevice.updateCourse(course,courseId);
		return course;
	}

//delet the course
	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") int courseId){

		this.courseSevice.deleteCourse(courseId);
	}




}
