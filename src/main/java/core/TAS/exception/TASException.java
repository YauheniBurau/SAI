package core.TAS.exception;

/**
 * Created by anonymous on 23.02.2019.
 */
public class TASException extends RuntimeException{

    public TASException(Throwable cause) {
        super(cause);
    }

    public TASException(String message, Throwable cause) {
        super(message, cause);
    }

}
