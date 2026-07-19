package com.photobooth.controller;

import com.photobooth.core.App;
import com.photobooth.service.PrintService;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class PrintController {

    @FXML
    public void initialize(){

        new Thread(() -> {

            try{

                PrintService service = new PrintService();

                service.print(App.getSession().getPrintFile());

                Thread.sleep(2000);

                Platform.runLater(() ->
                        App.getSceneManager()
                                .switchScene("/fxml/QR.fxml"));

            }
            catch(Exception e){

                e.printStackTrace();

            }

        }).start();

    }

}