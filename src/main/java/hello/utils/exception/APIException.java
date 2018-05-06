package hello.utils.exception;

public class APIException extends RuntimeException {
    public APIException(String error) {
        super(error);
    }
}
