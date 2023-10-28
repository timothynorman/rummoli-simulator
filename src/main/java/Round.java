import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Round {
    private int roundNumber;

    private ArrayList<Player> activePlayers;
    private ArrayList<Pot> pots;

    public ArrayList<Pot> getPots() {
        return pots;
    }

    public void setPots(ArrayList<Pot> pots) {
        this.pots = pots;
    }

    Player ghost = new Player("GhostHand");
    private Player currentPlayer;
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

    /**
     * Randomly deals all cards in a deck (minus Jokers) to all active players.
     * Depending on number of players, some may have one more card than others.
     */
    public void dealHands(){
        Deck deck = new Deck();
        ArrayList<String> shuffledDeck = deck.getShuffledDeck();
        ArrayList<Player> playersAndGhost = new ArrayList<>(activePlayers);
        playersAndGhost.add(ghost);

        int i = 0;
        int player = 0;
        while(i < shuffledDeck.size()){
            playersAndGhost.get(player).hand.add(shuffledDeck.get(i));
            i++;
            player++;
            // Return next card to first player if last player was just dealt.
            if (player > playersAndGhost.size()-1){
                player = 0;
            }
        }
    }

    /**
     * Randomly select an active player to begin the round. Pseudo-simulates winning the poker round.
     * @return The player to begin the round as a Player object.
     */
    public Player chooseStartingPlayer(){
        Player startingPlayer = activePlayers.get(random.nextInt(activePlayers.size()));
        // Payout for "winning" the poker hand.
        System.out.printf("%s wins %d from the poker hand! %n", startingPlayer.getName(), pots.get(1).getCoins());
        pots.get(1).payOut(startingPlayer);
        return startingPlayer;
    }

    /**
     * Returns the lowest value card in the player's hand. If multiple cards are of the same
     * value, then the first in the randomly assorted arraylist is used.
     * @param player The players whose hand is being played.
     * @return The lowest value card in the player's hand as a string in the format 'Value Suit'.
     */
    public String lowestCard(Player player){
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String v : values){
            for (String s : player.hand) {
                if (s.startsWith(v)) {
                    return s;
                }
            }
        }
        return null;
    }

    /**
     * Determines the next card in the sequence based on the card just played.
     * Cards are played from 2 -> Ace in a single suit.
     * @param currentCard The card currently played as a String.
     * @return The next card in the sequence in the format 'Value Suit' as a String.
     */
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
                currentPlayer = player;
                player.hand.remove(card);
                testForPayouts(card);
            }
        }
    }

    private void testForPayouts(String card) {
        if(card.equals("10 Spades")){
            System.out.printf("%s wins %d from 10 Spades pot! %n", currentPlayer.getName(), pots.get(2).getCoins());
            pots.get(2).payOut(currentPlayer);
        }
        if(card.equals("Jack Diamonds")){
            System.out.printf("%s wins %d from Jack of Diamonds pot! %n", currentPlayer.getName(), pots.get(3).getCoins());
            pots.get(3).payOut(currentPlayer);
        }
        if(card.equals("Queen Clubs")){
            System.out.printf("%s wins %d from Queen of Clubs pot! %n", currentPlayer.getName(), pots.get(4).getCoins());
            pots.get(4).payOut(currentPlayer);
        }
        if(card.equals("King Hearts")){
            System.out.printf("%s wins %d from King of Hearts pot! %n", currentPlayer.getName(), pots.get(5).getCoins());
            pots.get(5).payOut(currentPlayer);
        }
        if(card.equals("Ace Spades")){
            System.out.printf("%s wins %d from ACE OF SPADES pot! %n", currentPlayer.getName(), pots.get(6).getCoins());
            pots.get(6).payOut(currentPlayer);
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

    /**
     * Plays one round. Round ends when a player's hand is empty.
     * Rules of Rummoli as per: <a href="https://en.wikipedia.org/wiki/Rummoli#Play">...</a>
     */
    public void playRound(){
        for(Pot pot : pots) {
            pot.payIn(activePlayers);
        }

        dealHands();

        String card = lowestCard(chooseStartingPlayer());

        while(continueRound()){
            if(ghost.hand.contains(card)){
                System.out.printf("* %s is burned * %n", card);
                card = lowestCard(currentPlayer);
            }
            else if(card.equals("End")){
                card = lowestCard(currentPlayer);
            }
            else{
                playCard(card);
                card = nextCard(card);
            }
        }
        // Payout for winning the round.
        System.out.printf("%s wins %d from Rummoli! %n", currentPlayer.getName(), pots.get(0).getCoins());
        pots.get(0).payOut(currentPlayer);
    }

}
