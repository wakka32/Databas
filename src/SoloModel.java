import java.sql.*;

public class SoloModel {
    // Holds the value of the sum of the numbers
    // entered in the view
    private int SoloValue;
    String body;

    public String getBody() {
        try {
            // Set up connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);


            // Setup statement
            Statement stmt = conn.createStatement();
            String strSelect = "select body from story where id = 1";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                body = rset.getString("body");

                System.out.println(body);
                ++rowCount;
            }
            String body = rset.getString("body");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return body;
    }


    public void addTwoNumbers(int firstNumber, int secondNumber) {
        SoloValue = firstNumber + secondNumber;
    }

    public int getSoloValue() {
        return SoloValue;
    }
}