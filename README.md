# Prisoner's Dilemma Game

This Java program simulates the classic game theory scenario known as the Prisoner's Dilemma, where two players must decide whether to cooperate or betray each other. The game runs for 10 rounds, and each player can make a move by choosing to cooperate (C) or defect (D). The scoring system is based on specific rules, and a Tit-for-Tat strategy is implemented for the opponent.

## Rules

To understand the game and how to play, follow these rules:

1. This game consists of only 2 players.
2. Each player has only 2 options: Cooperate (C) or Defect (D).
3. The pointing system is as follows:
   - If both players cooperate, they each get 3 points.
   - If both players defect, they each get 1 point.
   - If one player cooperates and the other defects, the defector gets 5 points, and the cooperator gets nothing.
4. The player with the highest total points at the end of 10 rounds wins.

## How to Play

1. Run the program.
2. Follow the on-screen instructions to enter your move for each round (C for Cooperate, D for Defect).
3. The computer opponent, following a Tit-for-Tat strategy, will make its move based on your previous move.
4. The results of each round, including moves and scores, will be displayed.
5. After 10 rounds, the final scores of both the player and the computer opponent will be shown.
