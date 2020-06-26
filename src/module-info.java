module SAI {
    requires javafx;
//    requires javafx.fxml;
//    requires javafx.controls;
//    requires javafx.graphics;
//    requires javafx.runtime;
    requires java.logging;
    requires java.se;
    requires commons.net;
    requires ftpserver.core;
    requires ftplet.api;
    requires junit;
    requires orientdb;
    requires org.controlsfx.controls;
    requires org.aspectj.runtime;
    requires org.jgrapht.core;
    requires org.fxyz3d;
    requires org.jzy3d;
    requires gremlin.java;

    opens core.application;
}