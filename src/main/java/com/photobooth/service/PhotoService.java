package com.photobooth.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class PhotoService {

    public File savePhoto(BufferedImage image) {

        try {

            File folder = new File("photos");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File file = new File(
                    folder,
                    "photo_" + System.currentTimeMillis() + ".png"
            );

            ImageIO.write(image, "PNG", file);

            System.out.println("Đã lưu: " + file.getAbsolutePath());

            return file;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}