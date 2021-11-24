package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        return optionalAdmin.orElse(null);
    }

    public Optional<Admin> getByIdOptional(long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        return optionalAdmin;
    }

    public void deleteAdmin(long id) {
        adminRepository.deleteById(id);
    }

    public Admin addAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }
}
