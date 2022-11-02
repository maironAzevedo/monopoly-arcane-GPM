module com.projeto.monopoly {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires json.simple;

    opens com.projeto.monopoly to javafx.fxml;
    exports com.projeto.monopoly;
    exports com.projeto.monopoly.controller;
    opens com.projeto.monopoly.controller to javafx.fxml;
}