package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.ArrayList;

import card.entity.PlayerType;
import card.entity.Player;

public class GameTest {

    private Game game = new Game(){
        @Override
        protected void beforePlayOfRound(){

        }
        @Override
        protected void afterPlayOfRound(){

        }
        @Override
        protected void userPlays(Player player){

        }
        @Override
        protected void computerPlays(Player player){

        }
        @Override
        protected void initiate(){

        }
    };

    @Test
    void testAddPlayerCount() {
        Player player = new Player(PlayerType.USER, "Derek");
        game.addPlayer(player);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    void testAddPlayerName() {
        String name = "Derek";
        Player player = new Player(PlayerType.USER, name);
        game.addPlayer(player);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testClearPlayers() {
        Player player = new Player(PlayerType.USER, "Derek");
        game.addPlayer(player);
        game.clearPlayers();
        assertEquals(0, game.getPlayersSize());
    }

    @Test
    void testCreatePlayerCount(){
        game.createPlayer(PlayerType.USER, "Derek");
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    void testCreatePlayerName(){
        String name = "Derek";
        game.createPlayer(PlayerType.USER, name);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testCreateHumanPlayer(){
        String name = "Derek";
        game.createHumanPlayer(name);
        assertEquals(name, game.getUser().getName());
    }

    @Test
    void testGetNextComputerNameFirst(){
        List<String> names = new ArrayList<String>();
        names.add("Derek");
        names.add("Xi");
        names.add("Fredric");
        assertEquals("Derek", game.getNextComputerName(names));
    }

    @Test
    void testGetNextComputerNameSecond(){
        List<String> names = new ArrayList<String>();
        names.add("Derek");
        names.add("Xi");
        names.add("Fredric");
        String firstName = game.getNextComputerName(names);
        assertEquals("Xi", game.getNextComputerName(names));
    }

    @Test
    void testInitiatePlayers() {
        game.initiatePlayers(3, "Derek");
        assertEquals(3, game.getPlayersSize());
    }

    @Test
    void testInitiatePlayersComputer() {
        game.initiatePlayers(3, "Derek");
        assertEquals(PlayerType.COMPUTER, game.getPlayer(1).getCompetitorType());
    }

    @Test
    void testResetPlayers(){
        game.initiatePlayers(3, "Derek");
        game.getUser().setWinner(true);
        game.resetPlayers();
        assertFalse(game.getUser().hasWon());
    }

    @Test
    void testDetermineWinnerByScoreDecrease(){
        game.initiatePlayers(3, "Derek");
        game.getPlayer(0).setScore(20);
        game.getPlayer(1).setScore(18);
        game.getPlayer(2).setScore(16);
        assertEquals(game.getUser(), game.determineWinner());
    }   

    @Test
    void testDetermineWinnerByScoreIncrease(){
        game.initiatePlayers(3, "Derek");
        game.getPlayer(0).setScore(16);
        game.getPlayer(1).setScore(18);
        game.getPlayer(2).setScore(20);
        assertEquals(game.getPlayer(2), game.determineWinner());
    }   

    @Test
    void testDetermineWinnerByScoreDecreaseWithWinner(){
        game.initiatePlayers(3, "Derek");
        game.getPlayer(0).setScore(20);
        game.getPlayer(1).setScore(18);
        game.getPlayer(2).setScore(16);
        game.getPlayer(2).setWinner(true);
        assertEquals(game.getPlayer(2), game.determineWinner());
    }   

    @Test
    void testDetermineWinnerByScoreIncreaseWithWInner(){
        game.initiatePlayers(3, "Derek");
        game.getPlayer(0).setScore(16);
        game.getPlayer(0).setWinner(true);
        game.getPlayer(1).setScore(18);
        game.getPlayer(2).setScore(20);
        assertEquals(game.getUser(), game.determineWinner());
    }   

    @Test
    void testSetFinishGame() {
        game.setFinishGame(true);
        assertTrue(game.finishGame);

    }
}
