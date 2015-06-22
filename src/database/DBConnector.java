package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

  static Logger logger = Logger.getLogger(DBConnector.class);

  static final String USER = "root";
  static final String PASS = "111111";
  static final String DRIVER = "com.mysql.jdbc.Driver";
  static final String URL = "jdbc:mysql://localhost/media";

  private static Connection connection;

  private static DBConnector instance = new DBConnector();

  private DBConnector() {

    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  public static Connection getConnection() {
    return instance.createConnection();
  }

  private Connection createConnection() {
    connection = null;
    try {
      logger.debug("Create connection...");
      connection = DriverManager.getConnection(URL, USER, PASS);
      logger.debug("Connection created.");
    } catch (SQLException e) {
      logger.debug("ERROR: Unable to connect to database.\n", e);
    }
    return connection;
  }

  public static void closeConnection() {
    try {
      logger.debug("Closing connection...");
      connection.close();
      logger.debug("Connection closed.");
    } catch (SQLException e) {
      logger.debug("ERROR: Unable to close connection!", e);
    }
  }
}