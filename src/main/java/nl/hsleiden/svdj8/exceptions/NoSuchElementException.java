package nl.hsleiden.svdj8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementException extends ResponseStatusException {

    public NoSuchElementException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
