package hibernate.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {
            session.beginTransaction();

            List<Student> students = session
                .createQuery("from Student", Student.class)
                .getResultList();

            displayStudents(students);

            students =
                session
                    .createQuery(
                        "from Student s WHERE s.lastName ='Weidinger'",
                        Student.class
                    )
                    .getResultList();

            displayStudents(students);

            students =
                session
                    .createQuery(
                        "from Student s WHERE s.lastName ='Weidinger' OR s.firstName='Florian'",
                        Student.class
                    )
                    .getResultList();

            displayStudents(students);

            students =
                session
                    .createQuery(
                        "from Student s WHERE s.email LIKE '%gmx%'",
                        Student.class
                    )
                    .getResultList();

            displayStudents(students);
            session.getTransaction().commit();
        }
    }

    private static void displayStudents(List<Student> students) {
        students.stream().forEach(System.out::println);
    }
}
