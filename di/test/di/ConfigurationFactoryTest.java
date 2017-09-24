/*
 */
package di;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adam-bien.com
 */
public class ConfigurationFactoryTest {

    private ObjectFactory cut;

    @Before
    public void initialize() {
        this.cut = ObjectFactory.getInstance();
    }

    @Test
    public void productCreation() {
        Configuration product = (Configuration) this.cut.create();
        assertNotNull(product);
    }

}
