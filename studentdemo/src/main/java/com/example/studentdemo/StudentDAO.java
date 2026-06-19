package com.example.studentdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    private SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Student s) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    public List<Student> findAll() {
        Session session = getSession();
        List<Student> students = session.createQuery("FROM Student", Student.class).list();
        session.close();
        return students;
    }

    public void update(Student s) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.merge(s);
        tx.commit();
        session.close();
    }

	public Student findById(int sid) {
        Session session = getSession();
        Student student = session.find(Student.class, sid);
        session.close();
        return student;
    }


    public void delete(int sid) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.find(Student.class, sid);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
    }
}