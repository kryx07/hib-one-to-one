package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Instructor;
import com.kryx07.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateBiDirectDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //Instructor instructor = new Instructor("Chad", "Darby", "email@email.com");
//            Instructor instructor = new Instructor("Some", "Instructor", "madhu@email.com");

//            InstructorDetail instructorDetail = new InstructorDetail("http://www.madhu.com/youtube", "Guitar!!!");

//            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            int id = 2;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);
            System.out.println(instructorDetail);

            System.out.println(instructorDetail.getInstructor());

//            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
        }
    }
}
