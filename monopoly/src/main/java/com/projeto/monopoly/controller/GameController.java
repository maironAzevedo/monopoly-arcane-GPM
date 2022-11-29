package com.projeto.monopoly.controller;

import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.json.simple.parser.ParseException;

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

    @FXML
    private AnchorPane dicesAnchor;

    /** Método responsável por realizar a lógica da rolagem de dados no jogo
    * @return Inteiro que representa a soma dos valores dos dados
    * @throws FileNotFoundException Caso a imagem não seja encontrada
    */
    int playerCurrent = 1;
    int qtdDiceEqual = 0;
    @FXML
    public void rollDices() throws FileNotFoundException, InterruptedException {
        dicesAnchor.getChildren().clear();

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