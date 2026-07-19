package com.photobooth.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageFilter {

    public static BufferedImage gray(BufferedImage image) {

        BufferedImage output = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0; x < image.getWidth(); x++) {

                Color c = new Color(image.getRGB(x, y));

                int g = (c.getRed() + c.getGreen() + c.getBlue()) / 3;

                output.setRGB(
                        x,
                        y,
                        new Color(g, g, g).getRGB()
                );
            }
        }

        return output;
    }

    public static BufferedImage sepia(BufferedImage image) {

        BufferedImage output = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0; x < image.getWidth(); x++) {

                Color c = new Color(image.getRGB(x, y));

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int tr = (int)(0.393*r + 0.769*g + 0.189*b);
                int tg = (int)(0.349*r + 0.686*g + 0.168*b);
                int tb = (int)(0.272*r + 0.534*g + 0.131*b);

                tr = Math.min(255, tr);
                tg = Math.min(255, tg);
                tb = Math.min(255, tb);

                output.setRGB(
                        x,
                        y,
                        new Color(tr, tg, tb).getRGB()
                );
            }
        }

        return output;
    }

    public static BufferedImage invert(BufferedImage image) {

        BufferedImage output = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0; x < image.getWidth(); x++) {

                Color c = new Color(image.getRGB(x, y));

                output.setRGB(
                        x,
                        y,
                        new Color(
                                255 - c.getRed(),
                                255 - c.getGreen(),
                                255 - c.getBlue()
                        ).getRGB()
                );
            }
        }

        return output;
    }
}