module com.khabir.supervisorrotationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires java.sql;

    opens com.khabir.supervisorrotationsystem to javafx.fxml;

    exports com.khabir.supervisorrotationsystem;
}