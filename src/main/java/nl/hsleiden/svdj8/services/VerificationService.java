package nl.hsleiden.svdj8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class VerificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void createVerificationCode() {

    }

    @PostMapping
    public void sendEmail(String email, int code) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@svdj.nl");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Verificatie code SVDJ admin");
        simpleMailMessage.setText("Gebruik deze code om u identiteit te bevestigen voor de SVDJ admin portal \n" + code + "\n \n- SVDJ");
        javaMailSender.send(simpleMailMessage);
    }

}
