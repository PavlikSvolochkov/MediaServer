package media;

import java.io.File;
import java.io.FileFilter;

public class AudioFileFilter implements FileFilter {

  private static String[] AUDIO_FILTER = {
          ".mp3",
//          ".3gp", ".act", ".aiff", ".aac", ".amr",
//          ".au", ".awb", ".dct", ".dss", ".dvf", ".flac", ".gsm", ".iklax", ".ivs",
//          ".m4a", ".m4p", ".mmf", ".mpc", ".msv", ".ogg", ".oga", ".opus",
//          ".ra", ".rm", ".raw", ".sln", ".tta", ".vox", ".wav", ".wma", ".wv", ".webm"
  };

  public boolean accept(File file) {
    for (String extension : AUDIO_FILTER) {
      if (file.getName().toLowerCase().endsWith(extension)) {
        return true;
      }
    }
    return false;
  }
}
