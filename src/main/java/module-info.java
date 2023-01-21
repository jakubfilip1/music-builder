module musicbuilder.musicbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;


    opens musicbuilder.musicbuilder to javafx.fxml;
    exports musicbuilder.musicbuilder;
}