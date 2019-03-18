package by.isysoi.model.exception;

/**
 * controller exepton
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class ControllerException extends Exception {

    /**
     * Constructor with specified string
     *
     * @param message string
     */
    public ControllerException(String message) {
        super(message);
    }

    /**
     * Constructor with specified string and exception
     *
     * @param message string
     * @param e       error covered
     */
    public ControllerException(String message, Throwable e) {
        super(message, e);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

}