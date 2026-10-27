import java.util.Scanner;
public class BlackjackSolitaire {
    private Deck deck;
    private Card[][] board;
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
            for (int j = 0; j < board[i].length; j++) {
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
    public void play() {
        // read user input and check which discard spot is used.
        Scanner input = new Scanner(System.in);
        boolean[] discardSpots = new boolean[4];

        // repeat loop until all score spot are filled
        while (filledScoreSpots < 16) {
            Card card = deck.drawCard();
            displayBoard();
            System.out.println("Discards remaining: " + (4 - usedDiscards));
            System.out.println("Current card: " + card.getCardName());

            boolean cardHandled = false;
            while (!cardHandled) {

                int spot = 0;

                // check if input is valid
                while (spot == 0) {

                    // ask user to choose spot for current card
                    System.out.print("Choose a spot (1-20): ");
                    String userInput = input.next();
                    for (int i = 1; i <= 20; i++) {
                        if (userInput.equals("" + i)) {
                            spot = i;
                        }
                    }
                    if (spot == 0) {
                        System.out.println("Invalid spot and try again.");
                    }
                }

                // check if it is scoring spot and find row and column
                if (spot >= 1 && spot <= 16) {
                    int row;
                    int column;

                    if (spot <= 10) {
                        row = (spot - 1) / 5;
                        column = (spot - 1) % 5;
                    } else if (spot <= 13) {
                        row = 2;
                        column = spot - 10;
                    } else {
                        row = 3;
                        column = spot - 13;
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
                    int index = spot - 17;
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
        System.out.println("Game over! You scored " + calculateTotalScore() + " points.");
    }

    // calculate score of cards
    public int calculateScore(Card[] cardScore, int count) {
        int total = 0;
        int aces = 0;

        // calculate and add value of each card
        for (int i = 0; i < count; i++) {
            String rank = cardScore[i].getRank();
            if (rank.equals("A")) {
                total += 1;
                aces++;
            } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
                total += 10;
            } else if (rank.equals("2")) {
                total += 2;
            } else if (rank.equals("3")) {
                total += 3;
            } else if (rank.equals("4")) {
                total += 4;
            } else if (rank.equals("5")) {
                total += 5;
            } else if (rank.equals("6")) {
                total += 6;
            } else if (rank.equals("7")) {
                total += 7;
            } else if (rank.equals("8")) {
                total += 8;
            } else if (rank.equals("9")) {
                total += 9;
            } else if (rank.equals("10")) {
                total += 10;
            }
        }
        // count 1 ace as 11 if total does not exceed 21
        if (aces > 0 && total + 10 <= 21) {
            total += 10;
        }

        // return score
        if (total > 21) {
            return 0;
        } else if (total == 21 && count == 2) {
            return 10;
        } else if (total == 21) {
            return 7;
        } else if (total == 20) {
            return 5;
        } else if (total == 19) {
            return 4;
        } else if (total == 18) {
            return 3;
        } else if (total == 17) {
            return 2;
        } else {
            return 1;
        }
    }

    // calculate total score for game board
    public int calculateTotalScore() {
        int score = 0;
        // calculate score of each row
        for (int i = 0; i < 4; i++) {
            Card [] cardScore = new Card[5];
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (board[i][j] != null) {
                    cardScore[count] = board[i][j];
                    count++;
                }
            }
            score += calculateScore(cardScore, count);
        }

        // calculate score of each column
        for (int j = 0; j < 5; j++) {
            Card[] cardScore = new Card[4];
            int count = 0;

            for (int i = 0; i < 4; i++) {
                if (board[i][j] != null) {
                    cardScore[count] = board[i][j];
                    count++;
                }
            }
            score += calculateScore(cardScore, count);
        }
        return score;

    }
}
