package com.projeto.monopoly.controller;

import com.projeto.monopoly.MonopolyApplication;
import com.projeto.monopoly.interfaces.IBaseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Timer;

public class BaseController implements IBaseController {

    public void showLoadingScene(Stage stage) throws Exception {
        Timer timer = new Timer();
        FXMLLoader loadingSceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("loadingScene.fxml"));
        Scene loadingScene = new Scene(loadingSceneLoader.load());
        stage.setScene(loadingScene);
        timer.wait(200);
    }

    public void changeScene(Scene requiredScene, Stage stage) throws Exception {
        stage.setScene(requiredScene);
    }
}
