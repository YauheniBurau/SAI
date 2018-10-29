package core.application.exceptions;

/**
 * Created by anonymous on 09.10.2018.
 */
public class MethodException extends RuntimeException{

    public MethodException(String message, Throwable e) {
        super(message, e);
    }

    public MethodException(String message) {
        super(message);
    }
}
