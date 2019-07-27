package i.know.base.log.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

/**
 * Description:xml方式的配置
 *
 * @author llb
 * @since 2019/7/26
 */
public class DOMConfiguratorTest {

    Logger logger= Logger.getLogger(DOMConfiguratorTest.class);
    @Test
    public void testDOMConfigurator(){
        DOMConfigurator.configure("H:\\IDEAPro\\knowBase\\log-framework\\src\\main\\resources\\log4j\\configure\\log4j.xml");
        logger.debug("testDOMConfigurator");
    }
}
