package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PKDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        ) {
            Session session = factory.getCurrentSession();
            Student tmpStudent1 = new Student(
                "Florian",
                "Weidinger",
                "crasyhorse@gmx.net"
            );
            Student tmpStudent2 = new Student(
                "Frank",
                "Weidinger",
                "crasyhorse@gmx.net"
            );
            Student tmpStudent3 = new Student(
                "Felix",
                "Weidinger",
                "crasyhorse@gmx.net"
            );

            session.beginTransaction();
            session.persist(tmpStudent1);
            session.persist(tmpStudent2);
            session.persist(tmpStudent3);
            session.getTransaction().commit();
        }
    }
}
