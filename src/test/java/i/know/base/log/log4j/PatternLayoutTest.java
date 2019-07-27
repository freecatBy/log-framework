package i.know.base.log.log4j;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description:校验配置字符解析匹配
 *
 * @author llb
 * @since 2019/7/26
 */
public class PatternLayoutTest {
    @Test
    public void testPatternLayout(){
        PatternLayout patternLayout= new PatternLayout("%t");
        Assert.assertEquals((Thread.currentThread()).getName(),patternLayout.format(new LoggingEvent("fqn",
                LogManager.getLogger("PatternLayoutTest"),
                Level.FATAL,
                "hello",
                new Throwable())));
    }
}
