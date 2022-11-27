package com.projeto.monopoly.controller;

import com.projeto.monopoly.MonopolyApplication;
import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.AppMenuService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AppMenuController extends BaseController {
    /**
     * Método responsável por inicializar o jogo
     * @param event Evento de clique no botão
     * @throws Exception
     */
    @FXML
    public void StartGame(MouseEvent event) throws Exception {
        Node clickedNode = (Node) event.getSource();
        Scene lobbyScene = AppMenuService.getLobbyScene();
        Stage stage = (Stage) clickedNode.getScene().getWindow();
        changeScene(lobbyScene, stage);
    }
}
