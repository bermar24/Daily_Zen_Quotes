package com.example.daily_zen_quote;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    public TextField inputField;
    private String username;

    @FXML
    public Button playBtn;

    @FXML
    private void saveUsername() {
        username = inputField.getText();
        System.out.println("Username saved: " + username);
    }

    public String getUsername() {
        return username;
    }

    @FXML
    private void handlePlayButtonClick() {
        try {
            // Close the current stage
            Stage thisStage = (Stage) playBtn.getScene().getWindow();
            thisStage.close();

            // Load new scene
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("play-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



//    @FXML
//    private Stage stage;
//    @FXML
//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }
//    @FXML
//    public void game(String userInput) throws IOException {
//
//        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
//        stage.setTitle("Daily Zen Quotes!");
//        stage.setScene(scene);
//        stage.show();
//    }

//    @FXML
//    protected void onHelloButtonClick() throws IOException {
//        String userInput = inputField.getText();
//        System.out.println("Hello " + userInput);
//        game(userInput);
//    }


//
//    @FXML
//    private Label questionLabel, resultLabel;
//    @FXML
//    private RadioButton option1, option2, option3, option4;
//
//    @FXML
//    private ToggleGroup optionsGroup;
//
//    @FXML
//    private void checkAnswer() {
//        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
//
//        if (selectedOption != null) {
//            String answer = selectedOption.getText();
//            if ("4".equals(answer)) {
//                resultLabel.setText("Correct! 🎉");
//                resultLabel.setStyle("-fx-text-fill: green;");
//            } else {
//                resultLabel.setText("Incorrect! Try again.");
//                resultLabel.setStyle("-fx-text-fill: red;");
//            }
//        } else {
//            resultLabel.setText("Please select an option.");
//            resultLabel.setStyle("-fx-text-fill: orange;");
//        }
//    }
