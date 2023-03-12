package hibernate.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {
            session.beginTransaction();
            Instructor myInstructor = session.get(Instructor.class, 2);
            System.out.println(myInstructor);

            if (myInstructor != null) {
                session.remove(myInstructor);
            }

            session.getTransaction().commit();
        }
    }
}
