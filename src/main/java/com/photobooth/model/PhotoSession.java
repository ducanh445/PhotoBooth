package com.photobooth.model;

import java.io.File;

public class PhotoSession {

    private int photoCount;

    private boolean blackWhite;

    public PhotoSession() {
        photoCount = 2;
        blackWhite = false;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public boolean isBlackWhite() {
        return blackWhite;
    }

    public void setBlackWhite(boolean blackWhite) {
        this.blackWhite = blackWhite;
    }
    private File printFile;

    public File getPrintFile() {
        return printFile;
    }

    public void setPrintFile(File printFile) {
        this.printFile = printFile;
    }
    private File originalPrintFile;

    public File getOriginalPrintFile() {
        return originalPrintFile;
    }

    public void setOriginalPrintFile(File originalPrintFile) {
        this.originalPrintFile = originalPrintFile;
    }
}