module com.temperatur_konverter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.temperatur_konverter to javafx.fxml;
    exports com.temperatur_konverter;
}
