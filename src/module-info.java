module SAI {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.logging;
    requires java.se;
    requires commons.net;
    requires ftpserver.core;
    requires ftplet.api;
    requires junit;
    requires orientdb;
    requires org.controlsfx.controls;

    opens core.application;
}