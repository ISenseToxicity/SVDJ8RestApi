package nl.hsleiden.svdj8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoResultFoundException extends ResponseStatusException {
    public NoResultFoundException(Long id) {
        super(HttpStatus.NOT_FOUND);
    }
}
