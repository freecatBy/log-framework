package i.know.base.log.log4j;

import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Description:自定义匹配规则
 *
 * @author llb
 * @since 2019/7/17
 */
public class StringMatchWrapFilter extends Filter {
    /**
     @deprecated Options are now handled using the JavaBeans paradigm.
     This constant is not longer needed and will be removed in the
     <em>near</em> term.
     */
    public static final String STRING_TO_MATCH_OPTION = "StringToMatch";

    /**
     @deprecated Options are now handled using the JavaBeans paradigm.
     This constant is not longer needed and will be removed in the
     <em>near</em> term.
     */
    public static final String ACCEPT_ON_MATCH_OPTION = "AcceptOnMatch";

    boolean acceptOnMatch = true;
    String stringToMatch;

    /**
     @deprecated We now use JavaBeans introspection to configure
     components. Options strings are no longer needed.
     */
    public
    String[] getOptionStrings() {
        return new String[] {STRING_TO_MATCH_OPTION, ACCEPT_ON_MATCH_OPTION};
    }

    /**
     @deprecated Use the setter method for the option directly instead
     of the generic <code>setOption</code> method.
     */
    public
    void setOption(String key, String value) {

        if(key.equalsIgnoreCase(STRING_TO_MATCH_OPTION)) {
            stringToMatch = value;
        } else if (key.equalsIgnoreCase(ACCEPT_ON_MATCH_OPTION)) {
            acceptOnMatch = OptionConverter.toBoolean(value, acceptOnMatch);
        }
    }

    public
    void setStringToMatch(String s) {
        stringToMatch = s;
    }

    public
    String getStringToMatch() {
        return stringToMatch;
    }

    public
    void setAcceptOnMatch(boolean acceptOnMatch) {
        this.acceptOnMatch = acceptOnMatch;
    }

    public
    boolean getAcceptOnMatch() {
        return acceptOnMatch;
    }

    /**
     Returns {@link Filter#NEUTRAL} is there is no string match.
     */
    @Override
    public
    int decide(LoggingEvent event) {
        String msg = event.getRenderedMessage();

        if(msg == null ||  stringToMatch == null) {
            return Filter.NEUTRAL;

        }
        if( msg.indexOf(stringToMatch) == -1 ) {
            return Filter.DENY;
        } else { // we've got a match
            if(acceptOnMatch) {
                return Filter.ACCEPT;
            } else {
                return Filter.DENY;
            }
        }
    }

}
