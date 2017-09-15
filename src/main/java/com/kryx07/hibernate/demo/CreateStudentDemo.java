package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Paul", "Wall", "paul@dupa.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
        }
    }
}
