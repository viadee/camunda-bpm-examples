Simple Servlet Process Application Example (vPAV)
==========================================

This example demonstrates how to deploy a simple servlet process application.

How to use it
-----------------------------

1. Checkout the project with Git;
2. Import the project into your IDE;
3. Build it with maven;
4. Deploy it to a camunda-bpm-platform distro of your choice;
6. Check the console if you can find: "Service Task 'Example ServiceTask' is invoked!".

## vPAV
Modified the `pom-xml` and added a new test-class `ModelConsistencyTest.java`

```xml
    <!-- viadee Process Application Validator -->
    <dependency>
  		<groupId>de.viadee</groupId>
  		<artifactId>viadeeProcessApplicationValidator</artifactId>
  		<version>...</version>
	</dependency>
```
```java
public class ModelConsistencyTest {

    @Test
    public void validateModel() {
        assertTrue("Model inconsistency found. Please check target folder for validation output",
                ProcessApplicationValidator.findModelInconsistencies().isEmpty());
    }
}
```
