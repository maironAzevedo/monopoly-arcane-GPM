package com.projeto.monopoly.service;

import com.projeto.monopoly.MonopolyApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class AppMenuService {

    /**
     * Método responsável por carregar a cena do tabuleiro do jogo
     * @return Cena do jogo
     * @throws IOException Caso exista algum erro na entrada ou saída de dados
     */
    public static Scene getGameScene() throws IOException {
        FXMLLoader gameSceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("gameScene.fxml"));
        Scene gameScene = new Scene(gameSceneLoader.load());

        return gameScene;
    }
}
