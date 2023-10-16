import java.util.ArrayList;

public class Player {

    public Player(){}
    public Player(String name){
        this.name = name;
    }

    private String name;
    private int coinCount = 30;
    private boolean isActive = true;
    public ArrayList<String> hand = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public void adjustCoins(int amount){
        coinCount += amount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
