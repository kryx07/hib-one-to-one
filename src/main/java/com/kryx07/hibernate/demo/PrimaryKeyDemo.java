package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student1 = new Student("John", "Doe", "John@dupa.com");
            Student student2 = new Student("Mary", "Public", "Mary@dupa.com");
            Student student3 = new Student("Bonita", "Applebaum", "bonita@dupa.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
        }
    }
}
