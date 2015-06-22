package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMedia {

  static Logger logger = Logger.getLogger(DBConnector.class);

  private static final String DELETE_ID = "delete from media.audio where id=?;";
  private static final String DELETE_ARTIST = "delete from media.audio where artist=?;";
  private static final String DELETE_ALBUM = "delete from media.audio where album=?";

  private Connection connection;
  private PreparedStatement statement;

  public DeleteMedia() {
    connection = DBConnector.getConnection();
  }

  public void deleteId(int id) throws SQLException {
    logger.debug("Deleting row for ID...");

    statement = connection.prepareStatement(DELETE_ID);
    statement.setInt(1, id);
    statement.executeUpdate();

    logger.debug("Row deleted.");
  }

  public void deleteArtist(String artist) throws SQLException {
    logger.debug("Deleting row for Artist...");

    statement = connection.prepareStatement(DELETE_ARTIST);
    statement.setString(1, artist);
    statement.executeUpdate();

    logger.debug("Row deleted.");
  }

  public void deleteAlbum(String album) throws SQLException {
    logger.debug("Deleting row for Album...");

    statement = connection.prepareStatement(DELETE_ALBUM);
    statement.setString(1, album);
    statement.executeUpdate();

    logger.debug("Row deleted.");
  }
}
