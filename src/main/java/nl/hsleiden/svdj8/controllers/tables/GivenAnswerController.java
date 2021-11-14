package nl.hsleiden.svdj8.controllers.tables;
import nl.hsleiden.svdj8.daos.Dto.GivenAnswerDto;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.services.GivenAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/givenAnswer")
public class GivenAnswerController {

    private final GivenAnswerService givenAnswerService;

    @Autowired
    public GivenAnswerController(GivenAnswerService givenAnswerService){

        this.givenAnswerService = givenAnswerService;
    }

    @PostMapping
    public ResponseEntity<GivenAnswerDto> addGivenAnswer(@RequestBody final GivenAnswerDto givenAnswerDto){
        GivenAnswer givenAnswer = givenAnswerService.addGivenAnswer(GivenAnswer.from(givenAnswerDto));
        return new ResponseEntity<>(givenAnswerDto, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GivenAnswerDto> getItem(@PathVariable final Long id){
        GivenAnswer givenAnswer = givenAnswerService.getGivenAnswer(id);
        return new ResponseEntity<>(GivenAnswerDto.from(givenAnswer), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GivenAnswerDto> deleteGivenAnswer(@PathVariable final Long id){
        GivenAnswer givenAnswer = givenAnswerService.deleteGivenAnswer(id);
        return new ResponseEntity<>(GivenAnswerDto.from(givenAnswer), HttpStatus.OK);
    }
}
