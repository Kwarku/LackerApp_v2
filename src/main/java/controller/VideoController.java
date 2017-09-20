package controller;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoController {

    @FXML
    private MediaView mediaView;


    public void initialize() {
        //open movie file
        Media media = new Media("file:/C:WinMovie.mp4");
        MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        mediaView.setFitHeight(1000);
        mediaView.setFitWidth(1920);


        player.setAutoPlay(true);
        player.play();
    }


}

