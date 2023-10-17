import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Tim");
        Player player2 = new Player("Cec");
        Player player3 = new Player("Flo");
        ArrayList<Player> actives = new ArrayList<>();
        actives.add(player1);
        actives.add(player2);
        actives.add(player3);


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

        for(Pot pot : pots){
            pot.payIn(actives);
        }

        one.setPots(pots);
        one.dealHands();
        one.playRound();

        for(Player player : actives){
            System.out.println(player.getCoinCount());
        }
    }
}