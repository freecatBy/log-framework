package i.know.base.log.slf4j;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Description:
 *
 * @author llb
 * @since 2019/7/26
 */
public class StaticLoggerBinderFindTest {
    @Test
    public void testLogUrlget() {
        String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";

        ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
        Enumeration<URL> paths;
        try {
            if (loggerFactoryClassLoader == null) {
                paths = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
            } else {
                paths = loggerFactoryClassLoader.getResources(STATIC_LOGGER_BINDER_PATH);
            }
            while (paths.hasMoreElements()) {
                URL path = paths.nextElement();
                System.out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
