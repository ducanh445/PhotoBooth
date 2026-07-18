package com.photobooth.camera;

import nu.pattern.OpenCV;

public class CameraService {

    public static void loadOpenCV() {

        OpenCV.loadLocally();

        System.out.println("OpenCV Loaded Successfully");

    }

}