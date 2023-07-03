import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        ArrayList<Player> actives = new ArrayList<>();
        actives.add(player1);
        actives.add(player2);
        actives.add(player3);


        Round one = new Round();
        one.setActivePlayers(actives);

        one.dealHands();
        System.out.println(player1.hand);
        System.out.println(player2.hand);
        System.out.println(player3.hand);

        System.out.println(one.chooseStartingCard());
    }
}