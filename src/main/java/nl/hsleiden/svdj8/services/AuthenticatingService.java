package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Checks if JWT payload has either "Admin" or "User" role.
 * Authenticates request based on role in payload and returns the role as a string to the call.
 * Only the "Admin"-role is defined as a user in the database so everyone that is not "Admin" will be a "User"
 * To do so check whether the request came from an Admin user, no need to check anything else.
 **/

@Service
public class AuthenticatingService {

    private final DecryptService decryptService;
    private final AdminRepository adminRepository;

    @Autowired
    public AuthenticatingService(
            DecryptService decryptService,
            AdminRepository adminRepository) {
        this.decryptService = decryptService;
        this.adminRepository = adminRepository;
    }

    public boolean isAdmin(String token) {
        Admin admin = this.decryptService.decrypt(token);
        return this.adminRepository.existsById(admin.getAdminID());
    }


}
