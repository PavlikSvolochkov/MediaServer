package tests;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import database.DBConnector;
import database.DeleteMedia;
import database.InsertId3Tag;
import media.AudioFileFilter;
import media.ImageFileFilter;
import media.Mp3TagReader;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

  static Logger logger = Logger.getLogger(Main.class);

  private static AudioFileFilter fileFilter;
  private static Mp3TagReader reader;
  private static InsertId3Tag insertId3Tag;
  private static DeleteMedia deleteMedia;

  public static void main(String[] args) throws IOException, SQLException, InvalidDataException, UnsupportedTagException {

//    insertId3Tag = new InsertId3Tag();
    deleteMedia = new DeleteMedia();
    deleteMedia.deleteId(1656);

    deleteMedia.deleteAlbum("Tear It Up");
    deleteMedia.deleteArtist("Albert Lee");

//    reader = new Mp3TagReader();
//    fileFilter = new AudioFileFilter();
//    displayDirectoryContents(new File("E:\\music"));

    DBConnector.closeConnection();
  }

  public static void displayDirectoryContents(File dir) throws SQLException, InvalidDataException, UnsupportedTagException {
    try {

      File[] files = dir.listFiles();

      for (File file : files) {
        if (file.isDirectory()) {

          System.out.println("directory:" + file.getCanonicalPath());
          displayDirectoryContents(file);

        } else if (fileFilter.accept(file)) {

//          System.out.println(reader.readID3Tags(file).toString());

          insertId3Tag.insertTag(reader.readID3Tags(file));

        } else if (new ImageFileFilter().accept(file)) {
//          System.out.println("    image:" + file.getCanonicalPath());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
