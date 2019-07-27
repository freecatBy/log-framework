package i.know.base.log.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

/**
 * Description:
 *
 * @author llb
 * @since 2019/7/26
 */
public class PropertyConfiguratorTest {
    Logger logger= Logger.getLogger(PropertyConfiguratorTest.class);
    @Test
    public void testPropertyConfigurator(){
        PropertyConfigurator.configure("H:\\IDEAPro\\knowBase\\log-framework\\src\\main\\resources\\log4j\\configure\\log4j.properties");
        logger.debug("testPropertyConfigurator");
    }
}
