package com.projeto.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonopolyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader ApplicationMenuLoader = new FXMLLoader(MonopolyApplication.class.getResource("appMenu.fxml"));
        Scene ApplicationMenuScene = new Scene(ApplicationMenuLoader.load());
        stage.setTitle("Monopoly Arcane");
        stage.setScene(ApplicationMenuScene);
        stage.show();

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(MonopolyApplication.class.getResource("tabuleiro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Monopoly Arcane");
        stage.setScene(scene);
        stage.show(); */
    }

    public static void main(String[] args) {
        launch();
    }
}