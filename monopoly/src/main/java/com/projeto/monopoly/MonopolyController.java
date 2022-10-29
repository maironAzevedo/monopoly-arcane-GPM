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

    @FXML
    protected void onMove() {
        int indexColumn = this.grid.getColumnIndex(this.person1);
        int indexRow = this.grid.getRowIndex(this.person1);

        indexColumn--;

        this.grid = new GridPane();

        // 10/10 9/10 8/10 7/10 6/10/ 5/10 4/10 3/10 2/10 1/10 0/10
        // 0/9 0/8 0/7 0/6 0/5 0/4 0/3 0/2 0/1 0/0
        // 1/0 2/0 3/0 4/0 5/0 6/0 7/0 8/0 9/0 10/0
        // 10/1 10/2 10/3 10/4 10/5 10/6 10/7 10/8 10/9 10/10
        this.grid.setColumnIndex(this.person1, indexColumn);
    }
}