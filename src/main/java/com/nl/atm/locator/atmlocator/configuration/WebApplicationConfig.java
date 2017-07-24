package com.nl.atm.locator.atmlocator.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    /**
     * Cors mapping is used to consume the service from different consumers
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/locateAtm").allowedOrigins("*");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("views/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
