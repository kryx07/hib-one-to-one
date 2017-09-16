package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Instructor;
import com.kryx07.hibernate.demo.entity.InstructorDetail;
import com.kryx07.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //Instructor instructor = new Instructor("Chad", "Darby", "email@email.com");
            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@email.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.madhu.com/youtube", "Guitar!!!");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
        }
    }
}
