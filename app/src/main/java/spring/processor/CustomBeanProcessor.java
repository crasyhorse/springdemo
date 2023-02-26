package spring.processor;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanProcessor
    implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private BeanFactory beanFactory;

    private final List<Object> prototypedBeans = new LinkedList<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        if (beanFactory.isPrototype(beanName)) {
            synchronized (prototypedBeans) {
                prototypedBeans.add(bean);
            }
        }

        return bean;
    }

    @Override
    public void destroy() throws Exception {
        synchronized (prototypedBeans) {
            for (Object bean : prototypedBeans) {
                if (bean instanceof DisposableBean) {
                    DisposableBean disposable = (DisposableBean) bean;

                    try {
                        disposable.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        prototypedBeans.clear();
    }

    @Override
    public void setBeanFactory(
        org.springframework.beans.factory.BeanFactory beanFactory
    ) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
