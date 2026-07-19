package com.photobooth.controller;

import com.photobooth.core.App;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class QRController {

    @FXML
    private ImageView qrImage;

    @FXML
    public void initialize(){

        qrImage.setImage(
                new Image(
                        getClass()
                                .getResourceAsStream("/images/qrcode.png")
                )
        );

        PauseTransition wait =
                new PauseTransition(Duration.seconds(10));

        wait.setOnFinished(e->

                App.getSceneManager()
                        .switchScene("/fxml/Finish.fxml")

        );

        wait.play();

    }

}