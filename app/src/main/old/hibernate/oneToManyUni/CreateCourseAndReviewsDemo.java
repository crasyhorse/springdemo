package hibernate.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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
            Course myCourse = new Course("How to play Pacman");

            myCourse.addReview(new Review("Great job 1"));
            myCourse.addReview(new Review("Great job 2"));
            myCourse.addReview(new Review("Great job 3"));

            
            System.out.println("\n\n");
            System.out.println(myCourse);
            System.out.println(myCourse.getReviews());
            System.out.println("\n\n");

            session.persist(myCourse);
            
            session.getTransaction().commit();
        }
    }
}
