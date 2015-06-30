package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUser {

  private static final String CHECK_USER = "select * from users where name=? and email=?;";

  private Connection connection;
  private ResultSet resultSet;
  private PreparedStatement preparedStatement;

  public CheckUser() throws SQLException {
    connection = DBConnector.getConnection();
    preparedStatement = connection.prepareStatement(CHECK_USER);
  }

  public boolean checkUser(String name, String email) throws SQLException {

    preparedStatement.setString(1, name);
    preparedStatement.setString(2, email);
    resultSet = preparedStatement.executeQuery();

    if (resultSet.next())
      return true;
    else
      return false;
  }
}
