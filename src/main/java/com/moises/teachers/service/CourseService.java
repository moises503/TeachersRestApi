package com.moises.teachers.service;

import java.util.List;

import com.moises.teachers.model.Course;

public interface CourseService {
	void saveCourse(Course course);
	void deleteCourseById(Long courseId);
	void updateCourse(Course course);
	List<Course> findAllCourses();
	Course findById(Long courseId);
	Course findByName(String name);
	List<Course> findByTeacherId(Long teacherId);
}
