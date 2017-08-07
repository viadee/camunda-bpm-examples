package org.camunda.bpm.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.bpm.vPAV.ProcessApplicationValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CamundaSpringBootExampleApplication.class)
public class CamundaSpringBootExampleApplicationTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void verifyProcessInstanceStarted() {
        // process instance is started by the application and waits on the user task
        Task task = taskService.createTaskQuery().taskName("Approve Loan").singleResult();
        assertThat(task, is(notNullValue()));

        // complete the user task and verify that the process ends
        taskService.complete(task.getId());

        assertThat(runtimeService.createProcessInstanceQuery().count(), is(0L));
    }

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void validateModel() {
        assertTrue("Model inconsistency found. Please check target folder for validation output",
                ProcessApplicationValidator.findModelInconsistencies(ctx).isEmpty());
    }

}
