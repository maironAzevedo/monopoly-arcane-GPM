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
    public static Scene getLobbyScene() throws IOException {
        FXMLLoader lobbySceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("lobbyScene.fxml"));
        Scene lobbyScene = new Scene(lobbySceneLoader.load());

        return lobbyScene;
    }
}
