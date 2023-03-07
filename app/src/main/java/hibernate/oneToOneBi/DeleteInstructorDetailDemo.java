package hibernate.oneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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
            InstructorDetail myInstructorDetail = session.get(InstructorDetail.class, 3);
            Instructor myInstructor = myInstructorDetail.getInstructor();

            myInstructorDetail.getInstructor().setInstructorDetail(null);
            session.remove(myInstructorDetail);
            System.out.println(myInstructor);
            session.getTransaction().commit();
        }
    }
}
