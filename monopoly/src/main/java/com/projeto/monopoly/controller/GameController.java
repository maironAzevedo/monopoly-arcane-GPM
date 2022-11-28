package com.projeto.monopoly.controller;

import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GameController extends BaseController {


    @FXML
    private ImageView person1;

    @FXML
    private AnchorPane cardsAnchor;

    @FXML
    private AnchorPane dicesAnchor;

    /** Método responsável por realizar a lógica da rolagem de dados no jogo
    * @return Inteiro que representa a soma dos valores dos dados
    * @throws FileNotFoundException Caso a imagem não seja encontrada
    */
    @FXML
    public void rollDices() throws FileNotFoundException, InterruptedException {
        dicesAnchor.getChildren().clear();

        int firstDiceValue = GameService.generateDiceNumber();
        Image firstDiceImage = GameService.getDiceImage(firstDiceValue);

        int secondDiceValue = GameService.generateDiceNumber();
        Image secondDiceImage = GameService.getDiceImage(secondDiceValue);

        GameService.plotDices(firstDiceImage, secondDiceImage, dicesAnchor);

        int totalDiceValue = firstDiceValue + secondDiceValue;
        GameService.moveCard(person1, totalDiceValue);

    }

    /**
     * Método responsável pela exibição gráfica de cartas
     * @param mouseEvent Evento de clique na grid
     * @throws FileNotFoundException caso a imagem não seja encontrada
     */
    @FXML
    public void showCard(javafx.scene.input.MouseEvent mouseEvent) throws IOException, ParseException {
        cardsAnchor.getChildren().clear();

        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode().getParent();
        int columnIndex = GridPane.getColumnIndex(clickedNode);
        int rowIndex = GridPane.getRowIndex(clickedNode);

        Image cardImage = GameService.getCardImage(columnIndex, rowIndex);
        GameService.plotCard(cardImage, cardsAnchor);
    }

}