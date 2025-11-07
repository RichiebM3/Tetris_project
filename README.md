# Tetris_project
learning code using tetris.
Explanation of the Code
BruceRATetris.java: This is the main class that sets up the game window, initializes the game, and handles rendering. It uses a Timer to periodically update the game state and repaint the screen.

BruceRAGame.java: This class contains the game logic, including the board setup, drawing the game state, and handling piece movement and line clearing.

BruceRAEventController.java: This class listens for key events to control the game. It allows moving and rotating the tetrominoes and dropping them.

Tetromino.java: This class represents the tetromino shapes. It includes methods to retrieve coordinates, rotate shapes, and generate random shapes.

How to Run the Game
Set Up Your Project: Create a Java project and ensure the package name is set to gameFile.
Add the Classes: Create four Java files (BruceRATetris.java, BruceRAGame.java, BruceRAEventController.java, and Tetromino.java) and copy the respective code into each file.
Compile and Run: Compile the project and run the BruceRATetris class. You should see a simple Tetris game interface where you can control the pieces using the keyboard.
Controls
Left Arrow: Move left
Right Arrow: Move right
Down Arrow: Soft drop (move down faster)
Up Arrow: Rotate the tetromino
Space: Hard drop (drop to the bottom)
Notes
The game is a basic implementation. You can enhance it by adding features like scoring, levels, and improved graphics.
The rotation logic in the Tetromino class is currently a placeholder. You can implement the actual rotation logic based on the tetromino shapes.


# BruceRATetris Game

## Overview
BruceRATetris is a simple implementation of the classic Tetris game written in Java. This project serves as an educational tool for understanding object-oriented programming, game development concepts, and Java's Swing library for creating graphical user interfaces (GUIs).

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Game Structure](#game-structure)
- [Key Classes and Their Functions](#key-classes-and-their-functions)
- [Controls](#controls)
- [Learning Objectives](#learning-objectives)
- [Future Enhancements](#future-enhancements)

## Features
- Basic Tetris gameplay mechanics
- Randomly generated tetromino shapes
- Line clearing and scoring
- Game over detection
- Simple GUI using Java Swing

## Getting Started
To run the game, follow these steps:

1. **Set Up Your Project**:
   - Create a new Java project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
   - Ensure the package name is set to `gameFile`.

2. **Add the Classes**:
   - Create four Java files: `BruceRATetris.java`, `BruceRAGame.java`, `BruceRAEventController.java`, and `Tetromino.java`.
   - Copy the respective code provided in the project into each file.

3. **Compile and Run**:
   - Compile the project.
   - Run the `BruceRATetris` class to start the game.

## Game Structure
The game consists of four main classes, each serving a specific purpose:

### Key Classes and Their Functions

1. **BruceRATetris.java**
   - **Description**: Main class that initializes the game window and handles rendering.
   - **Functions**:
     - `update()`: Calls repaint to refresh the game display.
     - `paintComponent(Graphics g)`: Draws the current game state and displays the "GAME OVER" message if applicable.
     - `main(String[] args)`: Entry point of the application, launches the game.

2. **BruceRAGame.java**
   - **Description**: Contains the game logic, including the board setup, piece movement, and line clearing.
   - **Functions**:
     - `draw(Graphics g)`: Draws the current state of the game board and active tetromino.
     - `isGameOver()`: Checks if the game is over.
     - `update()`: Updates the game state, moving the current piece down.
     - `newPiece()`: Generates a new tetromino and positions it at the top of the board.
     - `tryMove(Tetromino newPiece, int newX, int newY)`: Attempts to move the current piece to a new position.
     - `clearLines()`: Checks for and clears completed lines on the board.

3. **BruceRAEventController.java**
   - **Description**: Handles user input from the keyboard to control the game.
   - **Functions**:
     - `keyPressed(KeyEvent e)`: Responds to key events to move, rotate, or drop tetrominoes.

4. **Tetromino.java**
   - **Description**: Represents the tetromino shapes and their properties.
   - **Functions**:
     - `randomTetromino()`: Generates a random tetromino shape.
     - `rotate()`: Placeholder for rotating the tetromino (to be implemented).
     - `x(int index)` and `y(int index)`: Return the x and y coordinates of the tetromino parts.

## Controls
Use the following keyboard controls to play the game:
- **Left Arrow**: Move tetromino left
- **Right Arrow**: Move tetromino right
- **Down Arrow**: Soft drop (move down faster)
- **Up Arrow**: Rotate the tetromino
- **Space**: Hard drop (drop the tetromino to the bottom)

## Learning Objectives
By studying this project, you will learn:
- Basic concepts of object-oriented programming (OOP) in Java.
- How to create and manage a simple game loop.
- Handling user input in a GUI application.
- Implementing game logic, including collision detection and scoring.
- Using Java's Swing library for creating graphical user interfaces.

## Future Enhancements
Consider implementing the following features to enhance the game:
- Scoring system to track player performance.
- Levels of increasing difficulty.
- Sound effects and background music.
- Improved graphics and animations.
- Tetromino rotation logic for better gameplay.

## Conclusion
BruceRATetris is a great starting point for anyone interested in game development with Java. By modifying and extending this code, you can deepen your understanding of programming concepts and game mechanics.

Feel free to explore, experiment, and enhance the game!
