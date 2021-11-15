package nl.hsleiden.svdj8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatingService {

    private final DecryptService decryptService;

    @Autowired
    public AuthenticatingService(DecryptService decryptService) {
        this.decryptService = decryptService;
    }


}
