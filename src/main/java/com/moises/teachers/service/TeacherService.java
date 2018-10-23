package com.moises.teachers.service;

import java.util.List;

import com.moises.teachers.model.Teacher;

public interface TeacherService {
	
	void saveTeacher(Teacher teacher);
	void deleteTeacherById(Long idTeacher);
	void updateTeacher(Teacher teacher);
	List<Teacher> findAllTeachers();
	Teacher findById(Long idTeacher);
	Teacher findByName(String name);
}
