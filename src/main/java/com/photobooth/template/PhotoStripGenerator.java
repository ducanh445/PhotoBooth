package com.photobooth.template;

import com.photobooth.core.App;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class PhotoStripGenerator {

    public static File create(List<File> photos) throws Exception {

        int width = 600;
        int photoHeight = 350;
        int header = 80;
        int footer = 60;

        int height = header + photoHeight * photos.size() + footer;

        BufferedImage strip =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = strip.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.drawString("PHOTO BOOTH", 180, 45);

        int y = header;

        for (File file : photos) {

            BufferedImage img = ImageIO.read(file);

            int targetWidth = 560;
            int targetHeight = 320;

            double scale = Math.min(
                    (double) targetWidth / img.getWidth(),
                    (double) targetHeight / img.getHeight()
            );

            int w = (int) (img.getWidth() * scale);
            int h = (int) (img.getHeight() * scale);

            int x = 20 + (targetWidth - w) / 2;
            int yy = y + (targetHeight - h) / 2;

            g.drawImage(img, x, yy, w, h, null);;

            y += photoHeight;
        }

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(LocalDate.now().toString(), 200, height - 20);

        g.dispose();

        File folder = new File("prints");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File result = new File(
                folder,
                "photostrip_" + System.currentTimeMillis() + ".png"
        );

        ImageIO.write(strip, "PNG", result);

        App.setOriginalStrip(strip);

        return result;
    }
}