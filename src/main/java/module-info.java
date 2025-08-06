module com.futurotech {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.futurotech to javafx.fxml;
    exports com.futurotech;
}
