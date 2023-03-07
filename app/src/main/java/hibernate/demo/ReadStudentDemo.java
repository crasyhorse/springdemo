package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        ) {
            Session session = factory.getCurrentSession();
            Student tmpStudent = new Student(
                "Daffy",
                "Duck",
                "daffyduck@gmx.net"
            );

            session.beginTransaction();
            session.persist(tmpStudent);
            session.getTransaction().commit();

            System.out.println(
                String.format("Saved student's id: %S", tmpStudent.getId())
            );
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, tmpStudent.getId());
            System.out.println(String.format("Get complete: %s", myStudent));
            session.getTransaction().commit();
        }
    }
}
