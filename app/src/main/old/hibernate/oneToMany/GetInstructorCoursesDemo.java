package hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

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

            System.out.println(String.format("Instructor: %s", myInstructor));

            System.out.println(String.format("Courses: %s", myInstructor.getCourses()));

            session.getTransaction().commit();
        }
    }
}
