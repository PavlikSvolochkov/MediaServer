package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMedia {

  static Logger logger = Logger.getLogger(DBConnector.class);

  private static final String SELECT_ID = "select * from media.audio where id=?;";
  private static final String SELECT_ARTIST = "select * from media.audio where artist=?;";
  private static final String SELECT_ALBUM = "select * from media.audio where album=?";

  private Connection connection;
  private ResultSet resultSet;
  private PreparedStatement statement;

  public SelectMedia() {
    connection = DBConnector.getConnection();
  }

  public ResultSet selectId(int id) throws SQLException {
    logger.debug("Selecting for ID...");

    statement = connection.prepareStatement(SELECT_ID);
    statement.setInt(1, id);
    resultSet = statement.executeQuery();

    return resultSet;
  }

  public ResultSet selectArtist(String artist) throws SQLException {
    logger.debug("Selecting for ARTIST...");

    statement = connection.prepareStatement(SELECT_ARTIST);
    statement.setString(1, artist);
    resultSet = statement.executeQuery();

    return resultSet;
  }

  public ResultSet selectAlbum(String album) throws SQLException {
    logger.debug("Selecting for ALBUM...");

    statement = connection.prepareStatement(SELECT_ALBUM);
    statement.setString(1, album);
    resultSet = statement.executeQuery();

    return resultSet;
  }
}
