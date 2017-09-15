package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating the student");
            student.setFirstName("Scooby");

            session.getTransaction().commit();

            session = factory.getCurrentSession();

            System.out.println("Update email for all students");

            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
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
