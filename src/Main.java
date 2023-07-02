public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();

//        player1.setEliminated(true);
//        if(player1.isEliminated){
//            System.out.println("Player is elimiated");
//        }
//        else{
//            System.out.println("Player is still in the game!");
//        }
//
//        player1.hand.add("ACE OF SPADES");
////        player1.hand.remove("ACE OF SPADES");
//        if (player1.hand.contains("ACE OF SPADES")) {
//            System.out.println("Player has best card in the game!");
//        }
//        else{
//            System.out.println(":(");
//        }

        Round one = new Round();
        one.dealHands();
    }
}