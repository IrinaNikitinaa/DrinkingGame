import java.sql.*;

/*   reference to MySQL file "game" with this table:
CREATE TABLE game (
	game_id int NOT NULL AUTO_INCREMENT,
    player1 varchar (255),
    player2 varchar (255),
    result1 int,
    result2 int,
    PRIMARY KEY (game_id)
);   */

public class Database {

    final String dbURL = "jdbc:mysql://localhost:3306/Java24";
    final String user ="root";
    final String password = "Venera2702!";

    public void readData () throws SQLException {
        String sql = "SELECT * FROM game";

        try(Connection conn = DriverManager.getConnection(dbURL,user,password)){
            System.out.println("Connected");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int gameID = resultSet.getInt("game_id");
                String player1 = resultSet.getString("player1");
                String player2 = resultSet.getString("player2");
                int result1 = resultSet.getInt("result1");
                int result2 = resultSet.getInt("result2");

                String output = "Game info: \n\t id: %d \n\t player 1: %s \n\t player 2: %s \n\t result 1: %d \n\t result 2: %d ";

                System.out.println(String.format
                        (output, gameID, player1, player2, result1, result2));
            }
            //readData(conn);

        }catch(Exception e){
            System.out.println("Something went wrong" + e);
        }
    }

    public void insertData (String player1, String player2, int result1, int result2) throws SQLException {
        Statement stmt = null;
        try  {
            Connection conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
            String sql = "INSERT INTO game (player1, player2, result1, result2) VALUES ('"+player1+"','"+player2+"',"+result1+","+result2+")";
            //System.out.println(sql);
            stmt.executeUpdate(sql);
            /*PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,player1);
            preparedStatement.setString(2,player2);
            preparedStatement.setInt(3,result1);
            preparedStatement.setInt(4,result2);*/
            System.out.println(sql);
            int rowInserted = stmt.executeUpdate(sql);

            if (rowInserted > 0) {
                System.out.println("Successfully inserted");
            } else {
                System.out.println("Something went wrong");
            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong" +e);
        }
    }
}
