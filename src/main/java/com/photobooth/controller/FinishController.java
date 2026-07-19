package com.photobooth.controller;

import com.photobooth.core.App;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class FinishController {

    @FXML
    public void initialize(){

        PauseTransition wait =
                new PauseTransition(Duration.seconds(5));

        wait.setOnFinished(e->

                App.getSceneManager()
                        .switchScene("/fxml/Home.fxml")

        );

        wait.play();

    }

}