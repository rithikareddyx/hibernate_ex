package com.example.employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Utility {
    private static SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	sessionFactory.close();
    }
}
