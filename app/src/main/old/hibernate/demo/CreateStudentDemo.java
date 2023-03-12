package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {
            Student tmpStudent = new Student(
                "Florian",
                "Weidinger",
                "crasyhorse@gmx.net"
            );

            session.beginTransaction();
            session.persist(tmpStudent);
            session.getTransaction().commit();
        }
    }
}
