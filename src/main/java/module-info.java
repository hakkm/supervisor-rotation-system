module com.khabir.supervisorrotationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.khabir.supervisorrotationsystem to javafx.fxml;
    exports com.khabir.supervisorrotationsystem;
}