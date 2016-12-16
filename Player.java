package blackjack;

public class Player {

    public Card[] hand = new Card[10];
    public int score;
    
    public Player() {
        hand = new Card[10];
        score = 0;
    }
    
    public Card[] getHand() {
        return hand;
    }
    
    public int getScore() {
        return score;
    }
    
    // add a card to a hand
    public void addCardToHand(Card c, int spot) {
    	hand[spot] = c;
    }
    
    public void addValueToScore(int val) {
        score = score + val;
    }

}