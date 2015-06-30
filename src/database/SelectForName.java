package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectForName {

  private static final String SELECT = "select title, artist, year, icon from media.audio where artist=?";

  private ResultSet resultSet;
  private Connection connection;
  private PreparedStatement preparedStatement;

  public SelectForName() throws SQLException {
    connection = DBConnector.getConnection();
    preparedStatement = connection.prepareStatement(SELECT);
  }

  public ResultSet process(String name) throws SQLException {
    preparedStatement.setString(1, name);
    resultSet = preparedStatement.executeQuery();

//    while (resultSet.next()) {
//      System.out.println(" Title: " + resultSet.getNString("title"));
//      System.out.println("Artist: " + resultSet.getNString("artist"));
//      System.out.println("  Year: " + resultSet.getNString("year"));
//    }
    System.out.println("Sending result set...");

    return resultSet;
  }

  public void close() throws SQLException {
    this.preparedStatement.close();
    this.resultSet.close();
  }
}
