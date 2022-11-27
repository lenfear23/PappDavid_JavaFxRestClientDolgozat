module hu.petrik.peoplerestclientjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens hu.petrik.dolgozat to javafx.fxml, com.google.gson;
    exports hu.petrik.dolgozat;
}