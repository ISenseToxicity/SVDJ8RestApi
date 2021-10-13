package nl.hsleiden.svdj8.models.temp;

import java.util.ArrayList;

public class TempQuestionListMaker {
    public QuestionList makeList(){
        ArrayList<String> answershizzle = new ArrayList<>();
        answershizzle.add("haha");
        answershizzle.add("hehe");
        Answer answer = new Answer("lol1","lol1",answershizzle);
        Answer answer1 = new Answer("lol2","lol2",answershizzle);
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);
        Question question = new Question("fdsdsf","fmsdkjsdf",answers,"jfdkfsdjk","jfsjksfdk");
        Question question1 = new Question("fdsgfdgfddsf","fmgfdgfdgdfsdkjsdf",answers,"jfdkgfdgfddgffsdjk","jfsgdfdgfdgfjksfdk");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);
        QuestionList questionList = new QuestionList();
        questionList.setQuestions(questions);
        return questionList;
    }
}
