package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        ) {
            Session session = factory.getCurrentSession();
            int studentId = 1;
            
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            session.remove(myStudent);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session
                .createMutationQuery("DELETE FROM student WHERE id=4")
                .executeUpdate();

            session.getTransaction().commit();
        }
    }
}
