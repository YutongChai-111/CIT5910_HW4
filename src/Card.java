public class Card {
    private String rank;
    private String suit;

    // use constructor to create card with rank and suit
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // use getter method and return rank of card
    public String getRank() {
        return rank;
    }

    // use getter method and return suit of card
    public String getSuit() {
        return suit;
    }

    // return card‘s rank and suit as String, "KH" or "3D"
    public String getCardName() {
        return rank + suit;
    }

}
