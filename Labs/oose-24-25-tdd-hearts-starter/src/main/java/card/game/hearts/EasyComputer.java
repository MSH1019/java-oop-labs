package card.game.hearts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import card.entity.Card;
import card.entity.Hand;

public class EasyComputer {
    

    public Hand getComputerSwapCards(Hand hand) {
        if (hand == null || hand.size() < 3) {
            return null;
        }

        List<Card> sortedCards = new ArrayList<>(hand.getHandOfCards());
        sortedCards.sort(Comparator.comparing(Card::getFaceCard));

        return new Hand(new String[]{
            sortedCards.get(0).toString(),
            sortedCards.get(1).toString(),
            sortedCards.get(2).toString()
        });

    }

    
    public Card computerPlays(Hand competitorHand, Hand cardsPlayedInRound) {
        if (competitorHand == null || competitorHand.isEmpty()) {
            return null;
        }
        if (cardsPlayedInRound == null || cardsPlayedInRound.isEmpty()) {
            return competitorHand.getFirstCard();
        }
        return competitorHand.getFirstCard();
    }
    

}
