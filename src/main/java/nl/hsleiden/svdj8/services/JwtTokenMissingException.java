package nl.hsleiden.svdj8.services;

public class JwtTokenMissingException extends Exception {

    public JwtTokenMissingException(String errorMessage){
        super(errorMessage);
    }

}
