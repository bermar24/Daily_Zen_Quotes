package com.example.daily_zen_quote;


public class UserScore {
    private String username;
    private int score;

    // Default constructor (needed for JSON serialization)
    public UserScore() {}

    public UserScore(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
