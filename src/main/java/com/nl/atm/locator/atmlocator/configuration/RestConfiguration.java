package com.nl.atm.locator.atmlocator.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Configuration class to consume the rest service call from the application
 *
 */
@Configuration
public class RestConfiguration {
    /**
     * Atm Locator Rest template to call the rest service of ING
     * @return the rest template {@link RestTemplate}
     */
    @Bean(name = "atmLocatorRestTemplate")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(getRestErrorHandler());
        restTemplate.setRequestFactory(createRequestFactory());
        // message converters was not used since the consuming service is response is not properly formatted from the provider
        //restTemplate.setMessageConverters(Arrays.asList(getMappingJacksonHttpMessageConverter()));
        return restTemplate;
    }

    /**
     * Rest Error Handler to display error status of the call in case any failure occurs
     * @return ResponseErrorHandles {@link ResponseErrorHandler}
     */
    private ResponseErrorHandler getRestErrorHandler() {
        return new DefaultResponseErrorHandler() {
            @Override
            protected boolean hasError(HttpStatus statusCode) {
                return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
            }
        };
    }

    /**
     * Method to create the Request Factory to set the request timeout and connection timeour
     * @return ClientHttpRequestFactory {@link ClientHttpRequestFactory}
     */
    private ClientHttpRequestFactory createRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10 * 1000);
        requestFactory.setConnectTimeout(10 * 1000);
        return requestFactory;
    }

    /**
     *
     * @return the jackson converter for converting to and from JSON(P)
     *
     */
    public MappingJackson2HttpMessageConverter getMappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        // Attach the Jackson object mapper
        converter.setObjectMapper(getObjectMapper());

        return converter;
    }

    /**
     * Object mapper used in Json jackson converter
     * @return ObjectMapper
     */
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JodaModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

}
