package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoResultFoundException;
import nl.hsleiden.svdj8.models.tables.Result;
import nl.hsleiden.svdj8.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }

    public Result addResult(Result result){
        return resultRepository.save(result);
    }

    public List<Result> getResults(){
        return StreamSupport
                .stream(resultRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Result getResult(Long id){
        return resultRepository.findById(id).orElseThrow(() ->
        new RuntimeException(new NoResultFoundException(id)));
    }

    public Result deleteResult(Long id){
        Result result = getResult(id);
        resultRepository.delete(result);
        return result;
    }

    public Result editResult(Long id, Result result){
        Result resultToEdit = getResult(id);
        resultToEdit.setTotalTime(result.getTotalTime());
        resultToEdit.setGrants(result.getGrants());
        resultToEdit.setAmountQuestions(result.getAmountQuestions());
        return result;
    }
}
