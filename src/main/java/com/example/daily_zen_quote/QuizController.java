package com.example.daily_zen_quote;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.*;


public class QuizController {
    
    @FXML
    public Label quote;
    @FXML
    public Button opt1, opt2, opt3, opt4;

    private String correctAuthor;

    @FXML
    private void initialize(){
        loadQuestions();
    }

    public void loadQuestions() {
        String[] quotesArray = fetchQuot.getQuotes();
        if (quotesArray.length == 0) {
            System.out.println("No quotes available.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(quotesArray.length);
        String selectedQuote = quotesArray[randomIndex];

        String quoteText = selectedQuote.split("\" - ")[0].replace("\"", "");
        correctAuthor = selectedQuote.split("\" - ")[1];

        HashSet<String> otherAuthors = new HashSet<>();
        while (otherAuthors.size() < 3) {
            int index = random.nextInt(quotesArray.length);
            String author = quotesArray[index].split("\" - ")[1];

            if (!author.equals(correctAuthor)) {
                otherAuthors.add(author);
            }
        }

        List<String> options = new ArrayList<>(otherAuthors);
        options.add(correctAuthor);
        Collections.shuffle(options);

        quote.setText(quoteText);
        opt1.setText(options.get(0));
        opt2.setText(options.get(1));
        opt3.setText(options.get(2));
        opt4.setText(options.get(3));
    }

    @FXML
    public void opt1clicked(ActionEvent actionEvent) {
        checkAnswer (opt1.getText());
    }
    
    @FXML
    public void opt2clicked(ActionEvent actionEvent) {
    }

    @FXML
    public void opt3clicked(ActionEvent actionEvent) {
    }

    @FXML
    public void opt4clicked(ActionEvent actionEvent) {
    }


    @FXML
    public void checkAnswer(String answer) {
        if (answer.equals(correctAuthor)) {
            quote.setText("Correct! 🎉");
            quote.setStyle("-fx-text-fill: green;");
        } else {
            quote.setText("Almost! Try the next.");
            quote.setStyle("-fx-text-fill: red;");
        }
    }
}
