package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Component
public class AdminDAO {
    @Autowired
    private AdminRepository adminRepository;

    public AdminDAO(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAll() {
        ArrayList<Admin> admins = (ArrayList<Admin>) this.adminRepository.findAll();
        admins.sort(Comparator.comparingLong(Admin::getAdminID));
        return admins;
    }

    public Admin getById(long id) {
        return getOutOfRepositoryBy(id).get();
    }

    public Optional<Admin> getOutOfRepositoryBy(long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin with the id: " + id + " not found");
        }
        return optionalAdmin;
    }

    public void deleteAdmin(long id) {
        adminRepository.deleteById(id);
    }

    public Admin addAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }
}
