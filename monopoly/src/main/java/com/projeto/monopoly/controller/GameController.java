package com.projeto.monopoly.controller;

import com.projeto.monopoly.core.BaseController;
import com.projeto.monopoly.model.PersonModel;
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

    private PersonModel[] listaDeJogadores;

    /*public GameController(String teste) {
        System.out.println(teste);
        this.listaDeJogadores = new PersonModel[3];
        this.listaDeJogadores[1] = new PersonModel("Jadinho", person1);
        this.listaDeJogadores[2] = new PersonModel("Deno", person2);
    }*/

    @FXML
    public void rollDices() throws FileNotFoundException, InterruptedException {
        dicesAnchor.getChildren().clear();
        this.listaDeJogadores = new PersonModel[3];
        this.listaDeJogadores[1] = new PersonModel("Jadinho", person1);
        this.listaDeJogadores[2] = new PersonModel("Deno", person2);
        if(qtdDiceEqual == 2) {
            qtdDiceEqual = 0;

            if(playerCurrent == listaDeJogadores.length - 1) {
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

        GameService.moveCard(listaDeJogadores[playerCurrent].getPlayer(), totalDiceValue);

        if(firstDiceValue == secondDiceValue){
            qtdDiceEqual++;
            return;
        }

        playerCurrent++;
        qtdDiceEqual = 0;

        if(playerCurrent == listaDeJogadores.length) {
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

        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode().getParent();
        int columnIndex = GridPane.getColumnIndex(clickedNode);
        int rowIndex = GridPane.getRowIndex(clickedNode);

        Image cardImage = GameService.getCardImage(columnIndex, rowIndex);
        GameService.plotCard(cardImage, cardsAnchor);
    }

}