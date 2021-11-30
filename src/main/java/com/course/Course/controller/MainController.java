package com.course.Course.controller;

import com.course.Course.entities.Course;
import com.course.Course.services.CourseSevises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<List<Course>> getCourses(){
//		called service panel 
		 List<Course> list=this.courseSevice.getCourses();
		 if(list.size()<=0){
		 	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(list));
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
