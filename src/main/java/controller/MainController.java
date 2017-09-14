package controller;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import media.OpenFiles;
import utils.DialogUtils;
import utils.ResourceUtils;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ResourceBundle;

public class MainController {


    // important files
    private final String TEXT_FILE = "PrivateCode.txt";         // text file with code
    // sounds
    private final String WIN_SOUND = "sounds/win.wav";
    private final String LOSE_SOUND = "sounds/lose.wav";
    private final String CLICK_SOUND = "sounds/click.wav";
    private final String ERROR_SOUND = "sounds/error.wav";

    private int codeLength;             //length of code from text file
    private int textFromUserLength;
    private String textFromUser = "";   // code entered from application


    @FXML
    private PasswordField PassField;

    public void initialize() {
        try {
            codeLength = OpenFiles.openTextFile(TEXT_FILE).length();
        } catch (IOException e) {
            DialogUtils.errorDialog(ResourceUtils.getResourceBundle().getString("no.file"),e.getMessage());
        }
    }

    private void clickButton(String number) {
        if (textFromUserLength < codeLength) {
            textFromUserLength++;
            textFromUser += number;
            PassField.setText(textFromUser);
            makeClickSound();
        } else makeErrorSound();
    }

    @FXML
    private void clickClear() {
        makeClickSound();
        textFromUser = "";
        textFromUserLength = 0;
        PassField.setText(textFromUser);
    }

    @FXML
    private void clickEnter() {
        try {
            if (OpenFiles.openTextFile(TEXT_FILE).equals(textFromUser)) {
                makeWinSound();
                winScene();
            } else makeLoseSound();
        } catch (IOException e) {
            DialogUtils.errorDialog(ResourceUtils.getResourceBundle().getString("no.file"),e.getMessage());
        }

    }

    @FXML
    private void click0() {
        clickButton("0");
    }

    @FXML
    private void click1() {
        clickButton("1");
    }

    @FXML
    private void click2() {
        clickButton("2");
    }

    @FXML
    private void click3() {
        clickButton("3");
    }

    @FXML
    private void click4() {
        clickButton("4");
    }

    @FXML
    private void click5() {
        clickButton("5");
    }

    @FXML
    private void click6() {
        clickButton("6");
    }

    @FXML
    private void click7() {
        clickButton("7");
    }

    @FXML
    private void click8() {
        clickButton("8");
    }

    @FXML
    private void click9() {
        clickButton("9");
    }

    private void makeSounds(String soundPath) {
        try {
            OpenFiles.openMp3File(soundPath);
        } catch (IOException e) {
            DialogUtils.errorDialog(ResourceUtils.getResourceBundle().getString("no.file"),e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            DialogUtils.errorDialog(ResourceUtils.getResourceBundle().getString("wrong.format"), e.getMessage());
        } catch (LineUnavailableException e) {
            DialogUtils.errorDialog(ResourceUtils.getResourceBundle().getString("cant.use"),e.getMessage());
        }
    }

    private void makeClickSound() {
        makeSounds(CLICK_SOUND);
    }

    private void makeErrorSound() {
        makeSounds(ERROR_SOUND);
    }

    private void makeWinSound() {
        makeSounds(WIN_SOUND);
    }

    private void makeLoseSound() {
        makeSounds(LOSE_SOUND);
    }


    // this method open new stage and open movie file on path "file:/WinMovie.mp4"
    // C:/WinMovie.mp4
    private void winScene() {

        //create new stage with anchoPane and mediaViewer
        Stage window = new Stage();
        AnchorPane anchorPane = new AnchorPane();
        MediaView mediaView = new MediaView();
        anchorPane.getChildren().add(mediaView);
        Scene scene = new Scene(anchorPane, 400, 400);
        window.setFullScreen(true);
        window.setScene(scene);
        window.show();

        //some styles
        mediaView.setY(150);
        anchorPane.setStyle("-fx-background-color: black;");

        //open movie file
        Media winMovie = new Media("file:/C:WinMovie.mp4");
        MediaPlayer player = new MediaPlayer(winMovie);
        mediaView.setMediaPlayer(player);
        mediaView.setFitHeight(1000);
        mediaView.setFitWidth(1920);
        player.setAutoPlay(true);

        player.play();

    }

}



