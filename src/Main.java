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

        one.dealHands();

//        System.out.printf("%s %s %n", player1.getName(), player1.hand);
//        System.out.printf("%s %s %n", player2.getName(), player2.hand);
//        System.out.printf("%s %s %n", player3.getName(), player3.hand);

//        String card = "Ace Spades";
//        for(Player player : actives){
//            if (player.hand.contains(card)){
//                System.out.printf("%s plays %s%n", player.getName(), card);
//                player.hand.remove(card);
//                System.out.println(player.hand);
//            }
//        }

//        System.out.printf("Starting Player: %s %n", one.chooseStartingPlayer());
//        System.out.printf("Starting card: %s %n", one.startingCard());

        System.out.println(one.startingCard(player1));
        System.out.println(one.startingCard(player2));
        System.out.println(one.startingCard(player3));

        one.playRound();
        System.out.printf("%s %s %n", player1.getName(), player1.hand);
        System.out.printf("%s %s %n", player2.getName(), player2.hand);
        System.out.printf("%s %s %n", player3.getName(), player3.hand);

    }
}