package i.know.base.log.log4j;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PatternLayout;

/**
 * Description:匹配输出上下文（线程变量）
 *
 * @author llb
 * @since 2019/7/16
 */
public class MDCMakerTest {

    static public void main(String[] args) throws Exception {

        MDC.put("first", "Dorothy");

        PatternLayout layout=
                new PatternLayout("%c %X{first} %X{last} %m%n");
        ConsoleAppender appender = new ConsoleAppender(layout);
        Logger root = Logger.getRootLogger();
        root.addAppender(appender);

        Logger logger = Logger.getLogger(MDCMakerTest.class);

        MDC.put("last", "Parker");

        logger.info("Check enclosed.");
        logger.debug("The most beautiful two words in English.");
                MDC.put("first", "Richard");
        MDC.put("last", "Nixon");
        logger.info("I am not a crook.");
        logger.info("Attributed to the former US president. 17 Nov 1973.");
    }
}
