package javabasic.customexception;

// dont' extends Throwable or Error
// To be as clase as much to what we need, 
// IllegalArgumentException is preferred to Exception
public class LessThanZeroException extends IllegalArgumentException {

    public LessThanZeroException() {
    }

    public LessThanZeroException(String message) {
        super(message);
    }

    public LessThanZeroException(Throwable cause) {
        super(cause);
    }

}
