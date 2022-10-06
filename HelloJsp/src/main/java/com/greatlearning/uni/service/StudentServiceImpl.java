package com.greatlearning.uni.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.uni.model.Student;

@Repository
public class StudentServiceImpl implements StudentService{

	SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	public StudentServiceImpl (SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		try {
			this.session=sessionFactory.getCurrentSession();
			
		}catch (HibernateException he) {
			this.session=sessionFactory.openSession();
		}
	}
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		
		List<Student> list = session.createQuery("from Student").list();
		return list;
	}

	@Override
//	@Transactional
	public void save(Student student) {
		Transaction tx = session.beginTransaction();
		session.save(student);
		((EntityTransaction) tx).commit();
	}

	@Override
	//@Transactional
	public Student delete(int id) {
		Transaction tx = session.beginTransaction();
		Student student= session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		
		return session.get(Student.class, id);
	}

}
