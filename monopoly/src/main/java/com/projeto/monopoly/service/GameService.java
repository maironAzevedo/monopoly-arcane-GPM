package com.projeto.monopoly.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameService {
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
    protected void plotDices(Image firstDiceImage, Image secondDiceImage, AnchorPane anchor) {
        ImageView firstDiceImageView = new ImageView(firstDiceImage);
        firstDiceImageView.setX(60);
        firstDiceImageView.setY(486);
        firstDiceImageView.setPreserveRatio(true);
        firstDiceImageView.setFitHeight(72);

        ImageView secondDiceImageView = new ImageView(secondDiceImage);
        secondDiceImageView.setX(150);
        secondDiceImageView.setY(486);
        secondDiceImageView.setPreserveRatio(true);
        secondDiceImageView.setFitHeight(72);

        anchor.getChildren().add(firstDiceImageView);
        anchor.getChildren().add(secondDiceImageView);
    }
}
