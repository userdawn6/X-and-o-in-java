ALGORITHM FOR THE X and O PROGRAM

Initialize Game:

(1) Create a 3x3 grid of buttons.

       Define winning combinations.
       Set player1_turn to true.
       Set gameWon to false.
(2) Draw UI:

        Setup the game window and display the initial game status.
(3) Handle Button Clicks:

        If the game is already won, ignore the click.
        If the clicked button is empty, mark it with "X" or "O" based on the current player's turn.
        Switch to the other player's turn.
        Update the status label to show the next player's turn.
        Check for a win or a tie.
(4) Check for Win or Tie:

         For each winning combination, check if the three buttons in the combination have the same non-empty text:
         If a winning combination is found, display the winner, set gameWon to true, and disable all buttons.
         If no winning combination is found, check if all buttons are filled:
         If all buttons are filled, display a tie message, set gameWon to true, and disable all buttons.
         If the game is won or tied, prompt to play again
(5) Disable Buttons:

          Disable all buttons to prevent further moves.
(6) Reset Board:

          Clear the text on all buttons.
          Enable all buttons.
          Reset player1_turn to true and gameWon to false.
          Update the status label to the initial state.
(7) Prompt to Play Again:

          Ask the user if they want to play again:
          If yes, reset the board.
          If no, exit the game.
