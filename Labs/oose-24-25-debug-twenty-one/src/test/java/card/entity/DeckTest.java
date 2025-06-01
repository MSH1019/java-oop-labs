package card.entity;

import org.junit.jupiter.api.Test;

import card.entity.Deck;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();

    @Test
    void generateDeck() {
        assertEquals(52, deck.size());
    }

}