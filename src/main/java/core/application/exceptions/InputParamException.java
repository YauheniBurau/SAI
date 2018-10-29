package core.application.exceptions;

/**
 * Created by anonymous on 05.09.2017.
 */
public class InputParamException  extends RuntimeException {

    public InputParamException(String message, Throwable e) {
        super(message, e);
    }

    public InputParamException(String message) {
        super(message);
    }
}
