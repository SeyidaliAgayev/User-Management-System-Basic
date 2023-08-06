package enums;

import java.time.LocalDateTime;


public enum Exceptions {
    WRONG_FORMAT("Wrong Format", LocalDateTime.now()),
    USER_NOT_FOUND("User not found", LocalDateTime.now()),
    INVALID_OPTION("Invalid Option", LocalDateTime.now()),
    EMPTY_LIST_EXCEPTION("Empty list exception", LocalDateTime.now());


    Exceptions(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    String message;
    LocalDateTime localDateTime;
}
