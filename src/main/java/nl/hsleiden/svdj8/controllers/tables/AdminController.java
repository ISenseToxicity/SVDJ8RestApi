package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AdminDAO;
import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    public final AdminDAO adminDAO;

    @Autowired
    public final AdminRepository adminRepository;

    public AdminController(AdminDAO adminDAO, AdminRepository adminRepository) {
        this.adminDAO = adminDAO;
        this.adminRepository = adminRepository;
    }

    @RequestMapping(value = "/admin/all", method = RequestMethod.GET)
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<>(adminDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public ResponseEntity<Admin> getAdmin(@PathVariable final Long id) {
        return new ResponseEntity<>(adminDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    Admin editAdmin(@RequestBody Admin editAdmin, @PathVariable Long id) throws Exception {

        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setName(editAdmin.getName());
                    admin.setPassword(editAdmin.getPassword());
                    return adminRepository.save(admin);
                })
                .orElseThrow(() -> new Exception(
                        "No admin found with id " + id + "\""));

    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    Admin addAdmin(@RequestBody Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    @DeleteMapping("/admin/{id}")
    void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

}
