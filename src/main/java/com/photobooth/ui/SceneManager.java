package com.photobooth.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private final Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void switchScene(String fxml) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource(fxml));

            Parent root = loader.load();

            Scene scene = new Scene(root, 1280, 720);

            scene.getStylesheets().add(
                    getClass()
                            .getResource("/css/style.css")
                            .toExternalForm()
            );

            stage.setScene(scene);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}