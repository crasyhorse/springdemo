package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import spring.scope.PersonDAO;

@SpringBootApplication
public class ScopeApp {

    private static Logger logger = LoggerFactory.getLogger(ScopeApp.class);

    public static void main(final String[] args) {

        ApplicationContext appCtx = SpringApplication.run(ScopeApp.class, args);
        PersonDAO personDAO = appCtx.getBean(PersonDAO.class);
        PersonDAO personDAO2 = appCtx.getBean(PersonDAO.class);

        logger.info("{}", personDAO);
        logger.info("{}", personDAO.getJdbcConnection());
        logger.info("{}", personDAO2);
        logger.info("{}", personDAO2.getJdbcConnection());
    }
}
