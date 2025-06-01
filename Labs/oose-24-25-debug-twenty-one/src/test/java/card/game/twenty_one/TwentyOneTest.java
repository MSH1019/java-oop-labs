package card.game.twenty_one;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import card.entity.Hand;
import card.game.twenty_one.TwentyOne;


public class TwentyOneTest {

    TwentyOne twentyOne = new TwentyOne("HA,D2,D3,D4");

    @Test
    void testScoreHandAceHigh(){
        assertEquals(twentyOne.maxScore, twentyOne.scoreHand(new Hand("HA,HK")));
    }

    @Test
    void testScoreHandAceLow(){
        assertEquals(14, twentyOne.scoreHand(new Hand("HA,HK,H3")));
    }
}
