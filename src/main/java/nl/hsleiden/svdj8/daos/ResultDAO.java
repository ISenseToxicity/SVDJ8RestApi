package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Result;
import nl.hsleiden.svdj8.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class ResultDAO {

    @Autowired
    private ResultRepository resultRepository;

    public ResultDAO(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getAll(){
        ArrayList<Result> results = (ArrayList<Result>) this.resultRepository.findAll();
        results.sort(Comparator.comparingLong(Result::getResultID));
        return results;
    }

    public Result getFirst() {
        return getAll().get(0);
    }

    public Result getById(long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        return optionalResult.orElse(null);
    }


    public Optional<Result> getByIdOptional(long id){
        Optional<Result> optionalResult = resultRepository.findById(id);
        return optionalResult;
    }

    public void deleteQuestion(long id){
        resultRepository.deleteById(id);
    }

    public Result addQuestion(Result newResult){
        return resultRepository.save(newResult);
    }
}
