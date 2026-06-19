package com.example.employee;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {

    private SessionFactory sessionFactory;

    public EmployeeDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Employee e) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.persist(e);
        tx.commit();
        session.close();
    }

    public List<Employee> findAll() {
        Session session = getSession();
        List<Employee> emps = session.createQuery("FROM Employee", Employee.class).list();
        session.close();
        return emps;
    }

    public void update(Employee e) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.merge(e);
        tx.commit();
        session.close();
    }

	public Employee findById(int sid) {
        Session session = getSession();
        Employee emp = session.find(Employee.class, sid);
        session.close();
        return emp;
    }


    public void delete(int sid) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.find(Employee.class, sid);
        if (emp != null) {
            session.remove(emp);
        }
        tx.commit();
        session.close();
    }
}