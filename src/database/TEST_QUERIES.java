package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TEST_QUERIES {

  public static void main(String[] args) throws SQLException {
    SelectForName selectForName = new SelectForName();
    selectForName.process("Amplifier");
    selectForName.close();

    ResultSet resultSet;

    SelectMedia selectMedia = new SelectMedia();

    resultSet = selectMedia.selectId(1791);
    while (resultSet.next()) {
      System.out.println("  Title: " + resultSet.getString("title"));
      System.out.println("Atrtist: " + resultSet.getString("artist"));
      System.out.println("  Album: " + resultSet.getString("album"));
      System.out.println("-----------------------------------------");
    }

    resultSet = selectMedia.selectAlbum("Black Stone Cherry");
    while (resultSet.next()) {
      System.out.println("  Album: " + resultSet.getString("album"));
      System.out.println("  Title: " + resultSet.getString("title"));
      System.out.println("Atrtist: " + resultSet.getString("artist"));
      System.out.println("-----------------------------------------");
    }

    resultSet = selectMedia.selectArtist("Bob Culbertson");
    while (resultSet.next()) {
      System.out.println("Atrtist: " + resultSet.getString("artist"));
      System.out.println("  Title: " + resultSet.getString("title"));
      System.out.println("  Album: " + resultSet.getString("album"));
      System.out.println("-----------------------------------------");
    }


    DBConnector.closeConnection();
  }
}
