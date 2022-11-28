package com.projeto.monopoly.controller;

import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GameController extends BaseController {
    @FXML
    private GridPane grid;

    @FXML
    private Pane person1;

    @FXML
    private AnchorPane cardsAnchor;

    @FXML
    private AnchorPane dicesAnchor;

    /** Método responsável por realizar a lógica da rolagem de dados no jogo
    * @return Inteiro que representa a soma dos valores dos dados
    * @throws FileNotFoundException Caso a imagem não seja encontrada
    */
    @FXML
    public int rollDices() throws FileNotFoundException {
        dicesAnchor.getChildren().clear();

        int firstDiceValue = GameService.generateDiceNumber();
        Image firstDiceImage = GameService.getDiceImage(firstDiceValue);

        int secondDiceValue = GameService.generateDiceNumber();
        Image secondDiceImage = GameService.getDiceImage(secondDiceValue);

        GameService.plotDices(firstDiceImage, secondDiceImage, dicesAnchor);

        int totalDiceValue = firstDiceValue + secondDiceValue;
        return totalDiceValue;
    }

    /**
     * Método responsável pela exibição gráfica de cartas
     * @param mouseEvent Evento de clique na grid
     * @throws FileNotFoundException caso a imagem não seja encontrada
     */
    @FXML
    public void showCard(javafx.scene.input.MouseEvent mouseEvent) throws IOException, ParseException {
        cardsAnchor.getChildren().clear();

        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();
        int columnIndex = GridPane.getColumnIndex(clickedNode);
        int rowIndex = GridPane.getRowIndex(clickedNode);

        Image cardImage = GameService.getCardImage(columnIndex, rowIndex);
        GameService.plotCard(cardImage, cardsAnchor);
    }
    /**
     * Método utilizado para implementar a lógica de movimentação do jogador
     */
    @FXML
    protected void onMove() {
        int indexColumn = GridPane.getColumnIndex(this.person1);
        int indexRow = GridPane.getRowIndex(this.person1);


        if(indexRow == 10 && indexColumn > 0){
            indexColumn--;
            this.grid = new GridPane();
            GridPane.setColumnIndex(this.person1, indexColumn);
        } else if(indexColumn == 0 && indexRow >= 1) {
            indexRow--;
            this.grid = new GridPane();
            GridPane.setRowIndex(this.person1, indexRow);
        } else if(indexRow == 0 && indexColumn < 10) {
            indexColumn++;
            this.grid = new GridPane();
            GridPane.setColumnIndex(this.person1, indexColumn);
        } else if(indexColumn == 10 && indexRow >= 0){
            indexRow++;
            this.grid = new GridPane();
            GridPane.setRowIndex(this.person1, indexRow);
        }
    }
}