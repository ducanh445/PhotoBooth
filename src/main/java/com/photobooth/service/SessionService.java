package com.photobooth.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SessionService {

    private final List<File> photos = new ArrayList<>();

    public void addPhoto(File file) {
        photos.add(file);
    }

    public List<File> getPhotos() {
        return photos;
    }

    public void clear() {
        photos.clear();
    }

    public int getCount() {
        return photos.size();
    }
}