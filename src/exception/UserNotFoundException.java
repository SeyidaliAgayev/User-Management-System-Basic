package exception;

import enums.Exceptions;

import java.time.LocalDateTime;

public class UserNotFoundException extends RuntimeException {
    private String message;
    private LocalDateTime localDateTime;

    public UserNotFoundException(Exceptions exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }
}
