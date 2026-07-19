package com.photobooth.core;

import com.photobooth.model.PhotoSession;
import com.photobooth.ui.SceneManager;

import java.awt.image.BufferedImage;

public class App {

    private static SceneManager sceneManager;

    private static PhotoSession session = new PhotoSession();

    public static SceneManager getSceneManager() {
        return sceneManager;
    }

    public static void setSceneManager(SceneManager manager) {
        sceneManager = manager;
    }

    public static PhotoSession getSession() {
        return session;
    }

    private static BufferedImage originalStrip;

    public static BufferedImage getOriginalStrip() {
        return originalStrip;
    }

    public static void setOriginalStrip(BufferedImage image) {
        originalStrip = image;
    }

}