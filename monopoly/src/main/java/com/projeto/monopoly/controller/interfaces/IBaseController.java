package com.projeto.monopoly.controller.interfaces;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IBaseController {
    public void showLoadingScene(Stage stage) throws Exception;

    public void changeScene(Scene requiredScene, Stage stage) throws Exception;

}
