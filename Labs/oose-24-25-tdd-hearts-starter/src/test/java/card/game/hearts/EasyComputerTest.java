package card.game.hearts;

import card.entity.Card;
import card.entity.Hand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class EasyComputerTest {

    @Test
    public void testGetComputerSwapCards() {
        Hand hand = new Hand(new String[]{"H5", "C2", "D7", "S3", "C4"});
        EasyComputer computer = new EasyComputer();

        Hand swapCards = computer.getComputerSwapCards(hand);

        assertEquals(new Hand(new String[]{"C2", "S3", "C4"}).getHandOfCards(), swapCards.getHandOfCards());
    }



    @Test
    public void testComputerPlays_NoTrumpSuit() {

        Hand competitorHand = new Hand(new String[]{"H5", "C2", "D7"});
        Hand cardsPlayedInRound = new Hand();
        EasyComputer computer = new EasyComputer();
        Card playedCard = computer.computerPlays(competitorHand, cardsPlayedInRound);

        assertEquals(competitorHand.getFirstCard(), playedCard);
    }

}
