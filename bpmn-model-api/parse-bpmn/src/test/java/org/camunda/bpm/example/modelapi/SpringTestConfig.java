package org.camunda.bpm.example.modelapi;

import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfig {

    public SpringTestConfig() {
        MockitoAnnotations.initMocks(this);
    }

}