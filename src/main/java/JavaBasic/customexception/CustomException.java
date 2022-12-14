package javabasic.customexception;

public class CustomException {

    public static void main(String[] args) throws LessThanZeroException {
        validateAge(1);
    }

    // if uncheck exception like RuntimeException, then don't need to throw
    private static void validateAge(int age) throws LessThanZeroException {
        if (age < 0) {
            throw new LessThanZeroException("less than zero");
        } else if (age < 2) {
            throw new LessThanZeroException(new RuntimeException());
        }
    }
}
