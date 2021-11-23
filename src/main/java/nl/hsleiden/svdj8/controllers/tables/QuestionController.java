package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AnswerDAO;
import nl.hsleiden.svdj8.daos.QuestionDAO;
import nl.hsleiden.svdj8.models.tables.Answer;
import nl.hsleiden.svdj8.models.tables.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    public final QuestionDAO questionDAO;

    @Autowired
    public final AnswerDAO answerDAO;

    public QuestionController(QuestionDAO questionDAO, AnswerDAO answerDAO) {
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
    }

    @RequestMapping(value = "/question/all", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions() {
      return new ResponseEntity<>(questionDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable final Long id) {
       return new ResponseEntity<>(questionDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.PUT)
    Question editQuestion(@RequestBody Question editQuestion, @PathVariable Long id) throws Exception {
        Question resultQuestion = questionDAO.getByIdOptional(id)
                .map(question -> {
                    question.setQuestionText(editQuestion.getQuestionText());
                    question.setExtraInfoTile(editQuestion.getExtraInfoTile());
                    question.setExtraInfoDescription(editQuestion.getExtraInfoDescription());
                    question.setExtraInfoVideoURL(editQuestion.getExtraInfoVideoURL());
                    question.setAnswers(editQuestion.getAnswers());
                    return questionDAO.addQuestion(question);
                })
                .orElseThrow(() -> new Exception(
                        "No question found with id " + id + "\""));
        for (Answer answer : resultQuestion.getAnswers()) {
            answer.setQuestionID(resultQuestion.getQuestionID());
            answerDAO.addAnswer(answer);
        }
        return resultQuestion;
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    Question addQuestion(@RequestBody Question newQuestion) {
        return questionDAO.addQuestion(newQuestion);
    }

    @DeleteMapping("/question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionDAO.deleteQuestion(id);
    }

}
