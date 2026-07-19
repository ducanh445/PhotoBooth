package com.photobooth.controller;



import com.photobooth.core.App;
import com.photobooth.service.CameraService;
import com.photobooth.service.PhotoService;
import com.photobooth.service.SessionService;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.awt.image.BufferedImage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import com.photobooth.template.PhotoStripGenerator;

public class CameraController {

    private CameraService cameraService = new CameraService();
    private final SessionService sessionService = new SessionService();

    private int currentPhoto = 0;

    private final int MAX_PHOTOS = 4;
    private final PhotoService photoService = new PhotoService();
    @FXML
    private Button captureButton;

    @FXML
    private ImageView cameraView;


    @FXML
    private Label countdownLabel;

    @FXML
    public void initialize() {

        System.out.println("captureButton = " + captureButton);

        cameraService.start(cameraView);

    }

    @FXML
    private void onCaptureClick() {

        captureButton.setDisable(true);

        sessionService.clear();

        currentPhoto = 0;

        captureNextPhoto();
    }
    private void captureNextPhoto() {

        // Nếu đã đủ 4 ảnh thì kết thúc
        if (currentPhoto >= MAX_PHOTOS) {

            countdownLabel.setText("Đang ghép ảnh...");

            try {

                System.out.println("1. Bắt đầu tạo photostrip");

                File strip = PhotoStripGenerator.create(sessionService.getPhotos());

                System.out.println("2. Tạo xong: " + strip.getAbsolutePath());

                App.getSession().setPrintFile(strip);
                App.getSession().setOriginalPrintFile(strip);

                System.out.println("3. Chuẩn bị chuyển Preview");

                App.getSceneManager().switchScene("/fxml/Preview.fxml");

                System.out.println("4. Đã chuyển Preview");

            } catch (Exception e) {

                e.printStackTrace();

            }

            return;
        }

        Timeline timeline = new Timeline();

        for (int i = 3; i >= 1; i--) {

            int number = i;

            timeline.getKeyFrames().add(

                    new KeyFrame(

                            Duration.seconds(3 - number),

                            e -> countdownLabel.setText(
                                    "Ảnh "
                                            + (currentPhoto + 1)
                                            + "/4\n"
                                            + number
                            )
                    )
            );
        }

        timeline.getKeyFrames().add(

                new KeyFrame(

                        Duration.seconds(3),

                        e -> {

                            countdownLabel.setText("");

                            BufferedImage image = cameraService.capture();

                            if (image != null) {

                                File file = photoService.savePhoto(image);

                                sessionService.addPhoto(file);
                            }

                            // tăng số ảnh sau khi chụp
                            currentPhoto++;

                            // chụp tiếp nếu chưa đủ
                            captureNextPhoto();
                        }
                )
        );

        timeline.play();
    }


    private void takePhoto() {

        System.out.println("takePhoto()");

        BufferedImage image = cameraService.capture();

        if (image == null) {
            System.out.println("Không chụp được ảnh");
            return;
        }

        photoService.savePhoto(image);
    }


}