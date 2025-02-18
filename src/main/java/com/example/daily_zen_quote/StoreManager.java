package com.example.daily_zen_quote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreManager {
    private static final String FILE_PATH = "scores.json";

    public static List<UserScore> loadScores() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, new TypeReference<List<UserScore>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveScores(List<UserScore> scores) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        File directory = file.getParentFile();

        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        try {
            objectMapper.writeValue(file, scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUserScore(String username, int score) {
        List<UserScore> scores = loadScores();
        scores.add(new UserScore(username, score));
        saveScores(scores);
    }

    public static int checkScore(String username) {
        if (Objects.equals(username, "Guest")) {
            return 0;
        } else {
                List<UserScore> scores = loadScores();

                for (UserScore user : scores) {
                    if (user.getUsername().equalsIgnoreCase(username)) {
                        return user.getScore();
                    }
                }
        addUserScore(username, 0);
        return 0;
    }
        }

    public static void changeUserScore(String username, int newScore) {
        if (Objects.equals(username, "Guest")) {
            newScore = 0;
        }
        List<UserScore> scores = loadScores();
        boolean userFound = false;

        for (UserScore user : scores) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setScore(newScore); // Update the score
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            addUserScore(username, newScore); // Add new user if not found
        } else {
            saveScores(scores); // Save updated scores
        }
    }
}
