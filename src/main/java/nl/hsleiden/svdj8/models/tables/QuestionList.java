package nl.hsleiden.svdj8.models.tables;

import java.util.Collection;

public class QuestionList {
    private Collection<Question> questions;

    public QuestionList() {
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

}
