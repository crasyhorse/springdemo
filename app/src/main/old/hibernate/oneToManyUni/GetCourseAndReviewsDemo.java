package hibernate.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {
        try (
            SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession();
        ) {


            session.beginTransaction();
            Course myCourse = session.get(Course.class, 1);
            System.out.println("\n\n");
            System.out.println(String.format("Course: %s", myCourse));
            System.out.println(String.format("Reviews: %s", myCourse.getReviews()));
            System.out.println("\n\n");
            session.getTransaction().commit();
        }
    }
}
