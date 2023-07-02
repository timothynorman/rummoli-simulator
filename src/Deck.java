import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public Deck(){
    }
    private ArrayList<String> makeDeck(){
        ArrayList<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for(String suit : suits){
            for(String card : cards){
                deck.add(card + " " + suit);
            }
        }
        return deck;
    }

    private ArrayList<String> shuffledDeck(ArrayList<String> deck){
        Collections.shuffle(deck);
        return deck;
    }

    public ArrayList<String> getShuffledDeck(){
        return shuffledDeck(makeDeck());
    }
}
