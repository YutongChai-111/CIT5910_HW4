public class Deck {
    private Card[] cards;
    private int nextCard;

    // create deck of cards (52)
    public Deck() {
        cards = new Card[52];
        nextCard = 0;
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suit = {"H", "C", "D", "S"};
        int index = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                cards[index] = new Card(rank[j], suit[i]);
                index++;
            }
        }
    }
}
