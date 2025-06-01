package card.game.snap;

import communication.WriteInOut;
import communication.YesOrNo;
import card.CardGame;
import card.entity.Hand;
import card.entity.Player;
import card.entity.WriteDeck;

public class Snap extends CardGame{

    public final static String ASK_WANT_TO_SNAP = "Do you want to Snap?";
    public final static String ASK_DISCARD_PILE = "Discard Pile";
    private final static int ROUNDS_TO_WIN = 2;
    private final static int NUMBER_OF_PLAYERS = 2;
    protected static int NO_OF_CARDS = 0;

    public Snap(String override){
        super(override);
        setNO_OF_CARDS(NO_OF_CARDS);
    }

    public Snap(){
        this("");
    }

    protected int getNumberOfPlayers(){
        return NUMBER_OF_PLAYERS;
    }

    protected void hasSnapped(YesOrNo isSnap, Hand discardPile){
            if (isSnap == YesOrNo.YES && discardPile.getLastCard().getFaceCard() == discardPile.getSecondLastCard().getFaceCard()){
                getPlayer(USER_INDEX).incrementScore(1);
            } else if (isSnap == YesOrNo.YES) {
                getPlayer(USER_INDEX).incrementScore(-1);
            }
    }

    public void playerPlaysHand(Player player) {
        discardPile.add(player.getHand().playACard());
        displayCard(ASK_DISCARD_PILE, discardPile.getLastCard());
        YesOrNo isSnap = inOut.getYesOrNo(ASK_WANT_TO_SNAP);
        hasSnapped(isSnap, discardPile);
        print("You have scored " + getUser().getScore());
        if (getUser().getScore() >= ROUNDS_TO_WIN){
            getUser().setWinner(true);
            setFinishGame(true);    
        }
    }

    protected int getScore(Player player) {
        return player.getScore();
    }

    protected void beforeInitiate(){
        discardPile.add(playACard());
        displayCard(ASK_DISCARD_PILE, discardPile.getLastCard());
    }

    public static void main(String[] args) {
        String override = "S3,H3,D3,C3";
        Snap snap = new Snap(override);
        snap.setDeck(new WriteDeck(override, snap.getClassName()));
        snap.setInOut(new WriteInOut(snap.getClassName()));
        snap.play();
    }
}
