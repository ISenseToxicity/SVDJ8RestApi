package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;


@Component
public class QuestionDAO {

    private QuestionRepository questionRepository;

    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public ArrayList<Question> getAll(){
        ArrayList<Question> questions = (ArrayList<Question>) this.questionRepository.findAll();
        questions.sort(Comparator.comparingLong(Question::getQuestionID));
        return questions;
    }

    public Question getFirst() {
        return getAll().get(0);
    }

    public Question getById(long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.orElse(null);
    }

//    public void saveQuestion(Question question) {
//        Question toModifyQuestion = getById(question.getQuestionID());
//        if (toModifyQuestion != null) {
//            toModifyQuestion.setValue(question.getValue());
//        } else {
//            toModifyQuestion = question;
//        }
//        questionRepository.save(toModifyQuestion);
//    }

    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }
}




//@Component
//public class QuestionDAO implements Dao<Question> {
//    private static QuestionDAO questionDAO;
//
//    public static QuestionDAO getInstance(){
//        if(questionDAO == null){
//            questionDAO = new QuestionDAO();
//        }
//        return questionDAO;
//    }
//
//    @Override
//    public Optional get(int id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Question> getAll() {
//        return null;
//    }
//
//    @Override
//    public int save(Question question) {
//        return 0;
//    }
//
//    @Override
//    public void update(Question question) {
//
//    }
//
//    @Override
//    public void delete(Question question) {
//
//    }
//
//
//    static Connection conn = null;
//    private final static String url = "jdbc:sqlite:C:/SQLLite/java/connect/main";
//    /**
//     * Connect with the  database
//     * @author Eefje | AntiEevee
//     * */
//    public static void connection(String query) {
//        try {
//            conn = DriverManager.getConnection(url);
//            System.out.println("Connected to the DB");
//            conn.setAutoCommit(false);
//            writeQueryToDB(query);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
//
//    private static void writeQueryToDB(String query) {
//        try {
//            conn.nativeSQL(query);
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public boolean sendQuery(String query){
//        connection(query);
//    return true;
//    }
//}