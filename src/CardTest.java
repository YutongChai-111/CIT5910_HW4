//test
public class CardTest {
    public static void main(String[] args) {
        Card card1 = new Card("K", "H");
        Card card2 = new Card("3", "D");

        System.out.println(card1.getRank());
        System.out.println(card1.getSuit());
        System.out.println(card1.getCardName());
        System.out.println(card2.getCardName());
    }
}