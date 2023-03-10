package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        ) {
            Session session = factory.getCurrentSession();
            int studentId = 3;

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Bugs");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            session
                .createQuery("Update Student SET email='gmail.com'")
                .executeUpdate();

            session.getTransaction().commit();
        }
    }
}
