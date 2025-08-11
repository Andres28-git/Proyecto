module com.futurotech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires javafx.base;
    opens com.futurotech to javafx.fxml;
    exports com.futurotech;

    opens com.futurotech.model to javafx.base, jakarta.persistence, eclipselink;
    exports com.futurotech.model;

    opens com.futurotech.controller to javafx.fxml;
    exports com.futurotech.controller;

    opens com.futurotech.controller.entity to javafx.base, jakarta.persistence, eclipselink;
    exports com.futurotech.controller.entity;
}
