package blackjack;

public class Card {
    
    int value;
    int suit; 
    int number;
    
    public Card(int v, int s, int num) {
        value = v;
        suit = s;
        number = num;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public int getNumber() {
        return number;
    }
    
}