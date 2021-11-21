package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.GrantDAO;
import nl.hsleiden.svdj8.models.tables.Grant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grant", method = RequestMethod.GET)
public class GrantController {

    @Autowired
    public final GrantDAO grantDAO;

    public GrantController(GrantDAO grantDAO) {
        this.grantDAO = grantDAO;
    }

//    @PostMapping
//    public ResponseEntity<GrantDto> addGrant(@RequestBody final GrantDto grantDto) {
//        Grant grant = grantService.addGrant(Grant.from(grantDto));
//        return new ResponseEntity<>(grantDto, HttpStatus.OK);
//    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Grant>> getAllGrants() {
        return new ResponseEntity<>(grantDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grant> getGrant(@PathVariable final Long id) {
        return new ResponseEntity<>(grantDAO.getById(id), HttpStatus.OK);
    }

//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<GrantDto> deleteGrant(@PathVariable final Long id) {
//        Grant grant = grantService.deleteGrant(id);
//        return new ResponseEntity<>(GrantDto.from(grant), HttpStatus.OK);
//    }
}
