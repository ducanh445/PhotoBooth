package com.photobooth.camera;

import org.opencv.videoio.VideoCapture;

public class CameraTest {

    public static void test() {

        VideoCapture camera = new VideoCapture(0);

        if(camera.isOpened()){

            System.out.println("Camera Connected");

        }else{

            System.out.println("Camera NOT Found");

        }

        camera.release();

    }

}