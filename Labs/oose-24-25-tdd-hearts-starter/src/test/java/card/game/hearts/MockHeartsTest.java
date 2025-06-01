package card.game.hearts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import card.entity.Hand;

public class MockHeartsTest {

    Hearts hearts = new Hearts();
    Hand hand = new Hand("DK,DQ,D3,D4,D5,D6,D7,H2,H3,H4,H5,H6,C4");
    Scanner mockScanner = mock(Scanner.class);

    @BeforeEach
    void setUp(){
        hearts.setOutputOn(false);
        hearts.setConsoleScanner(mockScanner);
    }

    @Test
    void testRequestHumanSwapCards() {
        when(mockScanner.nextLine()).thenReturn("DK,DQ,D3");
        Hand swappedCards = hearts.requestHumanSwapCards(hand, 3);

        assertEquals(new Hand("DK,DQ,D3").getHandOfCards(), swappedCards.getHandOfCards());
    }
  


    @Test
    void testHumanSwapsCardsTwice(){
        when(mockScanner.nextLine()).thenReturn("DK,D3,D8", "DK,D3,DQ");
        Hand competitorHand = new Hand("C2,C3,C4");
        Hand swappedCards = hearts.humanSwapsCards(hand, competitorHand);

        assertEquals(new Hand("DK,D3,D8").getHandOfCards(), swappedCards.getHandOfCards());
}


    @Test
    void testSwapCards(){
        hearts.initiatePlayers(4, "Derek");
        hearts.getUser().addHand(hand);
        hearts.getPlayer(1).addHand(new Hand("DA,D2,H3,D4,D5,D6,D7,D8,D9,D10,DJ,DQ,DK"));
        
        when(mockScanner.nextLine()).thenReturn("DK,D3,DQ");
        hearts.swapCards(1);

        assertEquals(13, hearts.getPlayer(1).getHand().size());
    }




    @Test
    void testDetermineScore_OnlyHearts() {
        Hand hand = new Hand("H2,H5,H10");
        int score = hearts.determineScore(hand);
        assertEquals(3, score, "Each heart gives 1 point");
    }

    @Test
    void testDetermineScore_AllHearts() {
        Hand hand = new Hand("H2,H3,H4,H5,H6,H7,H8,H9,H10,HJ,HQ,HK,HA");
        int score = hearts.determineScore(hand);
        assertEquals(13, score, "All hearts have to give 13 points");
    }

    @Test
    void testDetermineScore_OnlyQueenOfSpades() {
        Hand hand = new Hand("SQ");
        int score = hearts.determineScore(hand);
        assertEquals(13, score, "The Queen of Spades gives 13 points");
    }

    @Test
    void testDetermineScore_MixedCards() {
        Hand hand = new Hand("H3,H6,H8,SQ");
        int score = hearts.determineScore(hand);
        assertEquals(16, score, "Hearts gives 3 points and SQ should give 13 points");
    }

}
