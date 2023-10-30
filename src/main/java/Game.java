import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Pot> pots = new ArrayList<>();
    int numberOfRoundsToPlay;


    public void setupGame() {
        promptForNumberOfRounds();
        setupPlayers();
        createPots();
    }

    public void playRounds() {

        int i = 1;
        while (i <= numberOfRoundsToPlay) {
            Round round = new Round(i, players);
            round.setPots(pots);
            round.playRound();

            System.out.printf("%n *** ROUND %d SUMMARY *** %n", i);
            for(Player player : players) {
                System.out.printf("%s: %d %n", player.getName(), player.getCoinCount());
            }

            for(Pot pot : pots) {
                System.out.printf("%s: %d %n", pot.getName(), pot.getCoins());
            }
            i++;
        }

    }

    private void promptForNumberOfRounds() {
        System.out.print("How many rounds of tedium can you stand? ");
        this.numberOfRoundsToPlay = keyboard.nextInt();
    }

    private void setupPlayers() {
        int numberOfPlayers = promptForNumberOfPlayers();
        namePlayers(numberOfPlayers);
    }

    private int promptForNumberOfPlayers() {
        int numberOfPlayers;

        System.out.print("How many people will be playing? ");
        do {
            while (!keyboard.hasNextInt()) {
                System.out.print("That's not a number. Try again: ");
                keyboard.next();
            }

            numberOfPlayers = keyboard.nextInt();

            if (numberOfPlayers > 8 || numberOfPlayers < 2) {
                System.out.print("This is a game for 2-8 players! ");
            }

        } while (numberOfPlayers > 8 || numberOfPlayers < 2);

        return numberOfPlayers;
    }

    private void namePlayers(int numberOfPlayers) {
        int i = 1;

        while (i <= numberOfPlayers) {
            System.out.printf("Name of Player %d: ", i);
            String playerName = keyboard.next();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
            i++;
        }
    }

    private void createPots() {
        Pot rummoli = new Pot("Rummoli"); pots.add(rummoli);
        Pot poker = new Pot("Poker"); pots.add(poker);
        Pot tenSpades = new Pot("10 Spades"); pots.add(tenSpades);
        Pot jackDiamonds = new Pot("Jack Diamonds"); pots.add(jackDiamonds);
        Pot queenClubs = new Pot("Queen Clubs"); pots.add(queenClubs);
        Pot kingHearts = new Pot("King Hearts"); pots.add(kingHearts);
        Pot aceSpades = new Pot("Ace of Spades"); pots.add(aceSpades);
        Pot aceKingDiamonds = new Pot("Ace and King of Diamonds"); pots.add(aceKingDiamonds);
        Pot sevenEightNine = new Pot("7-8-9 Suited"); pots.add(sevenEightNine);
    }
}
