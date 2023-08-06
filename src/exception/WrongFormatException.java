package exception;

import enums.Exceptions;

import java.time.LocalDateTime;

public class WrongFormatException extends RuntimeException{

    private String message;
    private LocalDateTime localDateTime;

    public WrongFormatException(Exceptions exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }
}
