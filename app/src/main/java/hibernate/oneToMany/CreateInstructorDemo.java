package hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
            Instructor myInstructor = new Instructor(
                "Florian",
                "Weidinger",
                "crasyhorse@gmx.net"
            );

            InstructorDetail myInstructorDetail = new InstructorDetail(
                "youtube.com/crasyhorse",
                "coding"
            );

            myInstructor.setInstructorDetail(myInstructorDetail);
            session.beginTransaction();
            session.persist(myInstructor);
            session.getTransaction().commit();
        }
    }
}
