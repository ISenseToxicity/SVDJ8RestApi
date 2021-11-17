package nl.hsleiden.svdj8.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hsleiden.svdj8.models.tables.Admin;
import nl.hsleiden.svdj8.repository.AdminRepository;
import nl.hsleiden.svdj8.services.EncryptService;
import nl.hsleiden.svdj8.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    AdminRepository adminRepository;


    @PostMapping("/admin/login")
    public String loginUser(@Valid @RequestBody Admin admin) {
        List<Admin> admins = (List<Admin>) adminRepository.findAll();
        EncryptService encryptService = new EncryptService();

        for (Admin existingAdmin : admins) {

            if (HashService.comparePassword(existingAdmin.getPassword(), admin.getPassword())) {
                return encryptService.encrypt("{Token: "+admin+"}"); // Should be admin token
            }
        }
        return "Fail";
    }

    @PostMapping("/admin/resetpasswordrequest")
    public boolean resetPasswordRequest(@Valid @RequestBody Admin admin) {
        List<Admin> admins = (List<Admin>) adminRepository.findAll();

        for (Admin existingAdmin : admins) {
            if (existingAdmin.getEmail().equals(admin.getEmail())) {
                //TODO: add VerificationService createVerificationCode and Send Email Here ( Curently in different branch)
                existingAdmin.setVerificationCode("1234 5678"); // Should be from VerificationService
                // send email
                return true;
            }
        }
        return false;
    }

    @PostMapping("/admin/resetpasswordverify")
    public boolean resetPasswordVerification(@Valid @RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(json, new TypeReference<Map<String, Object>>() {});
        String email = (String) map.get("email");
        String verificationCode = (String) map.get("verificationCode");

        List<Admin> admins = (List<Admin>) adminRepository.findAll();

        for(Admin existingAdmin : admins) {
            if (existingAdmin.getEmail().equals(email) && existingAdmin.getVerificationCode().equals(verificationCode)) {
                // verificationCode should be token and not null;
                return true; // Token would be better
            }
        }
        return false;
    }

    @PostMapping("/admin/resetpassword")
    public Boolean resetPassword(@Valid @RequestBody Admin admin) {
        List<Admin> admins = (List<Admin>) adminRepository.findAll();

        for(Admin existingAdmin : admins) {
            // Should be authentication isAdmin();
            if (existingAdmin.getEmail().equals(admin.getEmail())
                    && existingAdmin.getVerificationCode().equals(admin.getVerificationCode())) {
                existingAdmin.setPassword(admin.getPassword());
                return true;
            }
        }
        return false;
    }

}
