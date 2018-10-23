package com.moises.teachers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.teachers.dao.CourseDao;
import com.moises.teachers.model.Course;


@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.saveCourse(course);
	}

	@Override
	public void deleteCourseById(Long courseId) {
		// TODO Auto-generated method stub
		courseDao.deleteCourseById(courseId);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.updateCourse(course);
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAllCourses();
	}

	@Override
	public Course findById(Long courseId) {
		// TODO Auto-generated method stub
		return courseDao.findById(courseId);
	}

	@Override
	public Course findByName(String name) {
		// TODO Auto-generated method stub
		return courseDao.findByName(name);
	}

	@Override
	public List<Course> findByTeacherId(Long teacherId) {
		// TODO Auto-generated method stub
		return courseDao.findByTeacherId(teacherId);
	}

}
