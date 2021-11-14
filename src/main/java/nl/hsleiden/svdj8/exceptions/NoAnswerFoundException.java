package nl.hsleiden.svdj8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoAnswerFoundException extends ResponseStatusException {
    public NoAnswerFoundException(Long id) {
        super(HttpStatus.NOT_FOUND);
    }
}