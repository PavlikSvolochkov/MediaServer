package media;

public class MediaFile {

  private String track;
  private String artist;
  private String title;
  private String album;
  private String year;
  private String genre;
  private String comment;
  private String composer;
  private String publisher;
  private String originalArtist;
  private String albumArtist;
  private String copyright;
  private String url;
  private String encoder;
  private byte[] image;
  private String songLyric;

  public MediaFile() {

  }

  public String  getTrack() {
    return track;
  }

  public void setTrack(String track) {
    this.track = track;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComposer() {
    return composer;
  }

  public void setComposer(String composer) {
    this.composer = composer;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getOriginalArtist() {
    return originalArtist;
  }

  public void setOriginalArtist(String originalArtist) {
    this.originalArtist = originalArtist;
  }

  public String getAlbumArtist() {
    return albumArtist;
  }

  public void setAlbumArtist(String albumArtist) {
    this.albumArtist = albumArtist;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getEncoder() {
    return encoder;
  }

  public void setEncoder(String encoder) {
    this.encoder = encoder;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getSongLyric() {
    return songLyric;
  }

  public void setSongLyric(String songLyric) {
    this.songLyric = songLyric;
  }

  @Override
  public String toString() {
    return "MediaFile{" +
            "track=" + track +
            ", artist='" + artist + '\'' +
            ", title='" + title + '\'' +
            ", album='" + album + '\'' +
            ", year='" + year + '\'' +
            ", genre='" + genre + '\'' +
            ", comment='" + comment + '\'' +
            ", composer='" + composer + '\'' +
            ", publisher='" + publisher + '\'' +
            ", originalArtist='" + originalArtist + '\'' +
            ", albumArtist='" + albumArtist + '\'' +
            ", copyright='" + copyright + '\'' +
            ", url='" + url + '\'' +
            ", encoder='" + encoder + '\'' +
//            ", image=" + Arrays.toString(image) +
            ", songLyric='" + songLyric + '\'' +
            '}';
  }
}
