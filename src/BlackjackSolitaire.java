import java.util.Scanner;
public class BlackjackSolitaire {
    private Deck deck;
    private Card [][] board;
    private int filledScoreSpots;
    private int usedDiscards;

    // create Blackjack solitaire game
    public BlackjackSolitaire() {
        deck = new Deck();
        deck.shuffle();
        // create board with 4 rows and 5 column, and setup score spot and discard
        board = new Card[4][5];
        filledScoreSpots = 0;
        usedDiscards = 0;

    }
    // display game board
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
        // for not used spot in row 2 and 3, print a tab
                if (i >= 2 && (j == 0 || j == 4)) {
                    System.out.print("\t");
                } else {
                    int spot = 0;
                    if (i < 2) {
                        spot = i * 5 + j + 1;
                    } else if (i == 2) {
                        spot = 10 + j;
                    } else {
                        spot = 13 + j;
                    }
                    // if spot is empty, print spot number; otherwise print card at this spot
                    if (board[i][j] == null) {
                        System.out.print(spot + "\t");
                    } else {
                        System.out.print(board[i][j].getCardName() + "\t");
                    }
                }
            }
            // start new line after print each row
            System.out.println();
        }
    }

    // start game
    public void play(){
        // read user input and check which discard spot is used.
        Scanner input = new Scanner(System.in);
        boolean[] discardSpots = new boolean[4];

        // repeat loop until all score spot are filled
        while (filledScoreSpots < 16) {
            Card card = deck.drawCard();
            displayBoard();
            System.out.println("Current card: " + card.getCardName());

            boolean cardHandled = false;
            while (!cardHandled) {

                // ask user to choose spot for current card
                System.out.print("Choose a spot (1-20): ");
                int spot = input.nextInt();

                // check if spot in the range
                while (spot < 1 || spot > 20) {
                    System.out.println("Invalid spot and try again.");

                    System.out.print("Choose a spot (1-20): ");
                    spot = input.nextInt();
                }

                // check if it is scoring spot and find row and column
                if (spot >= 1 && spot <= 16) {
                    int row;
                    int column;

                    if (spot <= 10) {
                        row = (spot -1) / 5;
                        column = (spot -1) % 5;
                    } else if (spot <= 13) {
                        row = 2;
                        column = spot - 10;
                    } else {
                        row = 3;
                        column = spot -13;
                    }

                    if (board[row][column] == null) {
                        board[row][column] = card;
                        filledScoreSpots++;
                        cardHandled = true;
                    } else {
                        System.out.println("Spot already filled.");
                    }

                } else {
                    // check if discard spot is used
                    int index = spot -17;
                    if (discardSpots[index]) {
                        System.out.println("Discard spot is used.");
                    } else {
                        discardSpots[index] = true;
                        usedDiscards++;
                        cardHandled = true;
                    }
                }

            }
        }
    // display complete game board
    displayBoard();
    System.out.println("Completed game.");
    }
}
