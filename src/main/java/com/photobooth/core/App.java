package com.photobooth.core;

import com.photobooth.ui.SceneManager;

public class App {

    private static SceneManager sceneManager;

    public static void setSceneManager(SceneManager manager) {
        sceneManager = manager;
    }

    public static SceneManager getSceneManager() {
        return sceneManager;
    }

}