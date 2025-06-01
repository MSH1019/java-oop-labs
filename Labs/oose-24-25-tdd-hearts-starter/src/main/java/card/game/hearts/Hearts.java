package card.game.hearts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import card.CardGame;
import card.entity.Card;
import card.entity.Hand;
import card.entity.Player;
import card.entity.Suit;
import card.entity.WriteDeck;
import utility.IntToWord;

import communication.WriteInOut;

public class Hearts extends CardGame {

    protected static int NO_OF_CARDS = 0;
    private static final int NUMBER_OF_PLAYERS = 4;
    private static final int SPECIAL_SCORE = 13;
    public static final Card SPECIAL_CARD = Card.getInstance("SQ");
    private static final Card STARTER_CARD = Card.getInstance("C2");
    public static final int NUMBER_OF_CARDS_TO_SWAP = 3;
    protected Hand cardsPlayedInRound = new Hand();
    private EasyComputer computer = new EasyComputer();
    private Scanner consoleScanner = new Scanner(System.in);

    Hearts(){
        this("");
    }

    Hearts(String override){
        super(override);
    }
    
    protected int getNumberOfPlayers() {
        return NUMBER_OF_PLAYERS;
    }

    protected int findPlayerWithCard(Card card){
        int counter = 0;
        boolean found = false;
        while (!found && counter < players.size()) {
            found = getPlayer(counter).getHand().hasCard(card);
        }
        return counter;
    }

    protected void remainingPlayers(int playerToPlay){
        int counter = 0;
        Player player = null;
        do {
            playerToPlay = playerToPlay % getPlayersSize();
            player = getPlayer(playerToPlay);
            playerPlaysARound(player);
            playerToPlay ++;
            counter ++;
        } while (counter < players.size() -1);
    }

    protected void playFirstRound(){
        int startingPlayer = findPlayerWithCard(STARTER_CARD);
        if (startingPlayer == USER_INDEX){
            print(getUser().toString());
            print("You must play " + STARTER_CARD.toString() + " to start");
            int userChoice = getCardToPlay();
            cardsPlayedInRound.add(getUser().getHand(0).playACard(userChoice));
        } else {
            getPlayer(startingPlayer).getHand().playACard(STARTER_CARD);
            cardsPlayedInRound.add(STARTER_CARD);
        }
        remainingPlayers(startingPlayer + 1);
    }

    protected void afterInitiate() {
        getUser().getHand().sortHand();
        swapCards(1);
        playFirstRound();
        determineWinnerOfRound(cardsPlayedInRound);
    }






    protected Hand requestHumanSwapCards(Hand playerHand, int numberToSwap) {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
    
        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Your hand: " + playerHand);
            System.out.println("Enter " + numberToSwap + " cards to swap:");
    
            String input = getInputString("Hello");
    
            Hand selectedCards = new Hand(input);
    
            if (selectedCards.getHandOfCards().size() == numberToSwap) {
                return selectedCards;
            }
            attempts++;
        }
        return null;
    }




    
    

    protected Hand humanSwapsCards(Hand playerHand, Hand computerCardsToSwap) {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
    
        while (attempts < MAX_ATTEMPTS) {
            Hand selectedCards = requestHumanSwapCards(playerHand, NUMBER_OF_CARDS_TO_SWAP);
    
            if (selectedCards != null) {
                for(Card card : selectedCards.getHandOfCards()) {
                    if(playerHand.hasCard(card)){
                        playerHand.remove(card);
                        playerHand.add(computerCardsToSwap.getFirstCard());
                        playerHand.addCards(computerCardsToSwap.getHandOfCards());
                        computerCardsToSwap.add(card);                
                        computerCardsToSwap.remove(computerCardsToSwap.getFirstCard());        
                        return selectedCards;
                    }
                }
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
            attempts++;
        }
        return null;
    }

    
    



    protected void swapCards(int playerUserSwapsWith) {
        if (USER_INDEX != playerUserSwapsWith) {
            Player humanCompetitor = getUser();
            Player computerCompetitor = getPlayer(playerUserSwapsWith);
            Hand computerHand = computerCompetitor.getHand();
            Hand computerCardsToSwap = computer.getComputerSwapCards(computerHand);
    

            System.out.println("Human Hand Before Swap: " + humanCompetitor.getHand());
            Hand humanHand = humanCompetitor.getHand();
            Hand humanCardsToSwap = humanSwapsCards(humanHand, computerCardsToSwap);
            
            for (Card card : computerCardsToSwap.getHandOfCards()) {
                computerHand.remove(card);
            }
            for (Card card : humanCardsToSwap.getHandOfCards()) {
                humanHand.remove(card);
            }
            computerHand.addCards(humanCardsToSwap);
            humanHand.addCards(computerCardsToSwap);
            humanHand.sortHand();
            computerHand.sortHand();
        }
    }
    
    
    


    protected void beforePlayOfRound() {
        cardsPlayedInRound.clear();
    }

    protected Player determineWinnerOfRound(Hand cardsPlayedInRound) {
        int playerCounter = getPlayerToStart();
        int cardCounter = 0;
        Card competitorCard = cardsPlayedInRound.getCard(cardCounter);
        Suit firstCardSuit = competitorCard.getSuit();
        int maxFaceCard = 0;
        Player winningCompetitor = null;
        while (cardCounter < getPlayersSize()) {
            competitorCard = cardsPlayedInRound.getCard(cardCounter);
            if (cardsPlayedInRound.getCard(cardCounter).getSuit() == firstCardSuit
                    && maxFaceCard < competitorCard.getFaceCard().getRank()) {
                maxFaceCard = competitorCard.getFaceCard().getRank();
                winningCompetitor = getPlayer(playerCounter);
                setPlayerToStart(playerCounter);
            }
            cardCounter ++;
            playerCounter ++;
            playerCounter = playerCounter % getPlayersSize();
        }
        return winningCompetitor;
    }

    protected int determineScore(Hand hand) {
        int score = 0;
        for (Card card : hand.getHandOfCards()) {
            if (card.getSuit() == Suit.HEARTS) {
                score++;
            } else if (card == SPECIAL_CARD) {
                score += SPECIAL_SCORE;
            }
        }
        return score;
    }

    protected void afterPlayOfRound() {
        Player competitor = null;
        try {
            competitor = determineWinnerOfRound(cardsPlayedInRound);
        } catch (Exception exp){
            showPlayers();
            print(cardsPlayedInRound.toString());
            throw exp;
        }
        competitor.incrementScore(determineScore(cardsPlayedInRound));
        if (getUser().getHand().size() == 0) {
            finishGame = true;
        }
        print("Cards played: " + cardsPlayedInRound.toString());
    }

    protected boolean playerHasWon(Player player){
        return false;
    }

    protected Card getPlayerCardSameSuit(Player player, Suit suit){
        Card card = null;
        while (card == null || (card.getSuit() != suit && player.getHand().highestCardOfASuit(suit) != null)){
            card = getPlayersCard(player);
        }
        player.playACard(card);
        return card;
    }

    protected void userPlays(Player player) {
        print("Cards Played " + cardsPlayedInRound.toString());
        Card card = getPlayerCardSameSuit(player, cardsPlayedInRound.getTrumpSuit());
        player.getHand(0).playACard(card);
        cardsPlayedInRound.add(card);
    }

    protected void computerPlays(Player competitor) {
        Card card = computer.computerPlays(competitor.getHand(), cardsPlayedInRound);
        if (card != null) {
            cardsPlayedInRound.add(card);
            competitor.getHand().playACard(card);
        }
    }

    protected void showPlayers() {
        int minScore = 0;
        List<Player> winningOrder = new ArrayList<Player>();
        Player player = null;
        for (int counter = 0; counter < getPlayersSize(); counter++) {
            player = getPlayer(counter);
            if (minScore > player.getScore()) {
                minScore = player.getScore();
                winningOrder.add(0, player);
            } else {
                winningOrder.add(winningOrder.size(), player);
            }
        }
        super.showPlayers();
    }

    public static void main(String[] args) {
        String override = "";
        Hearts hearts = new Hearts(override);
        hearts.setNO_OF_CARDS(Hearts.NO_OF_CARDS);
        hearts.play();
    }
}
