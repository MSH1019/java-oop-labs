package card;

import communication.ConsoleInOut;
import communication.InOutInterface;
import communication.YesOrNo;
import card.entity.Card;
import card.entity.Hand;
import card.entity.Player;
import card.entity.PlayerType;
import card.game.snap.Snap;
import card.game.twenty_one.TwentyOneAction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MockGameTest {

    private Game game;  
    private Scanner mockScanner;
    private InOutInterface mockInOut;
    private Snap snapGame;

    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
        mockInOut = mock(ConsoleInOut.class);
        snapGame = new Snap();

        game = new Game() {
            @Override protected void beforePlayOfRound() {}
            @Override protected void afterPlayOfRound() {}
            @Override protected void userPlays(Player player) {}
            @Override protected void computerPlays(Player player) {}
            @Override protected void initiate() {}
        };

        game.setInOut(mockInOut);
        game.setOutputOn(false);
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("1,Player", "2,Computer Player");  
        game.setLoadScanner(mockScanner, Game.PLAYER_NAME_FILE);
    }

    @Test
    void testGetComputerPlayersNamesDealer() {

        when(mockScanner.hasNextLine()).thenReturn(true, false);
        when(mockScanner.nextLine()).thenReturn("DEALER,Derek");

        game.setLoadScanner(mockScanner, Game.PLAYER_NAME_FILE);


        assertEquals("Derek", game.getComputerPlayersNames().get(0));
    }


    @Test
    void testGetComputerPlayersNamesSecondComputer() {
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("COMPUTER,Derek", "COMPUTER,Xi");
        game.setLoadScanner(mockScanner, Game.PLAYER_NAME_FILE);
        assertEquals("Xi", game.getComputerPlayersNames().get(1));
    }


    @Test
    void testCreateComputerCompetitors() {
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("DEALER,Derek", "COMPUTER,Xi");
        game.setLoadScanner(mockScanner, Game.PLAYER_NAME_FILE);
        game.createComputerCompetitors(2);
        assertEquals("Derek", game.getPlayer(0).getName());
    }


    @Test
    void testGetInputInteger() {
        when(mockInOut.getInputInteger(anyString())).thenReturn(2);
        game.setInOut(mockInOut);
        int result = game.inOut.getInputInteger("Please Enter a number: ");
        assertEquals(2, result);
    }

    @Test
    void testGetInputString() {
        when(mockInOut.getInputString(anyString())).thenReturn("Derek");
        game.setInOut(mockInOut);
        String result = game.inOut.getInputString("Please Enter your name: ");
        assertEquals("Derek", result);
    }

    @Test
    void testGetNumberOfPlayers() {
        when(mockInOut.getInputIntegerBetween(anyString(), anyInt(), anyInt())).thenReturn(3);
        game.setInOut(mockInOut);
        int result = game.getNumberOfPlayers();
        assertEquals(3, result);
    }

    @Test
    void testInitiatePlayers() {
        when(mockInOut.getInputString(anyString())).thenReturn("Player");
        when(mockInOut.getInputIntegerBetween(anyString(), anyInt(), anyInt())).thenReturn(3);

        game.setInOut(mockInOut);
        game.initiatePlayers(3, "Player");

        assertEquals(3, game.getPlayersSize());
}


@Test
void testPlayerPlaysHand_SnapYes() {
    Player player = new Player(PlayerType.USER, "Player");
    Hand mockHand = mock(Hand.class);
    Hand mockDiscardPile = mock(Hand.class);

    when(mockInOut.getYesOrNo(anyString())).thenReturn(YesOrNo.YES);
    when(mockDiscardPile.getLastCard()).thenReturn(new Card("C5"));
    when(mockDiscardPile.getSecondLastCard()).thenReturn(new Card("C5"));
    when(mockHand.playACard()).thenReturn(new Card("C5"));

    player.addHand(mockHand);  
    snapGame.setDiscardPile(mockDiscardPile);
    snapGame.setInOut(mockInOut);
    snapGame.addPlayer(player);
    snapGame.playerPlaysHand(player);

    assertEquals(1, player.getScore());
}




@Test
void testPlayerPlaysHand_SnapYesButWrongCards() {
    Player player = new Player(PlayerType.USER, "Player");
    Hand mockHand = mock(Hand.class);
    Hand mockDiscardPile = mock(Hand.class);
    when(mockInOut.getYesOrNo(anyString())).thenReturn(YesOrNo.YES);
    when(mockDiscardPile.getLastCard()).thenReturn(new Card("C5"));
    when(mockDiscardPile.getSecondLastCard()).thenReturn(new Card("H3"));
    when(mockHand.playACard()).thenReturn(new Card("C5"));

    player.addHand(mockHand);
    
    snapGame.setDiscardPile(mockDiscardPile);
    snapGame.setInOut(mockInOut);
    snapGame.addPlayer(player);
    snapGame.playerPlaysHand(player);
    assertEquals(-1, player.getScore());
}



@Test
void testPlay_SnapYesMatchingLastTwoCards() {
    Snap snapGame = spy(new Snap());
    InOutInterface mockInOut = mock(ConsoleInOut.class);
    Hand mockDiscardPile = mock(Hand.class);
    Player spyPlayer = spy(new Player(PlayerType.USER, "Player"));
    snapGame.addPlayer(spyPlayer);

    when(mockDiscardPile.getLastCard()).thenReturn(new Card("D7"));
    when(mockDiscardPile.getSecondLastCard()).thenReturn(new Card("D7"));
    when(mockInOut.getYesOrNo(anyString())).thenReturn(YesOrNo.YES);
    
    snapGame.setDiscardPile(mockDiscardPile);
    snapGame.setInOut(mockInOut);
    snapGame.play();
    
    verify(snapGame, atLeastOnce()).playerPlaysHand(any(Player.class));
    
    assertEquals(0, spyPlayer.getScore());
}
}
