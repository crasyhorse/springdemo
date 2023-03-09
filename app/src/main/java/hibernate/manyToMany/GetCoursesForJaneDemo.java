package hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForJaneDemo {

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
            Student myStudent = session.get(Student.class, 2);

            System.out.println("\n\n");
            System.out.println(myStudent.getCourses());
            System.out.println("\n\n");
            
            session.getTransaction().commit();
        }
    }
}
