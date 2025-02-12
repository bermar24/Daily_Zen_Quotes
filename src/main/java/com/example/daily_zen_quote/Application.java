package com.example.daily_zen_quote;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.paint.Color.TRANSPARENT;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("username-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Username");
        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(TRANSPARENT);
        stage.show();

        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
    }


    public static void main(String[] args) {
        launch();
    }

}