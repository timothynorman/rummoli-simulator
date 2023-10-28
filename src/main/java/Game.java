import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();

    public void setupPlayers() {
        int numberOfPlayers = promptForNumberOfPlayers();
        namePlayers(numberOfPlayers);

        System.out.println("The players are: ");
        players.forEach(player -> System.out.println(player.getName()));
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

/*
    Round one = new Round();
        one.setActivePlayers(actives);

//        one.dealHands();

    ArrayList<Pot> pots = new ArrayList<>();
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

        one.setPots(pots);
        one.playRound();

        for(Player player : actives){
        System.out.println(player.getCoinCount());
    }


 */
}
