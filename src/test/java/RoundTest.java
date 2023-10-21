import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    Round round;
    Player player;
    ArrayList<Player> activePlayers = new ArrayList<>();


    @BeforeAll
    static void setUpRound() {
    }

    @BeforeEach
    void setUp() {
        round = new Round();
        player = new Player();
    }

    @Test
    void lowestCardWithNumberCards() {
        player.hand.add("3 Hearts");
        player.hand.add("9 Hearts");
        player.hand.add("Jack Hearts");

        assertEquals("3 Hearts", round.lowestCard(player));
    }

    @Test
    void lowestCardWithFaceCards() {
        player.hand.add("Jack Hearts");
        player.hand.add("Queen Hearts");
        player.hand.add("Ace Hearts");

        assertEquals("Jack Hearts", round.lowestCard(player));
    }

    @Test
    void nextCardWithNumberCards() {
        assertEquals("8 Spades", round.nextCard("7 Spades"));
    }

    @Test
    void nextCardWithFaceCards() {
        assertEquals("King Diamonds", round.nextCard("Queen Diamonds"));
    }

    @Test
    void nextCardIsEndOfSuit() {
        assertEquals("End", round.nextCard("Ace Clubs"));
    }

    @Test
    void emptyHandEndsRound() {
        player.hand.add("2 Hearts");
        Player player2 = new Player();

        activePlayers.add(player);
        activePlayers.add(player2);

        round.setActivePlayers(activePlayers);

        assertFalse(round.continueRound());
    }

    @Test
    void fullHandsContinueRound() {
        player.hand.add("2 Hearts");
        Player player2 = new Player();
        player2.hand.add("Ace Spades");

        activePlayers.add(player2);
        activePlayers.add(player);

        round.setActivePlayers(activePlayers);

        assertTrue(round.continueRound());
    }

}