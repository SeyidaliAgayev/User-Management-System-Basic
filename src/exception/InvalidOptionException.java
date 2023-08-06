package exception;

import enums.Exceptions;

import java.time.LocalDateTime;

public class InvalidOptionException extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;

    public InvalidOptionException(Exceptions exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }
}
