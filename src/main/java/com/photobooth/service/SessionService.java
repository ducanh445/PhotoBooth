package com.photobooth.service;

import com.photobooth.model.PhotoSession;

public class SessionService {

    private final PhotoSession session = new PhotoSession();

    public PhotoSession getSession() {
        return session;
    }
}