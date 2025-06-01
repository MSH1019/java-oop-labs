package card.game.snap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import card.game.snap.Snap;
import card.entity.Card;
import card.entity.FaceCard;
import card.entity.Hand;
import card.entity.Suit;
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
    void testCorrectSnapCall(){
        Hand discardPile = new Hand();
        snap.createComputerCompetitors(2);
        snap.dealCards();
        discardPile.add(new Card(Suit.HEARTS, FaceCard.KING));
        discardPile.add(new Card(Suit.SPADES, FaceCard.KING));
        snap.hasSnapped(YesOrNo.YES, discardPile);
        assertEquals(1, snap.getUser().getScore());
    }

    @Test
    void testIncorrectSnapCall() {
        Hand discardPile = new Hand();
        snap.createComputerCompetitors(2);
        snap.dealCards();
        discardPile.add(new Card(Suit.HEARTS, FaceCard.KING));
        discardPile.add(new Card(Suit.DIAMONDS, FaceCard.QUEEN));
        
        snap.hasSnapped(YesOrNo.YES, discardPile);
        assertEquals(-1, snap.getUser().getScore());
}



    @Test
    void testMissedSnapOpportunity() {
        Snap snap = new Snap();
        Hand discardPile = new Hand();
        snap.createComputerCompetitors(2);
        snap.dealCards();
        discardPile.add(new Card(Suit.HEARTS, FaceCard.KING));
        discardPile.add(new Card(Suit.SPADES, FaceCard.KING));
        
        snap.hasSnapped(YesOrNo.NO, discardPile);
        
        assertEquals(0, snap.getUser().getScore());
    }


    @Test
    void testSnapWithEmptyDiscardPile() {
    Snap snap = new Snap();
    Hand discardPile = new Hand();
    snap.createComputerCompetitors(2);
    snap.dealCards();

    if (discardPile.size() < 2) {
        discardPile.add(new Card(Suit.HEARTS, FaceCard.ACE));
        discardPile.add(new Card(Suit.DIAMONDS, FaceCard.TWO));
    }

    snap.hasSnapped(YesOrNo.YES, discardPile);

    assertEquals(-1, snap.getUser().getScore());
}

}

