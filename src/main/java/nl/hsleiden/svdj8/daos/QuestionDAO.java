package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionDAO {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll() {
        ArrayList<Question> questions = (ArrayList<Question>) this.questionRepository.findAll();
        questions.sort(Comparator.comparingLong(Question::getQuestionID));
        return questions;
    }

    public Question getById(long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.orElse(null);
    }

    public Optional<Question> getByIdOptional(long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion;
    }

    public void deleteQuestion(long id) {
        questionRepository.deleteById(id);
    }

    public Question addQuestion(Question newQuestion) {
        return questionRepository.save(newQuestion);
    }
}
