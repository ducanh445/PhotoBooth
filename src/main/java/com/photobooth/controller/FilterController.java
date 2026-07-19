package com.photobooth.controller;

import com.photobooth.core.App;
import com.photobooth.service.FilterService;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class FilterController {

    @FXML
    private ImageView imageView;

    private final FilterService filterService = new FilterService();

    private File currentFile;

    @FXML
    public void initialize(){

        currentFile = App.getSession().getPrintFile();

        refresh();

    }

    private void refresh(){

        imageView.setImage(
                new Image(currentFile.toURI().toString()+"?"+System.currentTimeMillis())
        );

    }

    @FXML
    private void gray(){

        try{

            filterService.gray(currentFile);

            refresh();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    private void sepia(){

        try{

            filterService.sepia(currentFile);

            refresh();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    private void invert(){

        try{

            filterService.invert(currentFile);

            refresh();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    private void original(){

        refresh();

    }

    @FXML
    private void save(){

        App.getSceneManager().switchScene("/fxml/Preview.fxml");

    }

    @FXML
    private void back(){

        App.getSceneManager().switchScene("/fxml/Preview.fxml");

    }

}