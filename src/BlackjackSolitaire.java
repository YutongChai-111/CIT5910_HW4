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


    public void play(){
    }
}
