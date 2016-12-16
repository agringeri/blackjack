package blackjack;

public class Deck {
    
    public Card[] cards = new Card[52];
    
    public Deck(Card[] c) {
        cards = c;
    }
    
    // will return the array of cards
    public Card[] getCards() {
        return cards;
    }
    
    public Card getCard(int i) {
        return cards[i];
    }
}