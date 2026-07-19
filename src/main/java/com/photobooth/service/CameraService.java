package com.photobooth.service;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class CameraService {

    private Webcam webcam;

    private Thread cameraThread;

    public boolean start(ImageView cameraView) {

        webcam = Webcam.getDefault();

        if (webcam == null) {
            System.out.println("Không tìm thấy webcam.");
            return false;
        }

        webcam.open();

        cameraThread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {

                try {

                    BufferedImage bufferedImage = webcam.getImage();

                    if (bufferedImage != null) {

                        Image image =
                                SwingFXUtils.toFXImage(bufferedImage, null);

                        Platform.runLater(() ->
                                cameraView.setImage(image));

                    }

                    Thread.sleep(33);

                } catch (InterruptedException e) {

                    break;

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

        cameraThread.setDaemon(true);

        cameraThread.start();

        return true;
    }

    public BufferedImage capture() {

        System.out.println("CameraService.capture()");

        if (webcam == null) {
            System.out.println("Webcam = NULL");
            return null;
        }

        BufferedImage image = webcam.getImage();

        if (image == null) {
            System.out.println("Image = NULL");
        } else {
            System.out.println("Image OK");
        }

        return image;
    }

    public void stop() {

        if (cameraThread != null) {

            cameraThread.interrupt();

        }

        if (webcam != null) {

            webcam.close();

        }

    }


}