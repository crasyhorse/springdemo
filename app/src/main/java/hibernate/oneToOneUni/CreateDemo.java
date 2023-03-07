package hibernate.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
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

            Instructor myInstructor1 = new Instructor(
                "Frank",
                "Weidinger",
                "frankweidinger@gmx.net"
            );
            InstructorDetail myInstructorDetail1 = new InstructorDetail(
                "youtube.com/franky",
                "coding"
            );

            myInstructor.setInstructorDetail(myInstructorDetail);
            myInstructor1.setInstructorDetail(myInstructorDetail1);
            session.beginTransaction();
            session.persist(myInstructor);
            session.persist(myInstructor1);
            session.getTransaction().commit();
        }
    }
}
