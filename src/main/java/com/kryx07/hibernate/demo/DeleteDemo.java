package com.kryx07.hibernate.demo;

import com.kryx07.hibernate.demo.entity.Instructor;
import com.kryx07.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //Instructor instructor = new Instructor("Chad", "Darby", "email@email.com");


            session.beginTransaction();

            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            if (instructor != null) {
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
        }
    }
}
