package com.projeto.monopoly.controller;

import com.projeto.monopoly.MonopolyApplication;
import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.AppMenuService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LobbyController extends BaseController {
    @FXML
    private AnchorPane addPlayerAnchor;

    @FXML
    private AnchorPane addPlayerNode;

    /**
     * Método implementado para a criação de jogadores no sistema
     * TODO: Criar uma forma que seja possível adicionar mais jogadores dinâmicamente
     * @throws IOException
     */
    public void addNewPlayer() throws IOException {
        FXMLLoader characterSelectionLoader = new FXMLLoader(MonopolyApplication.class.getResource("characterSelectionAnchor.fxml"));
        Scene characterSelectionScene = new Scene(characterSelectionLoader.load());
        Node characterSelectionRoot = characterSelectionScene.getRoot();

        addPlayerAnchor.getChildren().add(characterSelectionRoot);
    }


    /**
     * Método criado para carregar a Cena de jogo do tabuleiro
     * @param event Clique do mouse
     * @throws IOException
     */
    public void findMatch(MouseEvent event) throws IOException {
        Node clickedNode = (Node) event.getSource();
        Stage stage = (Stage) clickedNode.getScene().getWindow();

        FXMLLoader gameLoader = new FXMLLoader(MonopolyApplication.class.getResource("gameScene.fxml"));
        Scene gameScene = new Scene(gameLoader.load());
        changeScene(gameScene, stage);
    }
}
