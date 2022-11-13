package com.projeto.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonopolyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader ApplicationMenuLoader = new FXMLLoader(MonopolyApplication.class.getResource("tabuleiro.fxml"));
        Scene ApplicationMenuScene = new Scene(ApplicationMenuLoader.load());
        stage.setTitle("Monopoly Arcane");
        stage.setScene(ApplicationMenuScene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}