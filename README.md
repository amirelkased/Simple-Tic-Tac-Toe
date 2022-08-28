# Simple-Tic-Tac-Toe

1- Take a string entered by the user and print the game grid as in the previous stage.

2- Analyze the game state and print the result. Possible states:
  - `Game not finished` when neither side has three in a row but the grid still has empty cells.
  - `Draw` when no side has a three in a row and the grid has no empty cells.
  - `X wins` when the grid has three X’s in a row.
  - `O wins` when the grid has three O’s in a row.
  - `Impossible` when the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa (the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).
