package nl.hsleiden.svdj8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoConnectionException extends Exception {
    @Override
    public String getMessage() {
        return ("there has been no connection established with teh SQLite DB");
    }
}
