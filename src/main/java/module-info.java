module sample.ninemensmorris {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens sample.ninemensmorris to javafx.fxml;
    exports sample.ninemensmorris;
}