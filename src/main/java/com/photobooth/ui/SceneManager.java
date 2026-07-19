package com.photobooth.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

            if (stage.getScene() == null) {

                Scene scene = new Scene(root);

                stage.setScene(scene);

            } else {

                stage.getScene().setRoot(root);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}