package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.ArrayList;

import card.entity.PlayerType;
import card.entity.Player;
import card.Game;

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
        String name = "Mohamed";
        Player player = new Player(PlayerType.USER, name);
        game.addPlayer(player);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testClearPlayers() {
        String name = "Mohamed";
        Player player = new Player(PlayerType.USER, name);
        game.addPlayer(player);
        game.clearPlayers();
        assertEquals(0, game.getPlayersSize());
    }

    @Test
    void testCreatePlayerCount(){
        String name = "Mohamed";
        game.createPlayer(PlayerType.USER, name);
        assertEquals(1, game.getPlayersSize());

    }

    @Test
    void testCreatePlayerName(){
        String name = "Mohamed";
        game.createPlayer(PlayerType.USER, name);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testCreateHumanPlayer(){
        String name = "Mohamed";
        game.createHumanPlayer(name);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testGetNextComputerNameFirst(){
        List<String> names = new ArrayList<>(List.of("Mohamed", "MohamedAgain"));
        assertEquals("Mohamed", game.getNextComputerName(names)); // Ensure the first name is returned

    }

    @Test
    void testGetNextComputerNameSecond(){
        List<String> names = new ArrayList<>(List.of("Mohamed", "MohamedAgain"));
        game.getNextComputerName(names);
        assertEquals("MohamedAgain", game.getNextComputerName(names));

    }

    @Test
    void testInitiatePlayers() {
        game.initiatePlayers(3, null);
        assertEquals(3, game.getPlayersSize());

    }

    @Test
    void testInitiatePlayersComputer() {
        game.initiatePlayers(3, null);
        assertEquals(PlayerType.COMPUTER, game.getPlayer(1).getCompetitorType());
    }

    @Test
    void testResetPlayers(){
        game.initiatePlayers(1, "Mohamed");
        game.getUser().setWinner(true);
        game.resetPlayers();
        assertFalse(game.getUser().hasWon());
    }

    @Test
    void testDetermineWinnerByScoreDecrease(){
        game.initiatePlayers(3, null);

        List<Player> players = game.getPlayers();
        players.get(0).setScore(100);
        players.get(1).setScore(80);
        players.get(2).setScore(60);

        Player winner = game.determineWinner();
        
        assertEquals(game.getUser(), winner);
    }   

    @Test
    void testDetermineWinnerByScoreIncrease(){
        game.initiatePlayers(3, null);

        List<Player> players = game.getPlayers();
        players.get(0).setScore(60);
        players.get(1).setScore(80);
        players.get(2).setScore(100);

        Player winner = game.determineWinner();
        
        assertEquals(players.get(2), winner);
        assertTrue(players.get(2).hasWon());
    }   

    @Test
    void testDetermineWinnerByScoreDecreaseWithWinner(){
        game.initiatePlayers(3, null);

        List<Player> players = game.getPlayers();
        players.get(0).setScore(100);
        players.get(1).setScore(80);
        players.get(2).setScore(60);

        players.get(2).setWinner(true);

        Player winner = game.determineWinner();
        
        assertEquals(players.get(2), winner);
        assertTrue(players.get(2).hasWon());
  
    }   

    @Test
    void testDetermineWinnerByScoreIncreaseWithWInner(){
        game.initiatePlayers(3, null);

        List<Player> players = game.getPlayers();
        players.get(0).setScore(60);
        players.get(1).setScore(80);
        players.get(2).setScore(100);

        players.get(0).setWinner(true);

        Player winner = game.determineWinner();
        
        assertEquals(players.get(0), winner);
        assertTrue(players.get(0).hasWon());
        
    }   

    @Test
    void testSetFinishGame() {
        game.setFinishGame(true);

        assertTrue(game.finishGame);

        game.setFinishGame(false);

        assertFalse(game.finishGame);
    }

    
}

