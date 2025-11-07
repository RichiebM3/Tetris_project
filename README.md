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
