package com.projeto.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonopolyApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menuSceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("menuScene.fxml"));
        Scene menuScene = new Scene(menuSceneLoader.load());

        stage.setTitle("Monopoly Arcane");
        stage.setScene(menuScene);
        stage.show();
    }
        public static void main(String[] args) {
        launch();
    }
}