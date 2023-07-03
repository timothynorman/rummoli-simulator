import java.util.ArrayList;

public class Round {
    private int roundNumber;

    private ArrayList<Player> activePlayers;

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public ArrayList<Player> getActivePlayers() {
        return activePlayers;
    }

    public void setActivePlayers(ArrayList<Player> activePlayers) {
        this.activePlayers = activePlayers;
    }

    public void dealHands(){
        Deck deck = new Deck();
        ArrayList<String> shuffledDeck = deck.getShuffledDeck();

        int i = 0;
        int player = 0;
        while(i < shuffledDeck.size()){
            activePlayers.get(player).hand.add(shuffledDeck.get(i));
            i++;
            player++;
            if (player > activePlayers.size()-1){
                player = 0;
            }
        }
    }

    public String chooseStartingCard(){
        Deck deck = new Deck();
        return deck.getRandomCard();
    }
}
