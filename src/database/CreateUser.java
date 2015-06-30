package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUser {

  static Logger logger = Logger.getLogger(CreateUser.class);

  private static final String CHECK_USER = "select * from users where name=? and email=?;";
  private static final String INSERT_USER = "insert into users (name, pass, email) values (?, ?, ?);";

  private Connection connection;
  private ResultSet resultSet;
  private PreparedStatement preparedStatement;

  public CreateUser() throws SQLException {
    connection = DBConnector.getConnection();
  }

  public boolean insertUser(String name, String email, String pass) throws SQLException {
    if (!checkUser(name, email)) {
      logger.debug("Creating user in database...");
      preparedStatement = connection.prepareStatement(INSERT_USER);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, pass);
      preparedStatement.setString(3, email);
      preparedStatement.executeUpdate();
      logger.debug("User created.");

      return true;
    } else {
      return false;
    }
  }

  public boolean checkUser(String name, String email) throws SQLException {
    logger.debug("Checking user in database...");

    preparedStatement = connection.prepareStatement(CHECK_USER);
    preparedStatement.setString(1, name);
    preparedStatement.setString(2, email);
    resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      logger.debug("User exist!");
      return true;
    } else {
      logger.debug("User not exist!");
      return false;
    }
  }
}
