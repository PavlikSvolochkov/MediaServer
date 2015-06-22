package media;

import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mp3TagReader {

  private List<MediaFile> mediaFileList;

  private MediaFile mediaFile;
  private Mp3File mp3File;

  public Mp3TagReader() {
    mediaFile = new MediaFile();
    mediaFileList = new ArrayList<>();

  }

  public MediaFile readID3Tags(File fileName) throws IOException, InvalidDataException, UnsupportedTagException {

    System.out.println(fileName.getName());
    mp3File = new Mp3File(fileName.getAbsolutePath());

    if (mp3File.hasId3v2Tag()) {
      ID3v2 id3v2Tag = mp3File.getId3v2Tag();

      mediaFile.setTrack(id3v2Tag.getTrack());
      mediaFile.setArtist(id3v2Tag.getArtist());
      mediaFile.setTitle(id3v2Tag.getTitle());
      mediaFile.setAlbum(id3v2Tag.getAlbum());
      mediaFile.setYear(id3v2Tag.getYear());
      mediaFile.setGenre(id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
      mediaFile.setComment(id3v2Tag.getComment());
      mediaFile.setComposer(id3v2Tag.getComposer());
      mediaFile.setPublisher(id3v2Tag.getPublisher());
      mediaFile.setOriginalArtist(id3v2Tag.getOriginalArtist());
      mediaFile.setAlbumArtist(id3v2Tag.getAlbumArtist());
      mediaFile.setCopyright(id3v2Tag.getCopyright());
      mediaFile.setUrl(id3v2Tag.getUrl());
      mediaFile.setEncoder(id3v2Tag.getEncoder());

      if (id3v2Tag.getAlbumImage() != null) {
        mediaFile.setImage(id3v2Tag.getAlbumImage());
      }

      return mediaFile;

    } else if (mp3File.hasId3v1Tag()) {

      ID3v1 id3v1Tag = mp3File.getId3v1Tag();

      mediaFile.setTrack(id3v1Tag.getTrack());
      mediaFile.setArtist(id3v1Tag.getArtist());
      mediaFile.setTitle(id3v1Tag.getTitle());
      mediaFile.setAlbum(id3v1Tag.getAlbum());
      mediaFile.setYear(id3v1Tag.getYear());
      mediaFile.setGenre(id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
      mediaFile.setComment(id3v1Tag.getComment());

      return mediaFile;

    } else {
      System.out.println("There is no tags in file");
    }

    mediaFileList.add(mediaFile);

    return null;
  }

  public List<MediaFile> getMediaFileList() {
    return mediaFileList;
  }
}
