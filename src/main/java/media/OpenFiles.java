package media;

import javax.sound.sampled.*;
import java.io.*;

public class OpenFiles {


    //method to read text File and output PrivateUserCode like a String
    public static String openTextFile(String path) throws IOException {
        String code;

        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine();
        code = br.readLine();
        br.close();

        return code;
    }

    public static void openMp3File(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        AudioInputStream input = AudioSystem.getAudioInputStream(new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(input);
        clip.start();
        input.close();

    }
}
