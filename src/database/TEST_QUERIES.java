package database;

import java.sql.SQLException;

public class TEST_QUERIES {

  public static void main(String[] args) throws SQLException {

//    SelectForName selectForName = new SelectForName();
//    selectForName.process("Dorje");
//    selectForName.close();
//
//    SelectMedia selectMedia = new SelectMedia();

//    ResultSet resultSet;
//    resultSet = selectMedia.selectId(1791);
//    while (resultSet.next()) {
//      System.out.println("  Title: " + resultSet.getString("title"));
//      System.out.println(" Artist: " + resultSet.getString("artist"));
//      System.out.println("  Album: " + resultSet.getString("album"));
//      System.out.println("-----------------------------------------");
//    }

//    resultSet = selectMedia.selectAlbum("Black Stone Cherry");
//    while (resultSet.next()) {
//      System.out.println("  Album: " + resultSet.getString("album"));
//      System.out.println("  Title: " + resultSet.getString("title"));
//      System.out.println("Atrtist: " + resultSet.getString("artist"));
//      System.out.println("-----------------------------------------");
//    }
//
//    resultSet = selectMedia.selectArtist("Bob Culbertson");
//    while (resultSet.next()) {
//      System.out.println("Atrtist: " + resultSet.getString("artist"));
//      System.out.println("  Title: " + resultSet.getString("title"));
//      System.out.println("  Album: " + resultSet.getString("album"));
//      System.out.println("-----------------------------------------");
//    }
//    resultSet.close();

    CreateUser createUser = new CreateUser();
    createUser.insertUser("root1", "password", "root@email.com");

    DBConnector.closeConnection();
  }
}
