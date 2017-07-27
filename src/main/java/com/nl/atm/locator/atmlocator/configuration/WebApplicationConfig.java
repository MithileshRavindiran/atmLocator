package com.nl.atm.locator.atmlocator.configuration;


import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {


    /**
     * View controller to render the
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("views/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * Servlet registration for the Camel
     *
     * @return ServletRegistrationBean {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel-rest/*");
        registration.setName("CamelServlet");
        return registration;
    }

}
