package springREST.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringRESTDispatcherInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    @Nullable
    protected Class<?>[] getRootConfigClasses() {
       return null;
    }

    @Override
    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { Config.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
