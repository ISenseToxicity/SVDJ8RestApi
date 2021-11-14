package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.ResultDto;
import nl.hsleiden.svdj8.models.tables.Result;
import nl.hsleiden.svdj8.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/result",method = RequestMethod.GET)
public class ResultController {

    @Autowired
    public final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<ResultDto> addResult(@RequestBody final ResultDto resultDto){
        Result result = resultService.addResult(Result.from(resultDto));
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResultDto> getItem(@PathVariable final Long id){
        Result result = resultService.getResult(id);
        return new ResponseEntity<>(ResultDto.from(result), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResultDto> deleteResult(@PathVariable final Long id){
        Result result = resultService.deleteResult(id);
        return new ResponseEntity<>(ResultDto.from(result), HttpStatus.OK);
    }
}
