package com.projeto.monopoly.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GameService {

    /**
     * Método responsável por gerar um número aleatório de 1 a 6
     * @return Valor gerado aleatóriamente
     */
    public static int generateDiceNumber() {
        Random random = new Random();
        int randomDiceValue = random.nextInt(1,6);
        return randomDiceValue;
    }

    /**
     * Método responsável por carregar a imagem correspondente ao valor do dado
     * @param diceValue Valor do dado gerado aleatóriamente
     * @return Imagem do valor correspondente
     * @throws FileNotFoundException Caso o arquivo não seja encontrado
     */
    public static Image getDiceImage(int diceValue) throws FileNotFoundException {
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
    public static void plotDices(Image firstDiceImage, Image secondDiceImage, AnchorPane dicesAnchor) {
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

        dicesAnchor.getChildren().add(firstDiceImageView);
        dicesAnchor.getChildren().add(secondDiceImageView);
    }

    /**
     * Método responsável por realizar a busca da Imagem correspondente à coluna e linha clicada
     * TODO: Consumir dados do JSON disponível em cardsMapping.json
     * @param columnIndex Coluna clicada
     * @param rowIndex Linha clicada
     * @return Imagem da carta correspondente
     * @throws FileNotFoundException Caso o arquivo não exista
     */
    public static Image getCardImage(int columnIndex, int rowIndex) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("cardsMapping.json"));

        String cardPosition = "column_" + columnIndex + " row_" + rowIndex;
        JSONObject cardJson = (JSONObject) jsonObject.get(cardPosition);
        String ImagePath = (String) cardJson.get("image-path");

        FileInputStream cardImage = new FileInputStream(ImagePath);
        return new Image(cardImage);
    }

    /**
     * Método responsável por exibir a carta selecionada na interface gráffica
     * @param cardImage Imagem selecionada
     * @param cardsAnchor AnchorPane em que a imagem será exibida
     */
    public static void plotCard(Image cardImage, AnchorPane cardsAnchor) {
        ImageView cardImageView = new ImageView(cardImage);
        cardImageView.setX(31);
        cardImageView.setY(217);
        cardImageView.setPreserveRatio(true);
        cardImageView.setFitHeight(290);

        cardsAnchor.getChildren().add(cardImageView);
    }
}
