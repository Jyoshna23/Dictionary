package com.example.dictonary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GamePageController {

    wordDictionary dictionaryList;

    @FXML
    TextField search;

    @FXML
    TextField word;

    @FXML
    TextField meaning;
    @FXML
    public void newword(MouseEvent event){
        System.out.println("New word Added");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Adding new word ");
        if(word.textProperty().get().equals("") || meaning.textProperty().get().equals("")){
            infoAlert.setContentText("Enter any word/ meaning");
            infoAlert.showAndWait();
        }
        dictionaryList.addword(word.textProperty().get(),meaning.textProperty().get());
        dictionaryList.serializeMap();
    }

    @FXML

    public void search(MouseEvent event){
        System.out.println("Searching for the word");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Search Result");
        if(search.textProperty().get().equals("")){
            infoAlert.setContentText(dictionaryList.getwordList().get("Please Enter a word to search"));
            infoAlert.showAndWait();
        }
        if(dictionaryList.getwordList().containsKey(search.textProperty().get())){
            System.out.println(dictionaryList.getwordList().get(search.textProperty().get()));
            infoAlert.setContentText(dictionaryList.getwordList().get(search.textProperty().get()));
            infoAlert.showAndWait();
        }
        else{
            infoAlert.setContentText("Word not found in the Dictionary");
            infoAlert.showAndWait();
        }
    }
}
