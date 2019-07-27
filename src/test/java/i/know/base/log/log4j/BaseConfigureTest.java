package i.know.base.log.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description:测试各个logger实例的继承关系
 *
 * @author llb
 * @since 2019/7/9
 */
public class BaseConfigureTest {
    static Logger logger= Logger.getLogger("chapter");
    static Logger logger1= Logger.getLogger("chapter.X.Z");
    static Logger logger2= Logger.getLogger("chapter.X");
    static Logger logger3= Logger.getLogger("chapter.X.Y");
    static Logger logger4= Logger.getLogger("chapter.X");
    static Logger logger5= Logger.getLogger("chapter3.X");
    static Logger logger6= Logger.getLogger("chapter9");
    @Test
    public void hierarchyTest(){
        BasicConfigurator.configure();
        /*若存在 getLogger("x"),getLogger("x"),getLogger("x.y.z")*/
        /*存在 root---> x ----> x.y ---> x.y.z*/
        Assert.assertSame(logger2.getParent(),logger);
        Assert.assertSame(logger3.getParent(),logger2);

        /*若只存在getLogger("x.y.z"),
        * 则只会存在 root ---->  x.y.z*/
        Assert.assertSame(logger6.getParent(),logger5.getParent());
    }
}
