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

@Configuration
public class RestConfiguration {
    /**
     * Atm Locator Rest template
     * @return the rest template
     */
    @Bean(name = "atmLocatorRestTemplate")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(getRestErrorHandler());
        restTemplate.setRequestFactory(createRequestFactory());
        //restTemplate.setMessageConverters(Arrays.asList(getMappingJacksonHttpMessageConverter()));
        return restTemplate;
    }

    private ResponseErrorHandler getRestErrorHandler() {
        return new DefaultResponseErrorHandler() {
            @Override
            protected boolean hasError(HttpStatus statusCode) {
                return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
            }
        };
    }

    private ClientHttpRequestFactory createRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10 * 1000);
        requestFactory.setConnectTimeout(10 * 1000);
        return requestFactory;
    }

    /**
     * @return the jackson converter for converting to and from JSON(P)
     */
    @Bean(name = "coreMessageConverter")
    public MappingJackson2HttpMessageConverter getMappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        // Attach the Jackson object mapper
        converter.setObjectMapper(getObjectMapper());

        return converter;
    }

    /**
     * @return ObjectMapper
     */
    @Bean(name = "coreObjectMapper")
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JodaModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
