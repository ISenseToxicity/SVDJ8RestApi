package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatingService {

    private final JWTDecryptService JWTDecryptService;
    private final AdminRepository adminRepository;

    @Autowired
    public AuthenticatingService(
            JWTDecryptService JWTDecryptService,
            AdminRepository adminRepository) {
        this.JWTDecryptService = JWTDecryptService;
        this.adminRepository = adminRepository;
    }

    public boolean isAdmin(String token) {
        Admin admin = this.JWTDecryptService.decrypt(token);
        return this.adminRepository.existsById(admin.getAdminID());
    }


}
