module com.nathiel.nomina {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    opens com.nathiel.nomina to javafx.fxml, com.google.gson;
    exports com.nathiel.nomina;

}