package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.QuestionDto;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    public final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        List<Question> questions = questionService.getAllquestions();
        List<QuestionDto> questionsDto = new List<QuestionDto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<QuestionDto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(QuestionDto questionDto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends QuestionDto> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends QuestionDto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public QuestionDto get(int index) {
                return null;
            }

            @Override
            public QuestionDto set(int index, QuestionDto element) {
                return null;
            }

            @Override
            public void add(int index, QuestionDto element) {

            }

            @Override
            public QuestionDto remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<QuestionDto> listIterator() {
                return null;
            }

            @Override
            public ListIterator<QuestionDto> listIterator(int index) {
                return null;
            }

            @Override
            public List<QuestionDto> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(Question question: questions){
            questionsDto.add(QuestionDto.from(question));
        }
        return new ResponseEntity<>(questionsDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody final QuestionDto questionDto){
//        Question question = questionService.savequestion(Question.from(questionDto));
//        questionService.savequestion(Question.from(questionDto));
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable final Long id){
        Question question = questionService.getQuestion(id);
        return new ResponseEntity<>(QuestionDto.from(question), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable final Long id){
        Question question = questionService.deleteQuestion(id);
        return new ResponseEntity<>(QuestionDto.from(question), HttpStatus.OK);
    }
}
