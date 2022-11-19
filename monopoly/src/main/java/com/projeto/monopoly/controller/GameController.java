package com.projeto.monopoly.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class GameController {

    @FXML
    private Label welcomeText;

    @FXML
    private GridPane grid;

    @FXML
    private Pane person1;

    @FXML
    private AnchorPane anchor;

    /** Este método carrega da base de assets a imagem de dado correspondente ao valor
     * @param diceValue Valor gerado aleatóriamente
     * @return Imagem do dado
     */
    protected Image getDiceImage(int diceValue) throws FileNotFoundException {
        FileInputStream diceImage;
        String baseUrl = "src/main/resources/com/projeto/monopoly/assets/dices/";
        switch (diceValue) {
            case 1:
                diceImage = new FileInputStream(baseUrl + "dice_1.png");
                return new Image(diceImage);
            case 2:
                diceImage = new FileInputStream(baseUrl + "dice_2.png");
                return new Image(diceImage);
            case 3:
                diceImage = new FileInputStream(baseUrl + "dice_3.png");
                return new Image(diceImage);
            case 4:
                diceImage = new FileInputStream(baseUrl + "dice_4.png");
                return new Image(diceImage);
            case 5:
                diceImage = new FileInputStream(baseUrl + "dice_5.png");
                return new Image(diceImage);
            case 6:
                diceImage = new FileInputStream(baseUrl + "dice_6.png");
                return new Image(diceImage);

            default:
                return null;
        }
    }

    /**
     * Método que realiza a representação gráfica das imagens dos dados na interface
     * @param firstDiceImage imagem do primeiro dado
     * @param secondDiceImage imagem do segundo dado
     */
    protected void plotDices(Image firstDiceImage, Image secondDiceImage) {
        ImageView firstDiceImageView = new ImageView(firstDiceImage);
        firstDiceImageView.setX(105);
        firstDiceImageView.setY(486);
        firstDiceImageView.setPreserveRatio(true);
        firstDiceImageView.setFitHeight(72);

        ImageView secondDiceImageView = new ImageView(secondDiceImage);
        secondDiceImageView.setX(195);
        secondDiceImageView.setY(486);
        secondDiceImageView.setPreserveRatio(true);
        secondDiceImageView.setFitHeight(72);

        anchor.getChildren().add(firstDiceImageView);
        anchor.getChildren().add(secondDiceImageView);
    }

    /** Método responsável por realizar a lógica da rolagem de dados no jogo
    * @param mouseEvent Evento de clique no botão
    * @return Inteiro que representa a soma dos valores dos dados
    */
    @FXML
    protected int rollDices(javafx.scene.input.MouseEvent mouseEvent) throws FileNotFoundException {
        anchor.getChildren().clear();
        Random random = new Random();
        int firstDiceValue = random.nextInt(1,6);
        Image firstDiceImage = getDiceImage(firstDiceValue);

        int secondDiceValue = random.nextInt(1,6);
        Image secondDiceImage = getDiceImage(secondDiceValue);

        plotDices(firstDiceImage, secondDiceImage);

        int totalDiceValue = firstDiceValue + secondDiceValue;
        return totalDiceValue;
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