import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PotTest {
    Pot pot;

    @BeforeEach
    void setup() {
        pot = new Pot("Test Pot");
    }

    @Test
    void payOut10CoinsToPlayer() {
        pot.setCoins(10);
        Player player = new Player();

        pot.payOut(player);

        assertEquals(40, player.getCoinCount());    // Player starts with 30 coins.
        assertEquals(0, pot.getCoins());
    }

    @Test
    void payIn() {
        Player player1 = new Player();
        Player player2 = new Player();

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        pot.payIn(players);

        assertEquals(2, pot.getCoins());
        assertEquals(29, player1.getCoinCount());   // Players start with 30 coins.
        assertEquals(29, player2.getCoinCount());
    }
}