package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class GivenAnswerDAO {
    @Autowired
    private GivenAnswerRepository givenAnswerRepository;

    public GivenAnswerDAO(GivenAnswerRepository givenAnswerRepository) {
        this.givenAnswerRepository = givenAnswerRepository;
    }

    public List<GivenAnswer> getAll() {
        ArrayList<GivenAnswer> givenAnswers = (ArrayList<GivenAnswer>) this.givenAnswerRepository.findAll();
        givenAnswers.sort(Comparator.comparingLong(GivenAnswer::getGivenAnswerID));
        return givenAnswers;
    }

    public GivenAnswer getById(long id) {
        Optional<GivenAnswer> optionalGivenAnswer = givenAnswerRepository.findById(id);
        return optionalGivenAnswer.orElse(null);
    }

    public Optional<GivenAnswer> getByIdOptional(long id) {
        Optional<GivenAnswer> optionalGivenAnswer = givenAnswerRepository.findById(id);
        return optionalGivenAnswer;
    }

    public GivenAnswer addGivenAnswer(GivenAnswer newGivenAnswer) {
        return givenAnswerRepository.save(newGivenAnswer);
    }

    public void deleteGivenAnswer(long id) {
        givenAnswerRepository.deleteById(id);
    }

}