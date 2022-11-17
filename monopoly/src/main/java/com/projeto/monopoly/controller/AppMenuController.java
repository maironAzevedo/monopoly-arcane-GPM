package com.projeto.monopoly.controller;

import com.projeto.monopoly.MonopolyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AppMenuController extends BaseController {
    protected Scene getGameScene() throws IOException {
        FXMLLoader gameSceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("gameScene.fxml"));
        Scene gameScene = new Scene(gameSceneLoader.load());

        return gameScene;
    }
    @FXML
    protected void StartGame(MouseEvent event) throws Exception {
        Scene gameScene = getGameScene();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        changeScene(gameScene, stage);
    }
}
