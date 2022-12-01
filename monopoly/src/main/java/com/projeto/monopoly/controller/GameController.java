package com.projeto.monopoly.controller;

import com.projeto.monopoly.MonopolyApplication;
import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.AppMenuService;
import com.projeto.monopoly.service.GameService;
import javafx.event.ActionEvent;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Popup;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class GameController extends BaseController {
    @FXML
    private ImageView person1;
    @FXML
    private ImageView person2;
    @FXML
    private ImageView person3;
    @FXML
    private ImageView person4;
    @FXML
    private AnchorPane cardsAnchor;
    @FXML AnchorPane pauseAnchor;
    @FXML
    private AnchorPane dicesAnchor;
    @FXML
    private Button rollDicesButton;
    @FXML
    private Button mycardsButton;



    /** Método responsável por realizar a lógica da rolagem de dados no jogo
    * @return Inteiro que representa a soma dos valores dos dados
    * @throws FileNotFoundException Caso a imagem não seja encontrada
    */
    int playerCurrent = 1;
    int qtdDiceEqual = 0;
    @FXML
    public void rollDices(MouseEvent event) throws IOException, InterruptedException, ParseException {
        dicesAnchor.getChildren().clear();
        Node clickedNode = (Node) event.getSource();
        Stage primaryStage = (Stage) clickedNode.getScene().getWindow();

        ImageView[] players = new ImageView[5];
        players[1] = person1;
        players[2] = person2;
        players[3] = person3;
        players[4] = person4;

        if(qtdDiceEqual == 2) {
            qtdDiceEqual = 0;

            if(playerCurrent == 4) {
                playerCurrent = 1;
            } else {
                playerCurrent++;
            }
        }

        int firstDiceValue = GameService.generateDiceNumber();
        Image firstDiceImage = GameService.getDiceImage(firstDiceValue);

        int secondDiceValue = GameService.generateDiceNumber();
        Image secondDiceImage = GameService.getDiceImage(secondDiceValue);

        GameService.plotDices(firstDiceImage, secondDiceImage, dicesAnchor);

        int totalDiceValue = firstDiceValue + secondDiceValue;

        GameService.moveCard(players[playerCurrent], totalDiceValue);

        int playerColumnIndex = GridPane.getColumnIndex(players[playerCurrent]);
        int playerRowIndex = GridPane.getRowIndex(players[playerCurrent]);

        Long cardValue = GameService.getCardValue(playerColumnIndex,playerRowIndex);
        String cardName = GameService.getCardName(playerColumnIndex, playerRowIndex);
        Image cardImage = GameService.getCardImage(playerColumnIndex, playerRowIndex);
        GameService.generateCardPopup(cardImage, primaryStage, String.valueOf(cardValue), cardName);

        if(firstDiceValue == secondDiceValue){
            qtdDiceEqual++;
            return;
        }

        playerCurrent++;
        qtdDiceEqual = 0;

        if(playerCurrent == 5) {
            playerCurrent = 1;
        }

    }

    /**
     * Método responsável por realizar o pause do jogo
     * @param event Clique do mouse
     * @throws IOException
     */
    @FXML
    public void pauseGame(MouseEvent event) throws IOException {
        rollDicesButton.setDisable(true);
        mycardsButton.setDisable(true);

        Node clickedNode = (Node) event.getSource();
        Stage primaryStage = (Stage) clickedNode.getScene().getWindow();
        FXMLLoader pauseLoader = new FXMLLoader(MonopolyApplication.class.getResource("pauseScene.fxml"));
        Scene pauseScene = new Scene(pauseLoader.load());
        Node pauseSceneRoot = pauseScene.getRoot();

        Button pauseButton = new Button();
        pauseButton.setTranslateY(470);
        pauseButton.setTranslateX(570);
        pauseButton.setCursor(Cursor.cursor("HAND"));
        pauseButton.setStyle("-fx-background-color: #ffa500; -fx-font-family: Arial; -fx-font-size: 18px; -fx-font-weight: Bold; -fx-padding: 10px, 20px; -fx-text-fill: #FFF");
        pauseButton.setText("Voltar ao jogo");

        Popup popup = new Popup();
        popup.getContent().add(pauseSceneRoot);
        popup.getContent().add(pauseButton);
        popup.show(primaryStage);


        EventHandler<ActionEvent> pauseClickEvent = unpauseEvent -> {
            rollDicesButton.setDisable(false);
            mycardsButton.setDisable(false);
            popup.hide();};
        pauseButton.setOnAction(pauseClickEvent);


    }

    /**
     * Método responsável pela exibição gráfica de cartas
     * @param mouseEvent Evento de clique na grid
     * @throws FileNotFoundException caso a imagem não seja encontrada
     */
    @FXML
    public void showCard(javafx.scene.input.MouseEvent mouseEvent) throws IOException, ParseException {
        cardsAnchor.getChildren().clear();

        Node clickedNode = (Node) mouseEvent.getSource();
        int columnIndex = GridPane.getColumnIndex(clickedNode);
        int rowIndex = GridPane.getRowIndex(clickedNode);

        Image cardImage = GameService.getCardImage(columnIndex, rowIndex);
        GameService.plotCard(cardImage, cardsAnchor);
    }

}

