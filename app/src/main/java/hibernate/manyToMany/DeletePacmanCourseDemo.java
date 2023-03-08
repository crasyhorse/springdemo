package hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {


            session.beginTransaction();
            Course myCourse = session.get(Course.class, 2);

            session.remove(myCourse);

            System.out.println("\n\n");

            System.out.println("\n\n");
            
            session.getTransaction().commit();
        }
    }
}
