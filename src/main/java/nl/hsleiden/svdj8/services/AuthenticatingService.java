package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.models.Data;
import nl.hsleiden.svdj8.models.User;
import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticatingService {

    private final DecryptService decryptService;
    private final AdminRepository adminRepository;
    private final User officalWijzer = new User(1L,"ThisIsThe offical Origin", "Tool");

    @Autowired
    public AuthenticatingService(
            DecryptService decryptService,
            AdminRepository adminRepository) {
        this.decryptService = decryptService;
        this.adminRepository = adminRepository;
    }

    public boolean isAdmin(String token) {
        Admin admin = this.decryptService.decryptAdmin(token);
        return this.adminRepository.existsById(admin.getAdminID());
    }
    public boolean isSubsidieWijzer(String token) {
        Data data= this.decryptService.decryptUser(token);
        return String.valueOf(officalWijzer.getId()).equals(data.getToken());
    }


}
