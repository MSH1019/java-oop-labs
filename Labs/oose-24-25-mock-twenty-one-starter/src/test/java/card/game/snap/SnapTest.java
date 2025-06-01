package card.game.snap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import card.entity.Hand;
import communication.YesOrNo;

public class SnapTest {

    Snap snap = new Snap();

    @Test
    void testDealCards(){
        snap.createComputerCompetitors(4);
        snap.dealCards();
        assertEquals(13, snap.getUser().getHand().size());
    }

    @Test
    void testSnapOverride(){
        Snap snap = new Snap("S3,S4,S5");
        assertEquals(3, snap.getDeck().size());
    }

    @Test
    void testSnapNoOverride(){
        assertEquals(52, snap.getDeck().size());
    }

    @Test
    void testHasSnapped(){
        Hand hand = new Hand("S3,S4,C4");
        snap.createHumanPlayer("Derek");
        snap.hasSnapped(YesOrNo.YES, hand);
        assertEquals(1, snap.getUser().getScore());
    }


    @Test
    void testHasSnappedNo(){
        Hand hand = new Hand("S3,S4,C4");
        snap.createHumanPlayer("Derek");
        snap.hasSnapped(YesOrNo.NO, hand);
        assertEquals(0, snap.getUser().getScore());
    }

    @Test
    void testHasSnappedNoDifferent(){
        Hand hand = new Hand("S3,S4,C5");
        snap.createHumanPlayer("Derek");
        snap.hasSnapped(YesOrNo.NO, hand);
        assertEquals(0, snap.getUser().getScore());
    }


    @Test
    void testHasSnappedWithDifferntCards(){
        Hand hand = new Hand("S3,S4,C5");
        snap.createHumanPlayer("Derek");
        snap.hasSnapped(YesOrNo.YES, hand);
        assertEquals(-1, snap.getUser().getScore());
    }

    
}
