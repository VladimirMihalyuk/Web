package exception;

/**
 * Class representing bus work exception
 * @author Ilya Sysoi
 */
public class BusWorkException extends Exception {

    /**
     * Constructor with specified string
     * @param message string
     */
    public BusWorkException(String message) {
        super(message);
    }

    /**
     * Constructor with specified string and exception
     * @param message string
     * @param e error covered
     */
    public BusWorkException(String message, Throwable e){
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
