package by.dorohovich.infohandling.exception;

/**
 * Created by User on 02.11.2016.
 */
public class LeafNotSupportsOperationException extends Exception {

    public LeafNotSupportsOperationException() {
    }

    public LeafNotSupportsOperationException(String message) {
        super(message);
    }

    public LeafNotSupportsOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LeafNotSupportsOperationException(Throwable cause) {
        super(cause);
    }
}
