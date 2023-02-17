package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import spring.basic.BinarySearchImpl;

@SpringBootApplication
public class BasicApp {

    public static void main(final String[] args) {

        ApplicationContext appCtx = SpringApplication.run(BasicApp.class, args);
        BinarySearchImpl binarySearch = appCtx.getBean(BinarySearchImpl.class);
        int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
    }
}
