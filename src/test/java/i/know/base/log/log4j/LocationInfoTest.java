package i.know.base.log.log4j;

import org.apache.log4j.spi.LocationInfo;
import org.junit.Test;

/**
 * Description:测试log4j如何获取栈信息
 *
 * @author llb
 * @since 2019/7/26
 */
public class LocationInfoTest {
    @Test
    public void testLocationInfo(){
        FQN fqn= new FQN();
        fqn.printLog();
    }

    class FQN{
        public void printLog(){
            LocationInfo locationInfo = new LocationInfo(new Throwable(), FQN.class.getName());
            System.out.println(locationInfo.fullInfo);
        }
    }
}
