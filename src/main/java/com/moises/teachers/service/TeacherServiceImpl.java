package com.moises.teachers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.teachers.dao.TeacherDao;
import com.moises.teachers.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.saveTeacher(teacher);
	}

	@Override
	public void deleteTeacherById(Long idTeacher) {
		// TODO Auto-generated method stub
		teacherDao.deleteTeacherById(idTeacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return teacherDao.findAllTeachers();
	}

	@Override
	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return teacherDao.findById(idTeacher);
	}

	@Override
	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return teacherDao.findByName(name);
	}

}
