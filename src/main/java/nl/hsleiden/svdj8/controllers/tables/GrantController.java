package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GrantDAO;
import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.repository.GrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrantController {

    @Autowired
    public final GrantDAO grantDAO;

    @Autowired
    public final GrantRepository grantRepository;

    public GrantController(GrantDAO grantDAO, GrantRepository grantRepository) {
        this.grantDAO = grantDAO;
        this.grantRepository = grantRepository;
    }

    @RequestMapping(value = "/grant/all", method = RequestMethod.GET)
    public ResponseEntity<List<Grant>> getAllGrants() {
        return new ResponseEntity<>(grantDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grant> getGrant(@PathVariable final Long id) {
        return new ResponseEntity<>(grantDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.PUT)
    Grant editGrant(@RequestBody Grant editGrant, @PathVariable Long id) throws Exception {

        return grantRepository.findById(id)
                .map(grant -> {
                    grant.setName(editGrant.getName());
                    grant.setDescription(editGrant.getDescription());
                    return grantRepository.save(grant);
                })
                .orElseThrow(() -> new Exception(
                        "No grant found with id " + id + "\""));

    }

    @RequestMapping(value = "/grant", method = RequestMethod.PUT)
    Grant addGrant(@RequestBody Grant newGrant) {
        return grantRepository.save(newGrant);
    }

    @DeleteMapping("/grant/{id}")
    void deleteGrant(@PathVariable Long id) {
        grantRepository.deleteById(id);
    }
}
