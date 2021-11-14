package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.GrantDto;
import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.services.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/grant",method = RequestMethod.GET)
public class GrantController {

    private final GrantService grantService;

            @Autowired
    public GrantController(GrantService grantService){

        this.grantService = grantService;
    }

    @PostMapping
    public ResponseEntity<GrantDto> addGrant(@RequestBody final GrantDto grantDto){
        Grant grant = grantService.addGrant(Grant.from(grantDto));
        return new ResponseEntity<>(grantDto, HttpStatus.OK);
              }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public ResponseEntity<GrantDto> getItem(@PathVariable final Long id){
                Grant grant = grantService.getGrant(id);
                return new ResponseEntity<>(GrantDto.from(grant), HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<GrantDto> deleteGrant(@PathVariable final Long id){
        Grant grant = grantService.deleteGrant(id);
        return new ResponseEntity<>(GrantDto.from(grant), HttpStatus.OK);
    }
}
