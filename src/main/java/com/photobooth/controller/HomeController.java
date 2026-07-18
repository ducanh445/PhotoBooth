package com.photobooth.controller;

import com.photobooth.core.App;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    public void initialize() {
        System.out.println("Home Loaded");
    }

    @FXML
    private void startSession() {
        App.getSceneManager().switchScene("/fxml/Camera.fxml");
    }
}