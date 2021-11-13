package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoAnswerFoundException;
import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    public Answer addAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public List<Answer> getAnswers(){
        return StreamSupport
                .stream(answerRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Answer getAnswer(Long id){
        return answerRepository.findById(id).orElseThrow(() ->
        new RuntimeException(new NoAnswerFoundException(id)));
    }

    public Answer deleteAnswer(Long id){
        Answer answer = getAnswer(id);
        answerRepository.delete(answer);
        return answer;
    }

    public Answer editAnswer(Long id, Answer answer){
        Answer answerToEdit = getAnswer(id);
        answerToEdit.setAnswerText(answer.getAnswerText());
        answerToEdit.setkeywords(answer.getkeywords());
        answerToEdit.setCatogoryIds(answer.getCatogoryIds());
        return answerToEdit;
    }
}
