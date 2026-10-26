import java.util.Scanner;
public class BlackjackSolitaire {
    private Deck deck;
    private Card [][] board;
    private int filledScoreSpots;
    private int usedDiscards;

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

    // create Blackjack solitaire game
    public BlackjackSolitaire() {
        deck = new Deck();
        deck.shuffle();
    // create board with 4 rows and 5 column, and setup score spot and discard
        board = new Card[4][5];
        filledScoreSpots = 0;
        usedDiscards = 0;

    }



    public void play(){
    // read user input and check which discard spot is used.
        Scanner input = new Scanner(System.in);
        boolean[] usedDiscards = new boolean[4];

        // use loop until all score spot are filled
        while (filledScoreSpots < 16) {
            Card card = deck.drawCard();

        }

    }
}
