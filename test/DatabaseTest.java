import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;

public class DatabaseTest extends TestCase {
    Log logger = LogFactory.getLog(getClass());
    private Connection conn;
    private String url = "jdbc:h2:tcp://localhost/~/test";
    private String username = "sa";
    private String password = "";

//    @Override
//    protected void setUp() throws Exception {
//        Class.forName("org.h2.Driver");
//        super.setUp();
//        try {
//            conn = DriverManager.getConnection(url, username, password);
//            conn.setAutoCommit(false);
//            System.out.println("Connection successfully established!");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

//    public void testInsert() {
//
//        try {
//            String sql = "INSERT INTO ITEM (student, theme, director, year1, faculty, description) values (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "student");
//            statement.setString(2, "theme");
//            statement.setString(3, "director");
//            statement.setString(4, "year");
//            statement.setString(5, "faculty");
//            statement.setString(6, "description");
//
//            int row = statement.executeUpdate();
//            conn.commit();
//            assertEquals(row, 1);
//
//            sql = "SELECT * FROM ITEM";
//            statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            row = 0;
//            while (rs.next()) {
//                row++;
//            }
//            assertEquals(row, 2);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


}
