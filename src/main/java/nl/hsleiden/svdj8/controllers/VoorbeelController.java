package nl.hsleiden.svdj8.controllers;

import nl.hsleiden.svdj8.models.Voorbeeld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoorbeelController {
    @RequestMapping("/sample")
    public Voorbeeld sample(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        Voorbeeld response = new Voorbeeld();
        response.setId(1);
        response.setMessage("Your name is "+ name);
        return response;

    }
}
