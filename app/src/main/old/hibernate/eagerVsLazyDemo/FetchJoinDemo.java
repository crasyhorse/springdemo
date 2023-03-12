package hibernate.eagerVsLazyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .buildSessionFactory();
                Session session = factory.getCurrentSession();) {

            session.beginTransaction();
            Query<Instructor> query = session.createQuery("SELECT i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "WHERE i.id = :theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId", 7);

            Instructor myInstructor = query.getSingleResult();

            System.out.println(String.format("\nInstructor: %s\n", myInstructor));
            
            session.getTransaction().commit();

            session.close();

            System.out.println(String.format("\nCourses: %s\n", myInstructor.getCourses()));
        }
    }
}
