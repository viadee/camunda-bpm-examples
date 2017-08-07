import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.viadee.bpm.vPAV.ProcessApplicationValidator;

public class ModelConsistencyTest {

    @Test
    public void validateModel() {
        assertTrue("Model inconsistency found. Please check target folder for validation output",
                ProcessApplicationValidator.findModelInconsistencies().isEmpty());
    }
}