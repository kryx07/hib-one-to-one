package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName ='Doe'").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%dupa%' Or s.firstName='Daffy'").getResultList();

            displayStudents(students);


            session.getTransaction().commit();


            System.out.println("Done");
        } finally {
            session.close();
        }
    }

    public static void displayStudents(List<Student> students) {
        System.out.println();
        System.out.println(students.size() + " student found");
        students.forEach(System.out::println);
    }
}
