package com.moises.teachers.dao;

import java.util.Iterator;
import java.util.List;

import com.moises.teachers.model.Teacher;
import com.moises.teachers.model.TeacherSocialMedia;


public class TeacherDaoImpl extends AbstractSession implements TeacherDao {
	

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().persist(teacher);
	}

	public void deleteTeacherById(Long idTeacher) {
		// TODO Auto-generated method stub
		Teacher teacher = findById(idTeacher);
		if (teacher != null) {
			Iterator<TeacherSocialMedia> iterator = teacher.getTeacherSocialMedias().iterator();
			while(iterator.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = iterator.next();
				iterator.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedias().clear();
			getSession().delete(teacher);
		}
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().update(teacher);
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return (List<Teacher>) getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().
				createQuery("from Teacher where name = :name")
				.setParameter("name", name)
				.uniqueResult();
	}

}
