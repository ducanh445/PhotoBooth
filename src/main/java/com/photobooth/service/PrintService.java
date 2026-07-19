package com.photobooth.service;

import java.io.File;

public class PrintService {

    public void print(File file){

        System.out.println("===================");

        System.out.println("PRINTING...");

        System.out.println(file.getAbsolutePath());

        System.out.println("===================");

    }

}