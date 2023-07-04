import java.util.ArrayList;

public class Pot {
    public Pot(String name){
        this.name = name;
    }
    private int coins = 0;
    private String name = null;

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public void payOut(Player player){
        player.adjustCoins(coins);
        coins = 0;
    }

    public void payIn(ArrayList<Player> players){
        for(Player player : players){
            coins += 1;
            player.adjustCoins(-1);
        }
    }
}
