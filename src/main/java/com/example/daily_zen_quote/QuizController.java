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
    public Label userLabel;
    @FXML
    private String username;
    @FXML
    private int score;

    @FXML
    private Label quote;
    @FXML
    private Button opt1, opt2, opt3, opt4;
    @FXML
    private String correctAuthor;

    @FXML
    public Button nextBtn;
    @FXML
    public void nextBtn(ActionEvent actionEvent) {
        loadQuestions();
    }

    public void impUser(String username) {
        this.username = username;
        setUser(username);
    }

    @FXML
    public void setUser(String username) {
//        this.username = username;
        this.score = StoreManager.checkScore(username);
        userLabel.setText(username + " you have a score of: " + String.valueOf(score));

    }

    @FXML
    private void initialize(){
        loadQuestions();
    }

    public void loadQuestions() {
//        setUser(username);

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
        checkAnswer (opt2.getText());
    }

    @FXML
    public void opt3clicked(ActionEvent actionEvent) {
        checkAnswer (opt3.getText());
    }

    @FXML
    public void opt4clicked(ActionEvent actionEvent) {
        checkAnswer (opt4.getText());
    }


    @FXML
    public void checkAnswer(String answer) {
        if (answer.equals(correctAuthor)) {
            quote.setText("Correct! 🎉");
            quote.setStyle("-fx-text-fill: green;");
            score = score + 10;
            StoreManager.changeUserScore(username, score);

        } else {
            quote.setText("Almost! Try the next.");
            quote.setStyle("-fx-text-fill: red;");
        }
    }


}
