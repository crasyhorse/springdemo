package hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {


            session.beginTransaction();
            Instructor myInstructor = session.get(Instructor.class, 7);

            Course c1 = new Course("Java for beginners");
            Course c2 = new Course("JavaScript for beginners");

            myInstructor.add(c1);
            myInstructor.add(c2);

            session.persist(c1);
            session.persist(c2);

            session.getTransaction().commit();
        }
    }
}
