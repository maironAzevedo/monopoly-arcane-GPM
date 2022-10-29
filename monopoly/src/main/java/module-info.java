module com.projeto.monopoly {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.projeto.monopoly to javafx.fxml;
    exports com.projeto.monopoly;
}