package com.photobooth.service;

import com.photobooth.filter.ImageFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FilterService {

    public File gray(File file) throws Exception {

        BufferedImage image = ImageIO.read(file);

        image = ImageFilter.gray(image);

        ImageIO.write(image, "png", file);

        return file;
    }

    public File sepia(File file) throws Exception {

        BufferedImage image = ImageIO.read(file);

        image = ImageFilter.sepia(image);

        ImageIO.write(image, "png", file);

        return file;
    }

    public File invert(File file) throws Exception {

        BufferedImage image = ImageIO.read(file);

        image = ImageFilter.invert(image);

        ImageIO.write(image, "png", file);

        return file;
    }
}