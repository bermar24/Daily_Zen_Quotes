package com.example.daily_zen_quote;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    @FXML
    private TextField inputField;
    @FXML
    public Button playBtn;

    @FXML
    private String username;

    public void setStage(Stage stage) {
    }

    @FXML
    private void saveUsername() {
        username = inputField.getText();
        if (username.isEmpty()) { username = "Guest";}
        System.out.println("Username saved: " + username);
    }

    @FXML
    private void handlePlayButtonClick() {
        try {
            saveUsername();

            // Close the current stage
            Stage thisStage = (Stage) playBtn.getScene().getWindow();

            // Load new scene
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("play-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Get the controller of the new scene
            QuizController quizController = fxmlLoader.getController();
            quizController.impUser(username);

            thisStage.setScene(scene);
            thisStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}