package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoGivenAnswerFoundException;
import nl.hsleiden.svdj8.models.tables.GivenAnswer;
import nl.hsleiden.svdj8.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GivenAnswerService {

    private final GivenAnswerRepository givenAnswerRepository;

    @Autowired
    public GivenAnswerService(GivenAnswerRepository givenAnswerRepository){
        this.givenAnswerRepository = givenAnswerRepository;
    }

    public GivenAnswer addGivenAnswer(GivenAnswer givenAnswer){
        return givenAnswerRepository.save(givenAnswer);
    }

    public List<GivenAnswer> getGivenAnswers(){
        return StreamSupport
                .stream(givenAnswerRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public GivenAnswer getGivenAnswer(Long id){
        return givenAnswerRepository.findById(id).orElseThrow(() ->
        new RuntimeException(new NoGivenAnswerFoundException(id)));
    }

    public GivenAnswer deleteGivenAnswer(Long id){
        GivenAnswer givenAnswer = getGivenAnswer(id);
        givenAnswerRepository.delete(givenAnswer);
        return givenAnswer;
    }

    public GivenAnswer editGivenAnswer(Long id, GivenAnswer givenAnswer){
        GivenAnswer givenAnswerToEdit = getGivenAnswer(id);
        givenAnswerToEdit.setElapsedSeconds(givenAnswer.getElapsedSeconds());
        return givenAnswer;
    }
}
