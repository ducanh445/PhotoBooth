package com.photobooth.controller;

import com.photobooth.core.App;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class PreviewController {

    @FXML
    private ImageView previewImage;

    @FXML
    public void initialize() {

        File file = App.getSession().getPrintFile();

        if(file != null && file.exists()){

            previewImage.setImage(
                    new Image(file.toURI().toString())
            );

        }
    }

    @FXML
    private void onBack() {

        App.getSceneManager()
                .switchScene("/fxml/Home.fxml");

    }

    @FXML
    private void onFilter(){

        App.getSceneManager()
                .switchScene("/fxml/Filter.fxml");

    }

    @FXML
    private void onPrint() {

        App.getSceneManager()
                .switchScene("/fxml/Print.fxml");

    }

}