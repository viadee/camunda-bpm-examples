package org.camunda.bpm.example.test;

import org.camunda.bpm.example.delegate.ServiceTaskOneDelegate;
import org.camunda.bpm.example.delegate.ServiceTaskTwoDelegate;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfig {

    public SpringTestConfig() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private ServiceTaskOneDelegate serviceTaskOneDelegate;

    @InjectMocks
    private ServiceTaskTwoDelegate serviceTaskTwoDelegate;

    @Bean
    public ServiceTaskOneDelegate serviceTaskOneDelegate() {
        return serviceTaskOneDelegate;
    }

    @Bean
    public ServiceTaskTwoDelegate serviceTaskTwoDelegate() {
        return serviceTaskTwoDelegate;
    }

}
