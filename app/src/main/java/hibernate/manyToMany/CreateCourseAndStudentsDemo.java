package hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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
            Course myCourse = new Course("How to play Pacman");

           
            System.out.println("\n\n");
            System.out.println("Saving the course");
            session.persist(myCourse);

            Student myStudent1 = new Student("John", "Doe", "johndoe@gmx.net");
            Student myStudent2 = new Student("Jane", "Doe", "janedoe@gmx.net");

            myCourse.addStudent(myStudent1);
            myCourse.addStudent(myStudent2);

            session.persist(myStudent1);
            session.persist(myStudent2);
            System.out.println("\n\n");

            session.persist(myCourse);
            
            session.getTransaction().commit();
        }
    }
}
