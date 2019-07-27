package i.know.base.log.log4j;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:自定义Appender
 *
 * @author llb
 * @since 2019/7/17
 */
public class DailyRollingFileExtAppender extends DailyRollingFileAppender {

    private String stringToMatch;

    public String getStringToMatch() {
        return stringToMatch;
    }

    public void setStringToMatch(String stringToMatch) {
        this.stringToMatch = stringToMatch;
        setStringToMatchs(stringToMatch);
    }

    private List<String> stringToMatchs;

    public void setStringToMatchs(String stringToMatch) {
        stringToMatchs = new ArrayList<>();
        if(stringToMatch==null){
            return;
        }
        String[] split = stringToMatch.split(",");
        this.stringToMatchs= Arrays.asList(split);
    }

    @Override
    protected void subAppend(LoggingEvent event) {
        String msg = event.getRenderedMessage();
        for(String str:stringToMatchs){
            if( msg.indexOf(str) != -1 ) {
                super.subAppend(event);
            }
        }
    }
}
