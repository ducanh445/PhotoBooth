package com.photobooth;

import com.photobooth.core.App;
import com.photobooth.ui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Photo Booth");

        SceneManager manager = new SceneManager(stage);

        App.setSceneManager(manager);

        manager.switchScene("/fxml/Home.fxml");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}