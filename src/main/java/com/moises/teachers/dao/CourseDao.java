package com.moises.teachers.dao;

import com.moises.teachers.model.Course;

import java.util.List;

public interface CourseDao {
	void saveCourse(Course course);
	void deleteCourseById(Long courseId);
	void updateCourse(Course course);
	List<Course> findAllCourses();
	Course findById(Long courseId);
	Course findByName(String name);
	List<Course> findByTeacherId(Long teacherId);
}
