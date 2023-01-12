module musicbuilder.musicbuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens musicbuilder.musicbuilder to javafx.fxml;
    exports musicbuilder.musicbuilder;
}