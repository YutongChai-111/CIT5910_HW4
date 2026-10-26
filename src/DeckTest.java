// test Deck code
public class DeckTest {
    public static void main(String[] args) {
        // create new deck
        Deck deck = new Deck();
        // Shuffle deck
        deck.shuffle();

        // draw 5 cards to test
        for (int i = 0; i < 5; i++) {
            Card card = deck.drawcard();
            System.out.println(card.getCardName());
        }
    }
}