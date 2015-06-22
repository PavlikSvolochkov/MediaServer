package database;

import media.MediaFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertId3Tag {

  private static final String INSERT_TAGS =
          "INSERT INTO media.audio (track, artist, title, album, year, genre, comment, composer, " +
                  "publisher, originalArtist, albumArtist, copyright, url, encoder, lyrics, image) " +
                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

  private MediaFile mediaFile;

  private Connection connection;
  private PreparedStatement preparedStatement;

  public InsertId3Tag() throws SQLException {
    connection = DBConnector.getConnection();
    preparedStatement = connection.prepareStatement(INSERT_TAGS);
  }

  public void insertTag(MediaFile file) throws SQLException {

    this.mediaFile = file;

    if (mediaFile != null) {

      preparedStatement.setString(1, mediaFile.getTrack());
      preparedStatement.setString(2, mediaFile.getArtist());
      preparedStatement.setString(3, mediaFile.getTitle());
      preparedStatement.setString(4, mediaFile.getAlbum());
      preparedStatement.setString(5, mediaFile.getYear());
      preparedStatement.setString(6, mediaFile.getGenre());
      preparedStatement.setString(7, mediaFile.getComment());
      preparedStatement.setString(8, mediaFile.getComposer());
      preparedStatement.setString(9, mediaFile.getPublisher());
      preparedStatement.setString(10, mediaFile.getOriginalArtist());
      preparedStatement.setString(11, mediaFile.getAlbumArtist());
      preparedStatement.setString(12, mediaFile.getCopyright());
      preparedStatement.setString(13, mediaFile.getUrl());
      preparedStatement.setString(14, mediaFile.getEncoder());
      preparedStatement.setString(15, mediaFile.getSongLyric());
      preparedStatement.setBytes(16, mediaFile.getImage());

      preparedStatement.executeUpdate();

    } else {
      System.out.println("Link file is null");
    }
  }
}
