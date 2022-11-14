package com.projeto.monopoly;

import com.projeto.monopoly.controller.AppMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonopolyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader appMenuLoader = new FXMLLoader(MonopolyApplication.class.getResource("appMenu.fxml"));
        Scene appMenuScene = new Scene(appMenuLoader.load());

        stage.setTitle("Monopoly Arcane");
        stage.setScene(appMenuScene);
        stage.show();
    }
        public static void main(String[] args) {
        launch();
    }
}