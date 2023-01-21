module musicbuilder.musicbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;
    requires com.google.gson;


    opens musicbuilder.musicbuilder to javafx.fxml;
    exports musicbuilder.musicbuilder;
    exports musicbuilder.musicbuilder.config;
    opens musicbuilder.musicbuilder.config to javafx.fxml;
    exports musicbuilder.musicbuilder.menu;
    opens musicbuilder.musicbuilder.menu to javafx.fxml;
    exports musicbuilder.musicbuilder.items;
    opens musicbuilder.musicbuilder.items to javafx.fxml;
    exports musicbuilder.musicbuilder.services;
    opens musicbuilder.musicbuilder.services to javafx.fxml;
    exports musicbuilder.musicbuilder.controllers;
    opens musicbuilder.musicbuilder.controllers to javafx.fxml;
}