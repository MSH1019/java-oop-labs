package card.game.hearts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import card.entity.Hand;
import card.entity.PlayerType;
import card.entity.Player;

class HeartsTest {

    Hearts hearts = new Hearts();
    List<String> computerNames = new ArrayList<>();

    @Test
    void beforePlayOfRound(){
        hearts.beforePlayOfRound();
        assertEquals(0, hearts.cardsPlayedInRound.size());
    }

    @Test
    void determineWinnerOfRound(){
        Hand hand = new Hand("D3,DK,H3,D8");
        hearts.getPlayers().add(new Player(PlayerType.USER, "Derek"));
        hearts.createComputerCompetitors(2);
        assertEquals(hearts.getPlayers().get(1), hearts.determineWinnerOfRound(hand));
    }

    @Test
    void determineWinnerOfRoundStarter(){
        Hand hand = new Hand("D3,DK,H3,D8");
        hearts.getPlayers().add(new Player(PlayerType.USER, "Derek"));
        hearts.initiatePlayers(4, "Derek");;
        hearts.setPlayerToStart(2);
        Player winner = hearts.determineWinnerOfRound(hand);
        assertEquals(3, hearts.getPlayerToStart() );
    }
    
    @Test
    void determineWinnerOfRoundStarterThree(){
        Hand hand = new Hand("D3,DK,H3,D8");
        hearts.getPlayers().add(new Player(PlayerType.USER, "Derek"));
        hearts.initiatePlayers(4, "Derek");;
        hearts.setPlayerToStart(3);
        Player winner = hearts.determineWinnerOfRound(hand);
        assertEquals(0, hearts.getPlayerToStart() );
    }

    @Test
    void afterPlayOfRoundScore(){
        Hand hand = new Hand("D3,DK,H3,D8");
        hearts.getPlayers().add(new Player(PlayerType.USER, "Derek"));
        hearts.initiatePlayers(4, "Derek");;
        hearts.setPlayerToStart(3);
        hearts.cardsPlayedInRound = hand;
        hearts.getPlayer(0).addHand(new Hand());
        hearts.afterPlayOfRound();
        assertEquals(1, hearts.getPlayer(0).getScore() );
    }

    @Test
    void determineScore(){
        Hand hand = new Hand("D3,HK,H3,D8");
        assertEquals(2, hearts.determineScore(hand));
    }

    @Test
    void determineScoreWithQueenOfClubs(){
        Hand hand = new Hand("D3,DK,H3,SQ");
        assertEquals(14, hearts.determineScore(hand));
    }

    @Test
    void afterPlayOfRound(){
        Player user = new Player(PlayerType.USER, "Derek");
        user.addHand(new Hand());
        hearts.getPlayers().add(user);
        hearts.createDealer("Dealer");
        hearts.createComputerCompetitors(2);
        hearts.cardsPlayedInRound.addCards("D3,DK,H3,D8");
        hearts.getPlayer(1).addHand(new Hand());
        hearts.afterPlayOfRound();
        assertEquals(1, hearts.getPlayer(1).getScore());
    }

    @Test
    void afterPlayOfRoundFinished(){
        hearts.createHumanPlayer("Derek");
        hearts.createComputerCompetitors(2);
        hearts.cardsPlayedInRound.addCards("D3,DK,H3,D8");
        hearts.getPlayer(0).addHand(new Hand());
        hearts.afterPlayOfRound();
        assertTrue(hearts.getFinishGame());
    }

}