package card.game.twenty_one;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import card.entity.Hand;
import card.entity.PlayerType;
import card.entity.Player;

public class TwentyOneTest {
    
    TwentyOne twentyOne = new TwentyOne("HA,D2,D3,D4");

    @Test
    void testScoreHandAceHigh(){
        assertEquals(21, twentyOne.scoreHand(new Hand("HA,HK")));
    }

    @Test
    void testScoreHandAceLow(){
        assertEquals(14, twentyOne.scoreHand(new Hand("HA,HK,H3")));
    }

    @Test
    void testScoreHandFive(){
        assertEquals(20, twentyOne.scoreHand(new Hand("H2,H3,H4,H5,H6")));
    }

    @Test
    void testScoreHandBust(){
        assertEquals(0, twentyOne.scoreHand(new Hand("HK,H3,H4,H5,H6")));
    }

    @Test
    void testComputerPlaysNoDraw(){
        Player player = new Player(PlayerType.COMPUTER, "Comp 1");
        player.addHand(new Hand("HA,HK"));
        twentyOne.computerPlays(player);
        assertEquals("HA, HK", player.getHand().toString());
    }

    @Test
    void testComputerPlaysDraw(){
        Player player = new Player(PlayerType.COMPUTER, "Comp 1");
        player.addHand(new Hand("DK,H2"));
        twentyOne.computerPlays(player);
        assertEquals("DK, H2, D4", player.getHand().toString());
    }

    @Test
    void testComputerPlaysDrawTwice(){
        Player player = new Player(PlayerType.COMPUTER, "Comp 1");
        player.addHand(new Hand("D7,H2"));
        twentyOne.computerPlays(player);
        assertEquals("D7, H2, D4, D3", player.getHand().toString());
    }
}
