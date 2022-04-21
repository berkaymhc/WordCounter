import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DBHelper {


    public void simpleMessage(String word, int count) {
        String query = "INSERT INTO deneme1.new_table(id,word,count) VALUES (0," + "'" + word + "'" + "," + count + ")";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1", "root", "1234");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
