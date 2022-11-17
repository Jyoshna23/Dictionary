package com.example.dictonary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;

    @Override
    public void start(Stage stage) throws IOException {

        root = new Group();

        GamePage game = new GamePage();
        root.getChildren().add(game.root);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("WordDictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}