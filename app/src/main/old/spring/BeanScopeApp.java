package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.coach.Coach;

public class BeanScopeApp {

    public static void main(final String[] args) {
        try (
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "beanScope-applicationContext.xml"
            );
        ) {
            Coach firstCoach = context.getBean("baseballCoach", Coach.class);
            Coach secondCoach = context.getBean("baseballCoach", Coach.class);

            boolean result = (firstCoach == secondCoach);

            System.out.println("\nPointing to the same object: " + result);
            System.out.println(
                "\nMemory location for firstCoach: " + firstCoach
            );
            System.out.println(
                "\nMemory location for secondCoach: " + secondCoach
            );
        }
    }
}
