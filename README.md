# Daily Zen & Quote Guessing Game

## Project Overview

The **Daily Zen & Quote Guessing Game** is an interactive application designed to provide users with a daily motivational quote and engage them in a fun guessing game. Users are presented with a Zen quote and have to guess the author from multiple choices. This project combines motivational content and interactive gameplay to create a useful tool for daily inspiration.

## Components

- **Daily Motivational Quotes**: The app fetches a new Zen quote every day from a public API.
- **Multiple-Choice Quiz**: Users are given four possible authors for each quote and must select the correct one.
- **Scoring System**: Tracks correct and incorrect guesses, displaying the user's performance.
- **User Interaction**: Provides options to retry the quiz or get a new quote after each guess.
- **Data Storage**: Uses **JSON** to handle data fetched from the API and stores user scores.
- **User Interface**: Simple and intuitive interface built using **JavaFX**.

## Tech Stack

- **Programming Language**: Java
- **User Interface**: JavaFX (for UI components and styling)
- **API**: Quotable API (for fetching daily quotes and authors)
- **Data Handling**: JSON (for parsing and manipulating quote data)
- **Randomization**: For randomizing the multiple-choice authors

## Expected Results

The final application will be a **working game** where:
- Users will receive a **new daily Zen quote**.
- The app will present a **multiple-choice quiz** with four possible authors, and the user will select the correct one.
- The game will **track the user's score** (correct/incorrect answers).
- Users can opt to **retry the quiz** or fetch a new quote.

The project will have a simple UI and will function as an interactive tool to engage users in a daily motivational routine.

## Concepts Covered

This project demonstrates the following key concepts:

- **Conditions, Loops, Functions, Data Types**: Used for managing game flow, user inputs, and logic for displaying correct/incorrect answers.
- **API**: Fetching data (quotes and authors) from an external API (Quotable API).
- **Graphics**: Creating and styling a simple UI using JavaFX.
- **Data Manipulation**: Parsing and handling **JSON** data to extract quotes and authors.
- **Randomization**: Shuffling authors for the multiple-choice quiz.
