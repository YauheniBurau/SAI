package core.exceptions;

/**
 * Created by anonymous on 13.02.2018.
 */
public class SetDataException extends RuntimeException{

    public SetDataException(String message, Throwable e) {
        super(message, e);
    }

    public SetDataException(String message) {
        super(message);
    }

}
