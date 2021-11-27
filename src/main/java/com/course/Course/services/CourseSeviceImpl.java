package com.course.Course.services;

import com.course.Course.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseSeviceImpl implements CourseSevises {
	
	List<Course>list;

	public CourseSeviceImpl(){
		list =new ArrayList<>();
		list.add(new Course(145,"Java Core Course","this is java course ..."));
		list.add(new Course(146,"Python Core Course","this is Python course ..."));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c= null;
		for(Course course : list){
			if(course.getId()==courseId){
				c=course;
				break;
			}

		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);

		return course;
	}

	//Delet Servive
	@Override
	public void deleteCourse(long courseId) {
		list=list.stream().filter(course ->{
			if (course.getId()!=courseId){
				return true;
			}else{
				return false;
			}
		}).collect(Collectors.toList());

	}

	@Override
	public void updateCourse(Course course, int courseId) {
		list.stream().map(course1 ->{
			if (course1.getId()==courseId){
				course1.setTitle(course.getTitle());
				course1.setDescription(course.getDescription());
			}
			return course1;
		}).collect(Collectors.toList());
	}

}
