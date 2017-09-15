package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            int studentId = 5;
            session = factory.getCurrentSession();
            session.beginTransaction();

//            System.out.println("Getting student with id: " + studentId);

            /*Student student = session.get(Student.class, studentId);



            session.delete(student);*/

            session.createQuery("delete Student where id=" + studentId).executeUpdate();

            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();

            students.forEach(System.out::println);
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
