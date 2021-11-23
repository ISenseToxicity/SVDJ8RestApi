package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class AnswerDAO {

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll(){
        ArrayList<Answer> answers = (ArrayList<Answer>) this.answerRepository.findAll();
        answers.sort(Comparator.comparingLong(Answer::getAnswerID));
        return answers;
    }

//    public List<Answer> getByQuestionId(Long questionId) {
//        ArrayList<Answer> allAnswers = (ArrayList<Answer>) this.answerRepository.findAll();
//        ArrayList<Answer> resultAnswers = new ArrayList<>();
//        for (Answer answer: allAnswers) {
//            if (answer.getQuestionID() == questionId.longValue()) {
//                resultAnswers.add(answer);
//            }
//        }
//        return resultAnswers;
//    }

    public Answer getById(long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer.orElse(null);
    }
    public Optional<Answer> getByIdOptional(long id){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer;
    }

//    public void deleteByQuestionId(Long questionId) {
//        List<Answer> answers = getByQuestionId(questionId);
//        answerRepository.deleteAll(answers);
//    }

    public void deleteByAnswerId(long answerId){
        answerRepository.deleteById(answerId);
    }

    public Answer addAnswer(Answer newAnswer){
        return answerRepository.save(newAnswer);
    }
}
