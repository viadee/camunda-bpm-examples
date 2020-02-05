import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.viadee.bpm.vPAV.ProcessApplicationValidator;

public class ModelConsistencyTest {

    @Test
    public void validateModel() {
        // Test fails correctly because there are two read accesses on 'customerData' without prior initialization
        assertTrue("Model inconsistency found. Please check target folder for validation output",
                ProcessApplicationValidator.findModelInconsistencies().isEmpty());
    }
}
