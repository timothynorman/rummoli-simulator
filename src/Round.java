import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Round {
    public int roundNumber;

    public ArrayList<String> activePlayers = new ArrayList<>();
    private Random random = new Random();

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void dealHands(){
        // TODO Code to assign random cards to each active player
        Deck deck = new Deck();
        System.out.println(deck.getShuffledDeck());
    }


}
