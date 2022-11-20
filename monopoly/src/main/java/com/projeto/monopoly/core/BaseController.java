package com.projeto.monopoly.core;

import com.projeto.monopoly.MonopolyApplication;
import com.projeto.monopoly.core.interfaces.IBaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;

public class BaseController implements IBaseController {

    /**
     * Método responsável por carregar a tela de loading entre uma cena e outra
     * TODO: Entender porque o sistema não consegue fazer a troca de cenas (talvez precise de um controller pra loading)
     * @param stage Objeto onde é feita as iterações entre telas
     * @throws Exception
     */
    public void showLoadingScene(Stage stage) throws Exception {
        Timer timer = new Timer();
        FXMLLoader loadingSceneLoader = new FXMLLoader(MonopolyApplication.class.getResource("loadingScene.fxml"));
        Scene loadingScene = new Scene(loadingSceneLoader.load());
        stage.setScene(loadingScene);
        timer.wait(200);
    }

    /**
     * Método responsável por trocar a cena do sistema
     * @param requiredScene cena desejada
     * @param stage Objeto onde será feita as interações entre telas
     */
    public void changeScene(Scene requiredScene, Stage stage) {
        stage.setScene(requiredScene);
    }
}
