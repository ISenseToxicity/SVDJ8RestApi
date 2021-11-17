package nl.hsleiden.svdj8.controllers;


import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import nl.hsleiden.svdj8.services.EncryptService;
import nl.hsleiden.svdj8.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    AdminRepository adminRepository;


    @PostMapping("/admin/login")
    public String loginUser(@Valid @RequestBody Admin admin) {
        List<Admin> admins = (List<Admin>) adminRepository.findAll();
        EncryptService encryptService = new EncryptService();

        for (Admin existingAdmin: admins) {

            if (HashService.comparePassword(existingAdmin.getPassword(), admin.getPassword())) {
                return encryptService.encrypt("{Token: "+admin+"}");
            }
        }
        return "Fail";
    }



}
