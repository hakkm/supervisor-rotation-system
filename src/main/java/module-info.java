module com.khabir.supervisorrotationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires java.sql;

    opens com.khabir.supervisorrotationsystem to javafx.fxml;

    exports com.khabir.supervisorrotationsystem;
    exports com.khabir.supervisorrotationsystem.ui;
    opens com.khabir.supervisorrotationsystem.ui to javafx.fxml;
    exports com.khabir.supervisorrotationsystem.model;
    opens com.khabir.supervisorrotationsystem.model to javafx.fxml;
    exports com.khabir.supervisorrotationsystem.ui.controller;
    opens com.khabir.supervisorrotationsystem.ui.controller to javafx.fxml;
}