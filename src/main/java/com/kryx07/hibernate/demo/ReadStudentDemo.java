package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Daffy", "Duck", "duffy@dupa.com");

            session.beginTransaction();

            System.out.println("About to save " + student);
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id " + student.getId());

            Student retrievedStudent = session.get(Student.class, student.getId());

            session.getTransaction().commit();

            System.out.println("I got the student from the db: " + retrievedStudent);


            System.out.println("Done");
        } finally {
            session.close();
        }
    }
}
