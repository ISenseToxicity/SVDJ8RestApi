package nl.hsleiden.svdj8.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ApplicationDAO {
    private static  ApplicationDAO applicationDAO;

    static Connection conn = null;
    private final static String url = "jdbc:sqlite:C:/SQLLite/java/connect/main";


    public static ApplicationDAO getInstance(){
        if(applicationDAO == null){
            applicationDAO = new ApplicationDAO();
        }
        return applicationDAO;
    }

    /**
     * Connect with the  database
     * @author Eefje | AntiEevee
     * */
    public static void connection(String query) {
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the DB");
            conn.setAutoCommit(false);
            writeQueryToDB(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void writeQueryToDB(String query) {
        try {
            conn.nativeSQL(query);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connection("CREATE TABLE question(" +
                "  QuestionID int," +
                "  QuestionText varchar(255)," +
                "  AnswerListId int," +
                "  extraInfoTile varchar(255)," +
                "  extraInfoDescription varchar(255)" +
                "); ");
    }

    public boolean sendQuery(String query){
        connection(query);
    return true;
    }


}
