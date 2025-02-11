module com.example.daily_zen_quote {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.daily_zen_quote to javafx.fxml;
    exports com.example.daily_zen_quote;
}