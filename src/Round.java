import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.binarySearch;

public class Round {
    private int roundNumber;

    private ArrayList<Player> activePlayers;
    Random random = new Random();

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

    private String chooseFirstCard(){
        Deck deck = new Deck();
        return deck.getRandomCard();
    }

    /**
     * Randomly select an active player to begin the round. Pseudo-simulates winning the poker round.
     * @return The player to begin the round as a Player object.
     */
    public Player chooseStartingPlayer(){
        Player startingPlayer = activePlayers.get(random.nextInt(activePlayers.size()));
        return startingPlayer;
    }

    /**
     * Returns the lowest value card in the player's hand. If multiple cards are of the same
     * value, then the first in the randomly assorted arraylist is used.
     * @param player The players whose hand is being played.
     * @return The lowest value card in the player's hand as a string in the format 'Value Suit'.
     */
    public String startingCard(Player player){
//        ArrayList<String> startingPlayerHand = activePlayers.get(chooseStartingPlayer()).hand;
//        System.out.println(startingPlayerHand);
        int playerPosition = activePlayers.indexOf(player);
        ArrayList<String> startingPlayerHand = activePlayers.get(playerPosition).hand;

        for (int i = 2; i <= 10; i++){
            for(int j = 0; j < startingPlayerHand.size(); j++){
                if (startingPlayerHand.get(j).startsWith(String.valueOf(i))){
                    return startingPlayerHand.get(j);
                }
            }
        }
        return null;
    }

    public String nextCard(String currentCard){
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "End"};
        List<String> valueTable = Arrays.asList(values);
        String[] curCard = currentCard.split(" ");
        String value = curCard[0];
        String suit = curCard[1];

        String nextValue = valueTable.get(valueTable.indexOf(value) + 1);

        if (nextValue.equals("End")){
            return "End";
        }
        else{
            return nextValue + " " + suit;
        }
    }

    /**
     * Prints the card being played, and the player who played it.
     * Removes it from that player's hand.
     * @param card The card to be played as a String.
     */
    public void playCard(String card){
        for(Player player : activePlayers){
            if(player.hand.contains(card)){
                System.out.printf("%s plays %s %n", player.getName(), card);
                player.hand.remove(card);
            }
        }
    }

    /**
     * Checks hands of all active players to determine if the round is to continue.
     * If any player has zero cards in their hand, then the round is over.
     * @return 'True' if all players have cards remaining, 'False' otherwise.
     */
    public boolean continueRound(){
        for(Player player : activePlayers){
            if (player.hand.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void playRound(){
        String card = startingCard(chooseStartingPlayer());

        while(continueRound()){
            if(card.equals("End")){
                card = startingCard(chooseStartingPlayer());
            }
            else{
                playCard(card);
                card = nextCard(card);
            }
        }


    }

}
