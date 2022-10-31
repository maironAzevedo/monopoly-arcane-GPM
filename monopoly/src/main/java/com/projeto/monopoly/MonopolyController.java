package com.projeto.monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MonopolyController {
    @FXML
    private Label welcomeText;

    @FXML
    private GridPane grid;

    @FXML
    private Pane person1;

    /**
     * Ação utilizada quando se clica o botão centralziado no tabuleiro responsável pela movimentação do boneco.
     */
    @FXML
    protected void onMove() {
        int indexColumn = this.grid.getColumnIndex(this.person1);
        int indexRow = this.grid.getRowIndex(this.person1);


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