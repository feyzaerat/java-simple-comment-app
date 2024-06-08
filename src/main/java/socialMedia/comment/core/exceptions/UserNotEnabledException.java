package socialMedia.comment.core.exceptions;

public class UserNotEnabledException extends RuntimeException   {
    public UserNotEnabledException(String message) {
        super(message);
    }
}
