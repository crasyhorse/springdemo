package hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForJaneDemo {

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

            Course myCourse1 = new Course("Q-Bert");
            Course myCourse2 = new Course("Snake-Rattle-And-Role");
            myCourse1.addStudent(myStudent);
            myCourse2.addStudent(myStudent);

            session.persist(myCourse1);
            session.persist(myCourse2);

            System.out.println("\n\n");
            System.out.println(myStudent.getCourses());
            System.out.println("\n\n");
            
            session.getTransaction().commit();
        }
    }
}
