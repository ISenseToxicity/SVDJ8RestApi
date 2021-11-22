package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Component
public class AnswerDAO {

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public ArrayList<Answer> getAll(){
        ArrayList<Answer> answers = (ArrayList<Answer>) this.answerRepository.findAll();
        answers.sort(Comparator.comparingLong(Answer::getAnswerID));
        return answers;
    }

    public Answer getFirst() {
        return getAll().get(0);
    }

    public Answer getById(long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer.orElse(null);
    }

}
